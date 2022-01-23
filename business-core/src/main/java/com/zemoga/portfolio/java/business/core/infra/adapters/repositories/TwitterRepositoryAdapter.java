package com.zemoga.portfolio.java.business.core.infra.adapters.repositories;

import com.zemoga.portfolio.java.business.core.domain.entities.TweetModel;
import com.zemoga.portfolio.java.business.core.domain.repositories.TwitterRepositoryPort;
import com.zemoga.portfolio.java.business.core.infra.twitter.TweetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TwitterRepositoryAdapter implements TwitterRepositoryPort {

    private final Twitter twitter;
    private final TweetMapper tweetMapper;

    @Override
    public List<TweetModel> findAllByUsername(String twitterUserId, int maxResults) {
        return tweetMapper.toDomainModel(twitter.timelineOperations()
                .getUserTimeline(twitterUserId)
                .stream()
                .limit(maxResults)
                .collect(Collectors.toList()));
    }
}
