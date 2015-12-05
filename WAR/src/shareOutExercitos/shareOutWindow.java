package shareOutExercitos;

import game.sideBar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.MapaFacade;
import controller.Territorio;
import newGame.Player;

@SuppressWarnings("serial")
public class shareOutWindow extends JFrame{

	private int LARG_DEFAULT = 500;
	private int ALT_DEFAULT = 400;

	private List<Territorio> lstTerritoriosSend;
	
	public shareOutWindow(MapaFacade map, sideBar sideBarPanel, int exercitos, List<Territorio> lstTerritorios, Player turnPlayer) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		JFrame jframe = this;
		
		shareOutPanel shareOut = new shareOutPanel(map, sideBarPanel, this, exercitos, lstTerritorios, turnPlayer);
		lstTerritoriosSend = shareOut.getTerritorio();
		
		getContentPane().add(shareOut);
		
		ImageIcon img = new ImageIcon("src/icon.png");
		jframe.setIconImage(img.getImage());
		
		int sl = screenSize.width;
		int sa = screenSize.height;
		int x = sl / 2 - LARG_DEFAULT / 2;
		int y = sa / 2 - ALT_DEFAULT / 2;

		setTitle("Distribuição de exércitos");
		setBounds(x, y, LARG_DEFAULT, ALT_DEFAULT);

	}
	
	public List<Territorio> getTerritorio (){
		return lstTerritoriosSend;
	}
}
