package com.tipester.tipster.entities.betModule;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private String team;

    private int wonRounds;

    private int lostRounds;

    private int wins;

    private int loses;

    private int draws;

    private int playedMatches;
}
