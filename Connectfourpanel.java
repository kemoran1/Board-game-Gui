package Project2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connectfourpanel extends JFrame implements BoardGame, ActionListener{

	private JPanel jpMain, jpBoard, jpIO, jpButton;
	private JLabel displayOut;
	private JButton [][] board;
	private String Player1,Player2;
	public Connectfourpanel(){
	JTextField jtf1 = null,jtf2 = null;
		
	setTitle("CONNECT FOUR");
	jpMain = new JPanel();
	jpMain.setLayout(new BorderLayout());
	displayOut = new JLabel("Let's Play "+currPlayer+ " goes first");
	jpIO = new JPanel();
	jpIO.add(displayOut);
	jpMain.add(jpIO, BorderLayout.NORTH);
	jpButton = new JPanel();
	jpButton.setLayout(new GridLayout(1,7));
	jpMain.add(jpButton, BorderLayout.NORTH);
	jpBoard = new JPanel();
	jpBoard.setLayout(new GridLayout(6,7));
	displayBoard();
	jpMain.add(jpBoard, BorderLayout.CENTER);
	add(jpMain);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(400,400);
	setVisible(true);
	}
	
	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		board = new JButton[6][7];
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				board[row][col] = new JButton();
				board[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
				board[row][col].addActionListener(this);
				board[row][col].setEnabled(true);
				jpBoard.add(board[row][col]);
			}
		}
	}

	@Override
	public void clearBoard() {
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				board[row][col].setText("");
				board[row][col].setEnabled(true);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayWinner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCurrPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayWinner() {
		char Winner =' ';
		for(int col=0; col<7;col++) {
			int count=0;
			for(int row = 0 ; row < 5 ; row++) {
				if (board[row][col] != ' ' && board[row][col] == board[row+1][col]) {
					count++;
					}
			}
		}
		for(int col=0; col<7;col++) {
			int count=0;
			for(int row = 0 ; row < 5 ; row++) {
				if (board[row][col] != ' ' && board[row][col] == board[row][col+1]) {
					count++;
					}
			}
		}
		
		
		if(checkMainDiagonal() || checkSecondaryDiagonal() ){
			displayOut.setText("WINNER IS " +  );
			JOptionPane.showMessageDialog(null, "WINNER IS " + );
		}
		else{
			if(isFull()){
				displayOut.setText("DRAW");
			}
		}
		
		
	}
	private boolean checkMainDiagonal(){
		int diagCount = 0;
		for(int i=0; i< board.length; i++){
			if(board[i][i].getText().contains(currPlayer)){
				diagCount++;
				if(diagCount == 4){
					return true;
				}
			}
		}
		return false;
	}
	private boolean checkSecondaryDiagonal(){
		int diagCount = 0;
		int row = board.length-1;
		int col = 0;
		while( row >=0   &&  col < board.length){
			if(board[row][col].getText().contains(currPlayer)){
				diagCount++;
				if(diagCount == 4){
					return true;
				}
			}
			row--;
			col++;
		}
		return false;
	}
	@Override
	public void takeTurn() {
		
		
	}

	@Override
	public void updateCurrPlayer() {
		if(currPlayer.equalsIgnoreCase("X")){
			return Player1;
		}
		else{
			return Player2;
		}
	}

	@Override
	public boolean isFull() {
		
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				if(board[row][col].getText().isEmpty()){
					return false;
				}
			}
		}
		return true;//none were empty return true
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		btnClicked.setText(currPlayer);
		btnClicked.setEnabled(false);
		//if isWinner -> displayWinner and ask playAnotherGame
		displayWinner();
		
		updateCurrPlayer();//update currPlayer
		//update Display
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
