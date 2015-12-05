package cards;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import newGame.Player;

@SuppressWarnings("serial")
public class winnerWindow extends JFrame{
	private int LARG_DEFAULT = 500;
	private int ALT_DEFAULT = 400;

	public winnerWindow(Player winner) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		JFrame jframe = this;
		
		winnerPanel background = new winnerPanel(winner);
		
		getContentPane().add(background);
		
		ImageIcon img = new ImageIcon("src/icon.png");
		jframe.setIconImage(img.getImage());
		
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl / 2 - LARG_DEFAULT / 2;
		int y = sa / 2 - ALT_DEFAULT / 2;

		setTitle("Vencedor");
		setBounds(x, y, LARG_DEFAULT, ALT_DEFAULT);

	}
	
}
