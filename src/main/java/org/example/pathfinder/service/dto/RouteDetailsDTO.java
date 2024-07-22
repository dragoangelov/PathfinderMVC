package org.example.pathfinder.service.dto;

import org.example.pathfinder.model.Level;

import java.util.List;

public class RouteDetailsDTO {

    private long id;
    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private String authorName;
    private List<String> imageUrls;

    public RouteDetailsDTO() {
    }

    public long getId() {
        return id;
    }

    public RouteDetailsDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public RouteDetailsDTO setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsDTO setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public RouteDetailsDTO setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public RouteDetailsDTO setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        return this;
    }
}
