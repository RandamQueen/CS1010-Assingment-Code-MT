import javax.swing.JOptionPane;  
public class UmbrellaTest {

	public static void main(String[] args) {
		int bringUmbrellaAnswer = JOptionPane.showConfirmDialog( null, "Does it look "
				+ "like it may rain?"); 
		boolean bringUmbrella = (bringUmbrellaAnswer == JOptionPane.YES_OPTION);
		int putUpUmbrellaAnswer = JOptionPane.showConfirmDialog( null, "Is it raining?"); 
		boolean putUpUmbrella = (putUpUmbrellaAnswer == JOptionPane.YES_OPTION);
		
		if (bringUmbrella){ 
			if( putUpUmbrella) {
				JOptionPane.showMessageDialog(null, "You should put up your umbrella.");
			} 
			else JOptionPane.showMessageDialog(null, "Bring an Umbrella,"
					+ " but don't put it up yet.");
		}
		else if( !putUpUmbrella) { 
			JOptionPane.showMessageDialog(null, "You don't need to bring an Umbrella.");	
		}
		else JOptionPane.showMessageDialog(null, "You should bring & put up your umbrella .");
	}
}

