package com.kering.prisoners.archetypes;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.FriendOrFoeGame;

public class GulliblePrisoner extends Prisoner {

    public GulliblePrisoner(String name) {
        super(name);
    }

    public Decision makesDecision(FriendOrFoeGame other) {
        return Decision.COOPERATE;
    }
}
