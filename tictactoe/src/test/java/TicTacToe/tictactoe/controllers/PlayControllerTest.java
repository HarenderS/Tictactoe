package TicTacToe.tictactoe.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.types.Token;

public class PlayControllerTest {
    
    private PlayController playController;

    private Game game;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public PlayControllerTest() {
        this.game = new Game();
        this.game.setUsers(0);
        this.playController = new PlayController(this.game, new State());
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertEquals(Error.NULL, this.playController.isCoordinateValid(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
    	assertEquals(Error.NULL, this.playController.isCoordinateValid(new Coordinate(2, 2)));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
    	this.playController.isCoordinateValid(new Coordinate(3, 3));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
    	this.playController.isCoordinateValid(new Coordinate(-1, -1));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.X, this.playController.getToken(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.put(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.X, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(this.coordinate00, this.coordinate01);
        assertEquals(Token.O, this.playController.getToken(this.coordinate01));
        assertTrue(this.playController.isEmptyToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(new Coordinate(1, 0), this.coordinate01);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(this.coordinate00, this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.playController.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playController.put(this.coordinate00);
        assertFalse(this.playController.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.playController.isEmptyToken(this.coordinate00));
    }
}