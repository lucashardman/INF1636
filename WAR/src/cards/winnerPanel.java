package cards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import newGame.Player;

@SuppressWarnings("serial")
public class winnerPanel extends JPanel{

	private BufferedImage image;
	
	public winnerPanel(Player winner) {

		JPanel jpanel = this;
		
		try {
			image = ImageIO.read(new File("src/img/Mapas/war_tabuleiro_fundo.png"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}

		repaint();
		setLayout(null);
		
		JLabel playerColor1 = new JLabel();
		playerColor1.setBackground(winner.getColor());
		playerColor1.setBounds(5, 5, 482, 15);
		playerColor1.setBorder(new LineBorder(Color.black, 2));
		playerColor1.setOpaque(true);
		jpanel.add(playerColor1);
		
		JLabel playerColor2 = new JLabel();
		playerColor2.setBackground(winner.getColor());
		playerColor2.setBounds(5, 400-60, 482, 15);
		playerColor2.setBorder(new LineBorder(Color.black, 2));
		playerColor2.setOpaque(true);
		jpanel.add(playerColor2);
		
		JLabel vencedor = new JLabel();
		vencedor.setText("Vencedor:");
		vencedor.setForeground(Color.white);
		vencedor.setBounds(120, 30, 482, 45);
		vencedor.setFont(new Font("Verdana", 1, 40));
		vencedor.setOpaque(false);
		jpanel.add(vencedor);
		
		JLabel exercitoVencedor = new JLabel();
		exercitoVencedor.setText("-> "+winner.getName()+" <-");
		exercitoVencedor.setForeground(Color.white);
		exercitoVencedor.setBounds(20,400/2-45, 500, 45);
		exercitoVencedor.setFont(new Font("Verdana", 1, 30));
		exercitoVencedor.setOpaque(false);
		jpanel.add(exercitoVencedor);
		
		JLabel parabens = new JLabel();
		parabens.setText("Parabéns!!!");
		parabens.setForeground(Color.white);
		parabens.setBounds(110, 280, 482, 45);
		parabens.setFont(new Font("Verdana", 1, 40));
		parabens.setOpaque(false);
		jpanel.add(parabens);

	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,1024, 768, null);      
       
    }
}
