package org.example.pathfinder.web.dto;

public class RouteCategoryDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public RouteCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public RouteCategoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteCategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteCategoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteCategoryDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
