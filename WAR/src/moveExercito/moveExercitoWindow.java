package moveExercito;

import game.sideBar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import newGame.Player;
import controller.MapaFacade;
import controller.Territorio;

@SuppressWarnings("serial")
public class moveExercitoWindow extends JFrame{

	private int LARG_DEFAULT = 500;
	private int ALT_DEFAULT = 400;
	
	public moveExercitoWindow(MapaFacade map, sideBar sideBarPanel, int exercitos, List<Territorio> lstTerritorios, Player turnPlayer) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		JFrame jframe = this;
		
		moveExercitoPanel moveExercito = new moveExercitoPanel(map, sideBarPanel, this, exercitos, lstTerritorios, turnPlayer);
		
		getContentPane().add(moveExercito);
		
		ImageIcon img = new ImageIcon("src/icon.png");
		jframe.setIconImage(img.getImage());
		
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl / 2 - LARG_DEFAULT / 2;
		int y = sa / 2 - ALT_DEFAULT / 2;

		setTitle("Distribuição de exércitos");
		setBounds(x, y, LARG_DEFAULT, ALT_DEFAULT);

	}
	
}
