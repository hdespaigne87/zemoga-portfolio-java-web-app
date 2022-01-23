package com.zemoga.portfolio.java.business.core.infra.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {
    @Value("${twitter.api.key}")
    private String apiKey;
    @Value("${twitter.api.secret.key}")
    private String apiSecretKey;
    @Value("${twitter.access.token}")
    private String accessToken;
    @Value("${twitter.access.token.secret}")
    private String accessTokenSecret;

    @Bean
    TwitterTemplate getTwitterTemplate(){
        return new TwitterTemplate(apiKey, apiSecretKey, accessToken, accessTokenSecret);
    }
}

