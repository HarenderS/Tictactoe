package TicTacToe.tictactoe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TicTacToe.tictactoe.controllers.AllControllerTest;
import TicTacToe.tictactoe.models.AllModelTest;
import TicTacToe.tictactoe.views.console.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllControllerTest.class,
    AllModelTest.class, 
    AllViewTest.class } )
public class AllTicTacToeTest {
}