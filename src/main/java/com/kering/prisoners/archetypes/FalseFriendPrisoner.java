package com.kering.prisoners.archetypes;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.FriendOrFoeGame;

public class FalseFriendPrisoner extends Prisoner {
    public FalseFriendPrisoner(String name) {
        super(name);
    }

    @Override
    public Decision makesDecision(FriendOrFoeGame game) {
        if(game.getMaxRounds() == game.getRoundNumber()) {
            return Decision.BETRAY;
        }
        return Decision.COOPERATE;
    }
}
