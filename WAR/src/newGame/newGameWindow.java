package newGame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

@SuppressWarnings("serial")
public class newGameWindow extends JFrame{
	
	private int LARG_DEFAULT = 1024;
	private int ALT_DEFAULT = 797;
	
	public newGameWindow(){
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		ImageIcon img = new ImageIcon("src/icon.png");
		this.setIconImage(img.getImage());
		
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		setTitle("Novo Jogo");
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		newGameContent m = new newGameContent(this);
		getContentPane().add(m);
		
		
	}
}
