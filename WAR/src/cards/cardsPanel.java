package cards;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import newGame.Player;

@SuppressWarnings("serial")
public class cardsPanel extends JPanel{
	
	private BufferedImage image;
	private String obj;
	
	public cardsPanel (Player turnPlayer){
		try {                
			image = ImageIO.read(new File("src/img/Solid Mint.png"));
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		
		repaint();
		setLayout(null);
		
		JLabel cartasDeTerritorio = new JLabel();
		cartasDeTerritorio.setText("Cartas de território:");
		cartasDeTerritorio.setBounds(20,-20,300,100);
		cartasDeTerritorio.setFont(new Font("Verdana", 1, 20));
		cartasDeTerritorio.setVisible(true);
		this.add(cartasDeTerritorio);
		
		JLabel cartaDeObjetivo = new JLabel();
		cartaDeObjetivo.setText("Objetivo:");
		cartaDeObjetivo.setBounds(460,-20,300,100);
		cartaDeObjetivo.setFont(new Font("Verdana", 1, 20));
		cartaDeObjetivo.setVisible(true);
		this.add(cartaDeObjetivo);
		
		ImageIcon icon = new ImageIcon("src/img/Cartas/war_carta_verso.png");
		Image iconImage = icon.getImage();
		iconImage = iconImage.getScaledInstance(40*440/100,40*725/100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconImage);
		
		JLabel cardField1 = new JLabel();
		cardField1.setIcon(icon);
		cardField1.setBounds(20,60,40*440/100,40*725/100);
		this.add(cardField1);
		
		JLabel cardField2 = new JLabel();
		cardField2.setIcon(icon);
		cardField2.setBounds(20*2+40*440/100,60,40*440/100,40*725/100);
		this.add(cardField2);
		
		JLabel cardField3 = new JLabel();
		cardField3.setIcon(icon);
		cardField3.setBounds(20,20*4+40*725/100,40*440/100,40*725/100);
		this.add(cardField3);
		
		JLabel cardField4 = new JLabel();
		cardField4.setIcon(icon);
		cardField4.setBounds(20*2+40*440/100,20*4+40*725/100,40*440/100,40*725/100);
		this.add(cardField4);
		
		Goals g = new Goals();
		
		if(turnPlayer.getGoal() == 0)
			obj = g.getGoal0();
		if(turnPlayer.getGoal() == 1)
			obj = g.getGoal1();
		if(turnPlayer.getGoal() == 2)
			obj = g.getGoal2();
		if(turnPlayer.getGoal() == 3)
			obj = g.getGoal3();
		if(turnPlayer.getGoal() == 4)
			obj = g.getGoal4();
		if(turnPlayer.getGoal() == 5)
			obj = g.getGoal5();
		if(turnPlayer.getGoal() == 6)
			obj = g.getGoal6();
		if(turnPlayer.getGoal() == 7)
			obj = g.getGoal7();
		
		
		System.out.println(obj);
		
		JTextArea Objetivo = new JTextArea();
		Objetivo.setText(obj);
		Objetivo.setEditable(false);
		Objetivo.setLineWrap(true);
		Objetivo.setWrapStyleWord(true);
		Objetivo.setOpaque(false);
		Objetivo.setBounds(20*14+40*440/100+20,60+90,60*440/100-40,60*725/100);
		Objetivo.setFont(new Font("Verdana", 1, 20));
		Objetivo.setVisible(true);
		this.add(Objetivo);
		
		ImageIcon iconObj = new ImageIcon("src/img/Cartas/war_carta_objetivo.png");
		Image iconImageObj = iconObj.getImage();
		iconImageObj = iconImageObj.getScaledInstance(60*440/100,60*725/100, Image.SCALE_SMOOTH);
		iconObj = new ImageIcon(iconImageObj);
		
		JLabel cardGoal = new JLabel();
		cardGoal.setIcon(iconObj);
		cardGoal.setBounds(20*14+40*440/100,60,60*440/100,60*725/100);
		this.add(cardGoal);
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,1024, 768, null);      
       
    }
}
