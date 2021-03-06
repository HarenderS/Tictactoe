package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import TicTacToe.tictactoe.types.Token;

public class TurnTest {

    private Turn turn;
    private Player[] players;

    public TurnTest() {
        Board board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(Token.values()[0], board);
        this.players[1] = new Player(Token.values()[1], board);
        this.turn = new Turn(board);
        this.turn.setUsers(2);
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.nextTurn();
        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.nextTurn();
        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.nextTurn();
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
    }
}
