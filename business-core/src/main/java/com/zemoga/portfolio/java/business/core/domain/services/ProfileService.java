package com.zemoga.portfolio.java.business.core.domain.services;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;
import com.zemoga.portfolio.java.business.core.domain.repositories.ProfileRepositoryPort;
import com.zemoga.portfolio.java.business.core.domain.repositories.TwitterRepositoryPort;
import com.zemoga.portfolio.java.business.core.exceptions.EntityNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepositoryPort profileRepositoryPort;
    private final TwitterRepositoryPort twitterRepositoryPort;

    public ProfileModel getProfileInfoById(Long idportfolio, Integer profileMaxTweets) {
        ProfileModel profileModel = profileRepositoryPort.findById(idportfolio)
                .orElseThrow(() -> new EntityNotFound(ProfileModel.class, idportfolio));
        if (profileMaxTweets != null)
            profileModel.setTweets(twitterRepositoryPort.findAllByUsername(profileModel.getTwitterUserName(), profileMaxTweets));
        return profileModel;
    }

    public ProfileModel updateProfile(ProfileModel profileModel) {
        ProfileModel profileInDB = profileRepositoryPort.findById(profileModel.getIdportfolio())
                .orElseThrow(() -> new EntityNotFound(ProfileModel.class, profileModel.getIdportfolio()));
        profileInDB.updateFrom(profileModel);
        return profileRepositoryPort.save(profileInDB);
    }
}
