package com.kering.prisoners.archetypes;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.FriendOrFoeGame;

public class CautiousPrisoner extends Prisoner {

    public CautiousPrisoner(String name) {
        super(name);
    }

    @Override
    public Decision makesDecision(FriendOrFoeGame game) {
        if(game.getRoundNumber() == 1) {
            return Decision.BETRAY;
        } else {
            if(!opponentHasBetrayed(game)) {
                return Decision.COOPERATE;
            } else {
                return Decision.BETRAY;
            }
        }
    }
}
