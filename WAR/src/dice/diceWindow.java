package dice;

import game.gameBoard;
import game.sideBar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.MapaFacade;
import controller.Territorio;
import newGame.Player;

@SuppressWarnings("serial")
public class diceWindow extends JFrame{
	
	private final int LARG_DEFAULT = 500;
	private final int ALT_DEFAULT = 400;

	
	public diceWindow(gameBoard game, MapaFacade map, Player ATK, Player DEF, Territorio atkTerr, Territorio defTerr, Player[] players, sideBar side){
		
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
		
		dicePanel m = new dicePanel(game, map, this, ATK, DEF, atkTerr, defTerr, players, side);
		getContentPane().add(m);
		
		
	}
}
