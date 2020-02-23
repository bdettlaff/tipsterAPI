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
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long betId;

    private Long ticketNumber;

    /*private User userId;
    private Event eventId;*/

    private String dateOfBet;

    private int roundsFirstTeam;

    private int roundsSecondTeam;

    private int amount;

    private int probableWin;

}

