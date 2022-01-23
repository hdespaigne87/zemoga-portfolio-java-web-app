package com.zemoga.portfolio.java.business.core.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@EqualsAndHashCode(of = {"idportfolio"})
@ToString(of = {"idportfolio"})
public class ProfileModel {

    private Long idportfolio;
    private String description;
    private String experienceSummary;
    private Long id;
    private String imageUrl;
    private String lastNames;
    private String names;
    private String title;
    private String twitterUserId;
    private String twitterUserName;
    private String userId;
    private List<TweetModel> tweets;

    public void updateFrom(ProfileModel profileModel) {
        /*
            Here whe can put all the business logic we need
            on the update process. Maybe registering domain events to
            dispatch them after the successful insertion in database,
            if we are using, for example, an event-driven architecture
            for communication between microservices
        */
        BeanUtils.copyProperties(profileModel, this);
    }
}
