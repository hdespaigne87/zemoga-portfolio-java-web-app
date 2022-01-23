package com.zemoga.portfolio.java.rest.api.controllers;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;
import com.zemoga.portfolio.java.business.core.domain.services.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Api(tags = "Profiles")
public class ProfileRestController {

    private final ProfileService profileService;

    @GetMapping("/{idportfolio}")
    @ApiOperation(value = "Gets a profileModel information from the database", nickname = "Get Profile Info")
    public ResponseEntity<ProfileModel> getProfileInfo(@PathVariable("idportfolio") Long idportfolio) {
        ProfileModel profileModel = profileService.getProfileInfoById(idportfolio, null);
        return new ResponseEntity<>(profileModel, HttpStatus.OK);
    }

    @PutMapping("/{idportfolio}")
    @ApiOperation(value = "Updates a profileModel information on the database", nickname = "Update Profile Info")
    public ResponseEntity<ProfileModel> updateProfile(@PathVariable("idportfolio") Long idportfolio,
                                                      @RequestBody ProfileModel profileModel) {
        profileModel.setIdportfolio(idportfolio);
        profileModel = profileService.updateProfile(profileModel);
        return new ResponseEntity<>(profileModel, HttpStatus.OK);
    }
}
