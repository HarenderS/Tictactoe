package TicTacToe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TicTacToe.tictactoe.AllTicTacToeTest;
import TicTacToe.utils.AllUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllTicTacToeTest.class, 
    AllUtilsTest.class } )
public class AllTest {
    
}