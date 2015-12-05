package game;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import controller.MapaFacade;
import newGame.Player;

@SuppressWarnings("serial")
public class gameBoard extends JFrame{
	
	private int LARG_DEFAULT = 1274;
	private int ALT_DEFAULT = 805;
	private JSplitPane split = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT);
	
	public gameBoard (Player[] players){
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		JFrame gameBoard = this;
		
		ImageIcon img = new ImageIcon("src/icon.png");
		gameBoard.setIconImage(img.getImage());
		
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		setTitle("WAR");
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MapaFacade map = new MapaFacade(players);
		
		sideBar side = sideBar.getSideBar(players, map, this);
		
		split.setDividerLocation(1024);
		split.setEnabled(false);
	    split.setRightComponent( side );
	    split.setDividerSize(0);
	    getContentPane().add(split);
	    split.setBorder(null);

	    setResizable(false);
	}
	public void changeLeftComponent(Component comp){
		split.setLeftComponent( comp );
		split.setDividerLocation(1024);
	}
	public void changeRightComponent(Component comp){
		split.setRightComponent( comp );
		split.setDividerLocation(1024);
	}
}
