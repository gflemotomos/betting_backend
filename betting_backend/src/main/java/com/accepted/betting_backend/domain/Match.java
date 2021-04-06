package com.accepted.betting_backend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Date match_date;

    @Size(max = 5)
    @NotNull
    private String match_time;

    @NotNull
    private String team_a;

    @NotNull
    private String team_b;

    @NotNull
    private Short sport;

    @OneToMany(targetEntity=MatchOdds.class, mappedBy="match_id",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MatchOdds> matchOdds;
}
