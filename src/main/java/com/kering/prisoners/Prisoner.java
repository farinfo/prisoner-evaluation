package com.kering.prisoners;

import com.kering.prisoners.game.FriendOrFoeGame;

import java.util.List;
import java.util.Objects;

public abstract class Prisoner {
    String name;
    int score;

    public Prisoner(String name) {
        this.name = name;
    }

    public abstract Decision makesDecision(FriendOrFoeGame game);

    protected List<Decision> getOpponentHistory(FriendOrFoeGame game) {
        for(Prisoner prisoner : game.getGameHistory().keySet()) {
            if(!prisoner.equals(this)) {
                return game.getGameHistory().get(prisoner);
            }
        }
        return null;
    }

    protected boolean opponentHasBetrayed(FriendOrFoeGame game) {
        List<Decision> opponentDecisions = this.getOpponentHistory(game);
        if(opponentDecisions != null) {
            for(Decision decision : opponentDecisions) {
                if(decision.equals(Decision.BETRAY)) {
                    return true;
                }
            }
        }
        return false;
    }


    protected Decision opponentLastDecision(FriendOrFoeGame game) {
        List<Decision> opponentDecisions = this.getOpponentHistory(game);
        if(opponentDecisions != null) {
            return opponentDecisions.get(opponentDecisions.size() - 1);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prisoner prisoner = (Prisoner) o;
        return name.equals(prisoner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
