package com.zemoga.portfolio.java.business.core.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"idportfolio"})
@ToString(of = {"idportfolio"})
public class TweetModel {

    private String profileImageUrl;
    private String fromUser;
    private String text;
}
