package dice;

import game.gameBoard;
import game.sideBar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.MapaFacade;
import newGame.Player;

@SuppressWarnings("serial")
public class diceChallengeWindow extends JFrame{
	
	private int LARG_DEFAULT = 500;
	private int ALT_DEFAULT = 400;

	public diceChallengeWindow(gameBoard game, MapaFacade map, Player[] players, Player turnPlayer, sideBar side) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		JFrame jframe = this;
		
		diceChallenge background = new diceChallenge(game, map, this, players, turnPlayer, side);
		
		getContentPane().add(background);
		
		ImageIcon img = new ImageIcon("src/icon.png");
		jframe.setIconImage(img.getImage());
		
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl / 2 - LARG_DEFAULT / 2;
		int y = sa / 2 - ALT_DEFAULT / 2;

		setTitle("Rolagem de dados");
		setBounds(x, y, LARG_DEFAULT, ALT_DEFAULT);

	}
	

}
