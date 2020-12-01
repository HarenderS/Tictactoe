package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import TicTacToe.tictactoe.models.State;
import TicTacToe.tictactoe.types.StateValue;

public class StateTest {
    
    private State state;

    public StateTest() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        assertEquals(StateValue.INITIAL, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.nextState();
        assertEquals(StateValue.IN_GAME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.nextState();
        this.state.nextState();
        assertEquals(StateValue.RESUME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.nextState();
        this.state.nextState();
        this.state.nextState();
        assertEquals(StateValue.EXIT, this.state.getValueState());
    }
}