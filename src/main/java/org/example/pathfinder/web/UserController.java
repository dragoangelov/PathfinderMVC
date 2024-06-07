package org.example.pathfinder.web;

import jakarta.validation.Valid;
import org.example.pathfinder.web.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("users/register")
    public String viewRegister(Model model) {
        model.addAttribute("registerData", new UserRegisterDTO());

        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(@Valid UserRegisterDTO data, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);

            return "register";
        }

        return "redirect:/users/login";
    }

    @GetMapping("users/login")
    public String viewLogin() {
        return "login";
    }

}
