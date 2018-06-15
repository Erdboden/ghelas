package com.ghelas.backend.model.response;

import com.ghelas.backend.model.Links;

import java.util.Collection;

public class FurnitureResponse {
    private Long id;
    private String title;
    private String description;
    private String coverImage;
    private Collection<String> gallery;
    private Links links;

    public FurnitureResponse() {
    }

    public FurnitureResponse(String title, String description, String coverImage, Collection<String> gallery, Links links) {
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
        this.gallery = gallery;
        this.links = links;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Collection<String> getGallery() {
        return gallery;
    }

    public void setGallery(Collection<String> gallery) {
        this.gallery = gallery;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "FurnitureResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", gallery=" + gallery +
                ", links=" + links +
                '}';
    }
}
