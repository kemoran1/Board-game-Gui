package Project2;

//import Showproject1.Calframe;
public class Showproject2 {
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				Connectfourpanel gui = new Connectfourpanel();
			
			}
		});
		
	}

}