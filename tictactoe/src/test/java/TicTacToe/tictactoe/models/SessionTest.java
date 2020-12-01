package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import TicTacToe.tictactoe.types.StateValue;
import TicTacToe.tictactoe.types.Token;

public class SessionTest {

	@Test
	public void createInitialSessionAndCheckCorrectInitialDataTest() {
		Session session = new Session();
		session.setUsers(2);
		assertEquals(Token.X, session.getToken());
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
		Session session = new Session();
		session.setUsers(2);
		assertEquals(Token.X, session.getToken());
		assertEquals(Token.NULL, session.getToken(at(0, 0)));
		session.put(at(0, 0));
		assertEquals(Token.X, session.getToken(at(0, 0)));
		assertEquals(Token.O, session.getToken());

		assertEquals(Token.NULL, session.getToken(at(0, 1)));
		session.put(at(0, 1));
		assertEquals(Token.O, session.getToken(at(0, 1)));
		assertEquals(Token.X, session.getToken());
	}
	
	@Test
	public void checkIfSesionMoveCoordenatesAndChengePlayerCorrectyTest() {
		Session session = new Session();
		session.setUsers(2);
		session.put(at(0, 0));
		session.put(at(0, 1));
		
		assertEquals(Token.X, session.getToken());
		assertEquals(Token.X, session.getToken(at(0, 0)));
		session.move(at(0, 0), at(1, 1));
		assertEquals(Token.X, session.getToken(at(1, 1)));
		assertEquals(Token.O, session.getToken());

		assertEquals(Token.O, session.getToken(at(0, 1)));
		session.move(at(0, 1), at(2, 2));
		assertEquals(Token.O, session.getToken(at(2, 2)));
		assertEquals(Token.X, session.getToken());
	}
	
	@Test
	public void checkIfIsUndoableSesionTest() {
		Session session = new Session();
		session.setUsers(2);
		session.put(at(0, 0));
		session.put(at(0, 1));
		
		assertTrue(session.isUndoable());
	}
	
	@Test
	public void checkIfIsNotUndoableSesionTest() {
		Session session = new Session();
		session.setUsers(2);
		
		assertFalse(session.isUndoable());
	}

	@Test
	public void checkIfItUndoSesionCorrectyTest() {
		Session session = new Session();
		session.setUsers(2);
		session.put(at(0, 0));
		session.put(at(0, 1));
		assertNotEquals(Token.NULL, session.getToken(at(0, 1)));
		session.undo();
		assertEquals(Token.NULL, session.getToken(at(0, 1)));
		
	}
	
	@Test
	public void checkIfIsRedoableSesionTest() {
		Session session = new Session();
		session.setUsers(2);
		session.put(at(0, 0));
		session.put(at(0, 1));
		
		assertFalse(session.isRedoable());
		
		session.undo();
		
		assertTrue(session.isRedoable());
	}
	
	@Test
	public void checkIfIsNotRedoableSesionTest() {
		Session session = new Session();
		session.setUsers(2);
		
		assertFalse(session.isRedoable());
	}
	
	@Test
	public void checkIfItRedoSesionCorrectyTest() {
		Session session = new Session();
		session.setUsers(2);
		session.put(at(0, 0));
		session.put(at(0, 1));
		assertNotEquals(Token.NULL, session.getToken(at(0, 1)));
		session.undo();
		assertEquals(Token.NULL, session.getToken(at(0, 1)));
		session.redo();
		assertNotEquals(Token.NULL, session.getToken(at(0, 1)));
		
	}
	
	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
