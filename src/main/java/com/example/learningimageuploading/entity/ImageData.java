package com.example.learningimageuploading.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "image_data")
    private byte[] imageData;
}
