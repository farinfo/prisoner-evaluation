package com.kering.prisoners.archetypes;

import com.kering.prisoners.Decision;
import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.FriendOrFoeGame;

public class TreacherousPrisoner extends Prisoner {

    public TreacherousPrisoner(String name) {
        super(name);
    }

    public Decision makesDecision(FriendOrFoeGame other) {
        return Decision.BETRAY;
    }
}
