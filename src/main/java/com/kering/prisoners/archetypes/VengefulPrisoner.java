package com.kering.prisoners.archetypes;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.FriendOrFoeGame;

import java.util.List;

public class VengefulPrisoner extends Prisoner {
    public VengefulPrisoner(String name) {
        super(name);
    }

    public Decision makesDecision(FriendOrFoeGame game) {
        if(opponentHasBetrayed(game)) {
            return Decision.BETRAY;
        } else {
            return Decision.COOPERATE;
        }
    }
}
