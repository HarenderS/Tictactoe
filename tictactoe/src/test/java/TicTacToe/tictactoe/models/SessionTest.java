package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import TicTacToe.tictactoe.types.StateValue;
import TicTacToe.tictactoe.types.Token;

public class SessionTest {

	@Test
	public void createInitialSessionAndCheckCorrectInitialDataTest() {
		Session session = new Session();
		session.setUsers(2);
		assertEquals(Token.O, session.getToken());
		assertEquals(StateValue.INITIAL, session.getValueState());
		assertEquals(2, session.getMaxPlayers());
		assertFalse(session.isBoardComplete());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				assertEquals(Token.NULL, session.getToken(at(i, j)));
			}
		}
	}
	
	@Test
	public void checkIfStateChangedCorrectyTest() {
		Session session = new Session();
		session.setUsers(2);
	    assertEquals(StateValue.INITIAL, session.getValueState());
	    session.next();
	    assertEquals(StateValue.IN_GAME, session.getValueState());
	    session.next();
	    assertEquals(StateValue.RESUME, session.getValueState());
	    session.next();
	    assertEquals(StateValue.EXIT, session.getValueState());
	}
	
	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
