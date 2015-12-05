package cards;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import newGame.Player;

@SuppressWarnings("serial")
public class cardsWindow extends JFrame {
	private final int LARG_DEFAULT = 750;
	private final int ALT_DEFAULT = 750;

	
	public cardsWindow(Player turnPlayer){
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		ImageIcon img = new ImageIcon("src/icon.png");
		this.setIconImage(img.getImage());
		
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		setTitle("Rolagem de dados");
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		cardsPanel m = new cardsPanel(turnPlayer);
		getContentPane().add(m);
		
		
	}
}
