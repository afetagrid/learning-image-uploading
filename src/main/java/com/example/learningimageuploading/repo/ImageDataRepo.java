package com.example.learningimageuploading.repo;

import com.example.learningimageuploading.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataRepo extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String fileName);
}
