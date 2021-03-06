package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Session;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.types.Token;

public class PlayController extends UseCaseController implements AcceptorController{

	private ActionController actionController;
	private UndoController undoController;
	private RedoController redoController;

	public PlayController(Session session) {
		super(session);
		this.actionController = new ActionController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	public boolean isBoardComplete() {
		return this.actionController.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.actionController.isTicTacToe();
	}

	public Token getToken() {
		return this.actionController.getToken();
	}

	public boolean isUser() {
		return this.actionController.isUser();
	}

	public Error put(Coordinate coordinate) {
		return this.actionController.put(coordinate);
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.actionController.move(origin, target);
	}

	public void undo() {
		this.undoController.undo();
	}

	public boolean undoable() {
		return this.undoController.undoable();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean redoable() {
		return this.redoController.redoable();
	}

	public Error isCoordinateValid(Coordinate coordinate) {
		return this.actionController.isCoordinateValid(coordinate);
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.actionController.isEmptyToken(coordinate);
	}
	
	public int getCoordinateDimension() {
		return this.actionController.getCoordinateDimension();
	}
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	

}
