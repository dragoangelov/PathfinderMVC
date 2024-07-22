package org.example.pathfinder.web;

import jakarta.validation.Valid;
import org.example.pathfinder.model.Category;
import org.example.pathfinder.model.CategoryType;
import org.example.pathfinder.model.Level;
import org.example.pathfinder.service.RouteService;
import org.example.pathfinder.service.dto.RouteShortInfoDTO;
import org.example.pathfinder.web.dto.AddRouteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAll();

        model.addAttribute("allRoutes", routes);

        return "routes";
    }

    @GetMapping("add-route")
    public ModelAndView addRoute() {
        ModelAndView modelAndView = new ModelAndView("add-route");

        modelAndView.addObject("route", new RouteShortInfoDTO());
        modelAndView.addObject("levels", Level.values());
        modelAndView.addObject("categoryTypes", CategoryType.values());

        return modelAndView;
    }

    @ModelAttribute("routeData")
    public AddRouteDTO routeData() {
        return new AddRouteDTO();
    }

    @PostMapping("/add-route")
    public String doAddRoute(
            @Valid AddRouteDTO data,
            @RequestParam("gpxCoordinates") MultipartFile file,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) throws IOException {
        // if (!valid) return errors

        routeService.add(data, file);

        return "redirect:/add-route";
    }

    @GetMapping("route/{id}")
    public ModelAndView addRoute(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("route-details");

        modelAndView.addObject("route", routeService.getDetails(id));

        return modelAndView;
    }

    @GetMapping("/routes/{category}")
    public ModelAndView getRoutesByCategory(@PathVariable CategoryType category) {
        String view = "";
        switch (category){
            case CAR -> view ="car";
            case BICYCLE -> view ="bicycle";
            case PEDESTRIAN -> view ="pedestrian";
            case MOTORCYCLE -> view ="motorcycle";
        }

        ModelAndView modelAndView = new ModelAndView(view);

        modelAndView.addObject("routes", routeService.getRouteByCategory(category));

        return modelAndView;
    }

}
