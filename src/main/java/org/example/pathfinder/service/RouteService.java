package org.example.pathfinder.service;

import jakarta.transaction.Transactional;
import org.example.pathfinder.data.RouteRepository;
import org.example.pathfinder.exception.RouteNotFoundException;
import org.example.pathfinder.model.CategoryType;
import org.example.pathfinder.model.Picture;
import org.example.pathfinder.model.Route;
import org.example.pathfinder.service.dto.RouteDetailsDTO;
import org.example.pathfinder.service.dto.RouteShortInfoDTO;
import org.example.pathfinder.web.dto.AddRouteDTO;
import org.example.pathfinder.web.dto.RouteCategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }

    @Transactional
    public List<RouteShortInfoDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();
    }

    @Transactional
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        if (route.isEmpty()) {
            //TODO return null
        }
        return mapToShortInfo(route.get());
    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {

        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();

        dto.setImageUrl(first.get().getUrl());

        return dto;
    }

    public boolean add(AddRouteDTO data, MultipartFile gpxFile) throws IOException {
        Route toInsert = modelMapper.map(data, Route.class);

        Path destinationFile = Paths
                .get("src", "main", "resources", "uploads", "file.gpx")
                .normalize()
                .toAbsolutePath();

        try (InputStream inputStream = gpxFile.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        }


        // originalFilename, fileLocation ->  /uploads/{userId}/{fileId}.{ext}

        return false;
    }

    public RouteDetailsDTO getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found"));

        RouteDetailsDTO dto = modelMapper.map(route, RouteDetailsDTO.class);
        dto.setVideoUrl("https://www.youtube.com/embed/" + dto.getVideoUrl());
        dto.setImageUrls(List.of("/images/pic4.jpg", "/images/pic1.jpg"));


        return dto;
    }

    public List<RouteCategoryDTO> getRouteByCategory(CategoryType category) {
        List<Route> allByCategoryName = routeRepository.findAllByCategories_Name(category);

        return allByCategoryName.stream()
                .map(route -> modelMapper.map(route, RouteCategoryDTO.class))
                .toList();
    }

    @Transactional
    public RouteCategoryDTO getMostCommentedRoute() {
        Route mostCommentedRoute = routeRepository
                .findAll()
                .stream()
                .max(Comparator.comparingInt(route -> route.getComments().size()))
                .orElse(null);

        RouteCategoryDTO routeDTO = modelMapper.map(mostCommentedRoute, RouteCategoryDTO.class);
        routeDTO.setImageUrl("http://res.cloudinary.com/ch-cloud/image/upload/v1630581072/d47iy8kxv6qni8euhojk.jpg");

        return routeDTO;
    }
}
