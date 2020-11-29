package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.types.Token;
import TicTacToe.tictactoe.views.MessageView;
import TicTacToe.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int winner) {
        this.console.write(Token.values()[winner].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}