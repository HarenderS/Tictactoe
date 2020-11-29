package TicTacToe.tictactoe.views.graphics;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.controllers.ResumeController;
import TicTacToe.tictactoe.controllers.StartController;
import TicTacToe.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}
	
	public void visit(PlayController playController) {
		this.gameView.interact(playController);
	}
	
	public void visit(ResumeController resumeController) {
		ResumeDialog resumeDialog = new ResumeDialog();
		resumeController.resume(resumeDialog.isNewGame());
		if (resumeDialog.isNewGame()) {
			this.gameView = new GameView();
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
		}
	}

}
