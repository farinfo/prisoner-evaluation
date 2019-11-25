package com.kering.prisoners.test.context;

import com.kering.prisoners.Prisoner;
import com.kering.prisoners.game.GameResult;

import java.util.HashSet;
import java.util.Set;

public class TestContext {
    private Set<Prisoner> prisoners;
    private GameResult result;

    public TestContext(){
        this.prisoners = new HashSet<>();
    }

    public void addPrisoner(Prisoner prisoner) {
        prisoners.add(prisoner);
    }

    public Prisoner getPrisoner(String prisonerName) {
        for(Prisoner p : prisoners) {
            if(p.getName().equals(prisonerName)) {
                return p;
            }
        }
        throw new RuntimeException("No such prisoner : " + prisonerName);
    }

    public void setLatestGameResult(GameResult result) {
        this.result = result;
    }

    public GameResult getLatestGameResult() {
        return result;
    }
}
