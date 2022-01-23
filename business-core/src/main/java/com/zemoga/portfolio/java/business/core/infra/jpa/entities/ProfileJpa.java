package com.zemoga.portfolio.java.business.core.infra.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"idportfolio"})
@ToString(of = {"idportfolio"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "portfolio")
public class ProfileJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idportfolio;
    private String description;
    @Column(name = "experience_summary")
    private String experienceSummary;
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "last_names")
    private String lastNames;
    private String names;
    @Column(name = "tittle")
    private String title;
    @Column(name = "twitter_user_id")
    private String twitterUserId;
    @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Column(name = "user_id")
    private String userId;
}
