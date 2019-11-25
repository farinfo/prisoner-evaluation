package com.kering.prisoners.game;

import com.kering.prisoners.Prisoner;

import java.util.Optional;

public class GameResult {
   private Prisoner player1;
   private Prisoner player2;

    public GameResult(Prisoner player1, Prisoner player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public Optional<Prisoner> getWinner() {
        if(player1.getScore() > player2.getScore()) {
            return  Optional.of(player1);
        } else if (player1.getScore() < player2.getScore()){
            return Optional.of(player2);
        }
        return Optional.empty();
    }

    public boolean isDraw() {
        return player1.getScore()  == player2.getScore();
    }

    public void displayResult() {
        System.out.println("Game results : ");

        System.out.println(String.format("%s : %d", player1.getName(), player1.getScore()));
        System.out.println(String.format("%s : %d", player2.getName(), player2.getScore()));

        getWinner().ifPresent(x -> System.out.println(String.format("%s wins", x.getName())));


    }
}
