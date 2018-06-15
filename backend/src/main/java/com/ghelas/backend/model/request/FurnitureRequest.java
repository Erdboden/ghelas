package com.ghelas.backend.model.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public class FurnitureRequest {
    private Long id;
    private String title;
    private String description;
    private MultipartFile coverImage;
    private Collection<MultipartFile> gallery;

    public FurnitureRequest() {
    }

    public FurnitureRequest(String title, String description, MultipartFile coverImage, Collection<MultipartFile> gallery) {
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
        this.gallery = gallery;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }

    public Collection<MultipartFile> getGallery() {
        return gallery;
    }

    public void setGallery(Collection<MultipartFile> gallery) {
        this.gallery = gallery;
    }

    @Override
    public String toString() {
        return "FurnitureRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverImage=" + coverImage +
                ", gallery=" + gallery +
                '}';
    }
}
