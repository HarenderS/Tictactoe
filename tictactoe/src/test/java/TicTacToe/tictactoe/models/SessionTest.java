package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import TicTacToe.tictactoe.types.StateValue;
import TicTacToe.tictactoe.types.Token;

public class SessionTest {

	private Session session = new Session();
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
	
	@Test
	public void checkIfSesionPutCoordenatesAndChengePlayerCorrectyTest() {
		this.session.setUsers(2);
		assertEquals(Token.O, this.session.getToken());
		assertEquals(Token.NULL, this.session.getToken(at(0, 0)));
		this.session.put(at(0, 0));
		assertEquals(Token.O, this.session.getToken(at(0, 0)));
		assertEquals(Token.X, this.session.getToken());
		
		assertEquals(Token.NULL, this.session.getToken(at(0, 1)));
		this.session.put(at(0, 1));
		assertEquals(Token.X, this.session.getToken(at(0, 1)));
		assertEquals(Token.O, this.session.getToken());
	}
	
	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
