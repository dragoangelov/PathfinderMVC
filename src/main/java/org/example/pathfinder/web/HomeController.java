package org.example.pathfinder.web;

import org.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        double sofiaTemp = new Random().nextDouble();

        model.addAttribute("sofiaTemperature", sofiaTemp);
        model.addAttribute("commentedRoute", routeService.getMostCommentedRoute());

//        public ModelAndView index() {
//        ModelAndView mnv = new ModelAndView();
//        mnv.setViewName("index");
//        mnv.addObject("sofiaTemperature", sofiaTemp);
//        return mnv;
//        }

        return "index";
    }

    @GetMapping("/about")
    public ModelAndView index() {

        return new ModelAndView("about");
    }

}
