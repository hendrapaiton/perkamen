package com.lastare.perkamen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", "Perkamen System");
        return "index";
    }
}
