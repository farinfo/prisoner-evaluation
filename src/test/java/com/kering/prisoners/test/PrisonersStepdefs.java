package com.kering.prisoners.test;

import com.kering.prisoners.Decision;
import com.kering.prisoners.archetypes.*;
import com.kering.prisoners.game.FriendOrFoeGame;
import com.kering.prisoners.test.context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PrisonersStepdefs {
    private static final String PRISONER_BOB = "Bob";
    private static final String PRISONER_DAVE = "Dave";
    private static final String PRISONER_JOHN = "John";
    private static final String PRISONER_JAKE = "Jake";
    private static final String PRISONER_TIM = "Tim";
    private static final String PRISONER_DAN = "Dan";
    private static final String PRISONER_BILL = "Bill";

    TestContext context;
    FriendOrFoeGame game;

    public PrisonersStepdefs(TestContext context, FriendOrFoeGame game) {
        this.context = context;
        this.game = game;
    }

    @Given("^a gullible prisoner, Bob$")
    public void aGulliblePrisonerBob() {
        context.addPrisoner(new GulliblePrisoner(PRISONER_BOB));
    }

    @Given("^another gullible prisoner, Dave$")
    public void anotherGulliblePrisonerDave() {
        context.addPrisoner(new GulliblePrisoner(PRISONER_DAVE));
    }

    @Given("^a treacherous prisoner, John$")
    public void aTreacherousPrisonerJohn() {
        context.addPrisoner(new TreacherousPrisoner(PRISONER_JOHN));
    }

    @Given("^any opponent really, but let's name him Jake$")
    public void anyOpponentReallyButLetSNameHimJake() {
        context.addPrisoner(new TreacherousPrisoner(PRISONER_JAKE));
    }

    @Given("^a vengeful prisoner, Tim$")
    public void aVengefulPrisonerTim() {
        context.addPrisoner(new VengefulPrisoner(PRISONER_TIM));
    }

    @Given("^a mimic prisoner, Dan$")
    public void aMimicPrisonerDan() {
        context.addPrisoner(new MimicPrisoner(PRISONER_DAN));
    }

    
    @Given("^a cautious prisoner, Tim$")
    public void aCautiousPrisonerTim (){
        context.addPrisoner(new CautiousPrisoner(PRISONER_TIM));}

    @Given("^a false-friend prisoner, Bill$")
    public void aFalseFriendPrisonerBill (){ context.addPrisoner(new FalseFriendPrisoner(PRISONER_BILL));}


    @Then("^Bob will always cooperate$")
    public void bobWillAlwaysCooperate() {
        for(Decision decision : game.getGameHistory().get(context.getPrisoner(PRISONER_BOB))) {
            assertTrue(decision.equals(Decision.COOPERATE));
        }
    }

    @Then("^John will always betray$")
    public void johnWillAlwaysBetray() {
        for(Decision decision : game.getGameHistory().get(context.getPrisoner(PRISONER_JOHN))) {
            assertTrue(decision.equals(Decision.BETRAY));
        }
    }

    @Then("^(.*) will start by cooperating$")
    public void timCooperatesFirst(String prisonerName) {
        Decision firstDecision = game.getGameHistory().get(context.getPrisoner(prisonerName)).get(0);
        assertTrue(Decision.COOPERATE.equals(firstDecision));
    }

    @Then("^(.*) will start by betraying$")
    public void johnBetrayFirst(String prisonerName) {
        Decision firstDecision = game.getGameHistory().get(context.getPrisoner(prisonerName)).get(0);
        assertTrue(Decision.BETRAY.equals(firstDecision));
    }

    @Then("^Bill will cooperate first$")
    public void billWillCooperateFirst() {
        Decision firstDecision = game.getGameHistory().get(context.getPrisoner(PRISONER_BILL)).get(0);
        assertTrue(Decision.COOPERATE.equals(firstDecision));
    }

    @But("once he's betrayed, Tim will betray back")
    public void timBetraysWhenBetrayed() {
        List<Decision> decisions = game.getGameHistory().get(context.getPrisoner(PRISONER_TIM));
        for(int i = 1; i<decisions.size(); i++) {
            assertTrue(Decision.BETRAY.equals(decisions.get(i)));
        }
    }

    @But("^Dan will copy Jake's last decision in the following rounds$")
    public void danWillCopyJakeSLastDecisionInTheFollowingRounds() {
        List<Decision> mimicDecisions = game.getGameHistory().get(context.getPrisoner(PRISONER_DAN));
        List<Decision> opponentDecisions = game.getGameHistory().get(context.getPrisoner(PRISONER_JAKE));

        assertTrue(mimicDecisions.subList(1,mimicDecisions.size() - 1)
                .equals(opponentDecisions.subList(0, opponentDecisions.size() - 2)));
    }

    @But("^Tim will cooperate in the following round$")
    public void timWillCooperateInTheFollowingRound() {
        List<Decision> cautiousDecisions = game.getGameHistory().get(context.getPrisoner(PRISONER_TIM));
        assertTrue(Decision.COOPERATE.equals(cautiousDecisions.get(1)));
    }

    @But("^once the game ends, Bill will betray$")
    public void billWillBetrayInTheLastRound() {
        List<Decision> falseFriendDecisions = game.getGameHistory().get(context.getPrisoner(PRISONER_BILL));
        assertTrue(Decision.BETRAY.equals(falseFriendDecisions.get(falseFriendDecisions.size() - 1)));
    }
}
