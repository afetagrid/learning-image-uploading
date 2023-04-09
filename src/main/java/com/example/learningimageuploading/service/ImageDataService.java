package com.example.learningimageuploading.service;

import com.example.learningimageuploading.entity.ImageData;
import com.example.learningimageuploading.repo.ImageDataRepo;
import com.example.learningimageuploading.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageDataService {

    private final ImageDataRepo repo;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repo.save(ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        return "File uploaded successfully, id: " + imageData.getId();
    }

    public byte[] downloadImage(Long id) {
        ImageData imageData = repo.findById(id).orElseThrow(() -> new IllegalStateException("File not found"));
        return ImageUtils.decompressImage(imageData.getImageData());
    }
}
