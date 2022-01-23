package com.zemoga.portfolio.java.web.frontend.controllers;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;
import com.zemoga.portfolio.java.business.core.domain.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    @Value("${profile.default.id}")
    private Long profileDefaultId;
    @Value("${profile.max.tweets}")
    private Integer profileMaxTweets;
    private final ProfileService profileService;

    @GetMapping("/")
    public String index(Model model) {
        return viewProfileInfo(profileDefaultId, model);
    }

    @GetMapping("/viewProfileInfo/{idportfolio}")
    public String viewProfileInfo(@PathVariable(value = "idportfolio") Long idportfolio, Model model) {
        ProfileModel profileModel = profileService.getProfileInfoById(idportfolio, profileMaxTweets);
        model.addAttribute("profile", profileModel);
        return "profileInfo";
    }
}
