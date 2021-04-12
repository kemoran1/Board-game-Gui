package Project2;

import java.awt.event.ActionEvent;

public interface BoardGame {

	public void displayBoard();
	public void clearBoard();
	public void displayWinner();
	public void takeTurn();
	public void updateCurrPlayer();
	public boolean isFull();
	// any other methods you may need
	void actionPerformed1(ActionEvent e);
}
