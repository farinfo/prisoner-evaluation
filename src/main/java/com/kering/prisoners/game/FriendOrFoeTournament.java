package com.kering.prisoners.game;

import com.kering.prisoners.Prisoner;

import java.util.List;

public class FriendOrFoeTournament {
    List<Prisoner> prisoners;

    public FriendOrFoeTournament(List<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }


    public void play(int nbRounds) {
        throw new UnsupportedOperationException();
    }

    public List<Prisoner> getTopThreeWinners() {
        throw new UnsupportedOperationException();
    }

}
