package com.kering.prisoners.game;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendOrFoeGame {
    public static final String GAME_STARTS = "Game starting between %s and %s for %d rounds";

    public static final String PLAYER_BETRAYS = "%s has betrayed >:)";
    public static final String PLAYER_COOPERATES = "%s cooperates";

    public static final String PLAYER_WINS = "%s has betrayed %s and wins 20 points";
    public static final String BOTH_BETRAY = "Both prisoners betrayed : no one wins";
    public static final String BOTH_COOPERATE = "Both prisoners cooperated : 10 points each";

    Map<Prisoner, List<Decision>> gameHistory;

    int maxRounds;
    int roundNumber;

    public FriendOrFoeGame() {
        this(3);
    }

    public FriendOrFoeGame(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public GameResult play(Prisoner player1, Prisoner player2) {
        System.out.println(String.format(GAME_STARTS, player1.getName(), player2.getName(), maxRounds));
        startGame(player1, player2);
        for(int i = roundNumber; i<maxRounds+1; i++) {
            Decision player1Decision = player1.makesDecision(this);
            Decision player2Decision = player2.makesDecision(this);

            // Storing decisions in the history
            addDecisionToHistory(player1, player1Decision);
            addDecisionToHistory(player2, player2Decision);

            if(player1Decision.equals(Decision.BETRAY)) {
                System.out.println(String.format(PLAYER_BETRAYS, player1.getName()));
                if(player2Decision.equals(Decision.BETRAY)) {
                    System.out.println(BOTH_BETRAY);
                } else {
                    System.out.println(String.format(PLAYER_WINS, player1.getName(), player2.getName()));
                    player1.setScore(player1.getScore() + 20);
                }
            } else {
                System.out.println(String.format(PLAYER_COOPERATES, player1.getName()));
                if(player2Decision.equals(Decision.BETRAY)) {
                    System.out.println(String.format(PLAYER_WINS, player2.getName(), player1.getName()));
                    player2.setScore(player2.getScore() + 20);
                } else {
                    System.out.println(BOTH_COOPERATE);
                    player1.setScore(player1.getScore() + 10);
                    player2.setScore(player2.getScore() + 10);
                }
            }
            this.roundNumber ++;
        }

        GameResult result = new GameResult(player1, player2);
        result.displayResult();

        return result;
    }

    public Map<Prisoner, List<Decision>> getGameHistory() {
        return gameHistory;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    private void addDecisionToHistory(Prisoner player, Decision decision) {
        if(!gameHistory.containsKey(player)) {
            gameHistory.put(player, new ArrayList<>());
        }
        List<Decision> decisions = gameHistory.get(player);
        decisions.add(decision);
        gameHistory.put(player,decisions);
    }

    private void startGame(Prisoner player1, Prisoner player2) {
        player1.setScore(0);
        player2.setScore(0);
        roundNumber = 1;
        gameHistory = new HashMap<>();
    }
}
