package com.zemoga.portfolio.java.business.core.domain.repositories;

import com.zemoga.portfolio.java.business.core.domain.entities.TweetModel;

import java.util.List;

public interface TwitterRepositoryPort {

    List<TweetModel> findAllByUsername(String twitterUserId, int maxResults);
}
