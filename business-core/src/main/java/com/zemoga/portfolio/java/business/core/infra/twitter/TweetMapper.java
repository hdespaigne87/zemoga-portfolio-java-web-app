package com.zemoga.portfolio.java.business.core.infra.twitter;

import com.zemoga.portfolio.java.business.core.domain.entities.TweetModel;
import org.mapstruct.Mapper;
import org.springframework.social.twitter.api.Tweet;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TweetMapper {

    TweetModel toDomainModel(Tweet jpaModel);

    List<TweetModel> toDomainModel(List<Tweet> list);
}
