package dice;

import game.gameBoard;
import game.sideBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.MapaFacade;
import controller.Territorio;
import newGame.Player;

@SuppressWarnings("serial")
public class dicePanel extends JPanel{
	
	private BufferedImage image;
	private int ThrowAUX; //Variavel auxiliar para controlar o botão de lançamento dos dados.
	
	private int atkValue = 0;
	private int defValue = 0;
	
	public dicePanel(gameBoard game, MapaFacade map, JFrame jframe, Player atk, Player def, Territorio atkTerr, Territorio defTerr, Player[] players, sideBar side){
		
		JPanel jpanel = this;
		jpanel.setLayout(null);
		
		try {                
			image = ImageIO.read(new File("src/img/Solid Mint.png"));
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		
		Icon exitIcon = new ImageIcon("src/img/exit.png");
		
		JButton exit = new JButton(exitIcon);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(456, 320, 32, 32);
		exit.setToolTipText("Fechar janela");
		jpanel.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe.dispose();
				
			}
		});
		
		JLabel ATKdice1 = new JLabel();
		JLabel ATKdice2 = new JLabel();
		JLabel ATKdice3 = new JLabel();
		JLabel DEFdice1 = new JLabel();
		JLabel DEFdice2 = new JLabel();
		JLabel DEFdice3 = new JLabel();	
		
		JLabel atkLabel = new JLabel();
		JLabel defLabel = new JLabel();
		JLabel atkColor = new JLabel();
		JLabel defColor = new JLabel();
		
		atkLabel.setText("Atacante: "+atk.getName());
		atkLabel.setBounds(10, 0, 490, 40);
		atkLabel.setFont(new Font("Verdana", 1, 20));
		jpanel.add(atkLabel);
		
		atkColor.setBackground(atk.getColor());
		atkColor.setBounds(5, 40, 482, 15);
		atkColor.setBorder(new LineBorder(Color.black, 2));
		atkColor.setOpaque(true);
		jpanel.add(atkColor);
		
		defLabel.setText("Defensor: "+def.getName());
		defLabel.setBounds(10, 160, 490, 40);
		defLabel.setFont(new Font("Verdana", 1, 20));
		jpanel.add(defLabel);
		
		defColor.setBackground(def.getColor());
		defColor.setBounds(5, 200, 482, 15);
		defColor.setBorder(new LineBorder(Color.black, 2));
		defColor.setOpaque(true);
		jpanel.add(defColor);
		
		JButton Throw = new JButton("Lançar dados");
		Throw.setBounds(500/2-120/2, 300, 120, 30);
		jpanel.add(Throw);
		
		ThrowAUX = 0;
		Throw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanel.repaint();
				jpanel.setLayout(null);

				if(ThrowAUX==0){
					dice(jpanel, ATKdice1, 0);
					ATKdice1.setBounds(10, 70, 32, 32);
					jpanel.add(ATKdice1);
				}
				if(ThrowAUX==1){
					dice(jpanel, ATKdice2, 0);
					ATKdice2.setBounds(52, 70, 32, 32);
					jpanel.add(ATKdice2);
				}
				if(ThrowAUX==2){
					dice(jpanel, ATKdice3, 0);
					ATKdice3.setBounds(92, 70, 32, 32);
					jpanel.add(ATKdice3);
				}
				if(ThrowAUX==3){
					dice(jpanel, DEFdice1, 1);
					DEFdice1.setBounds(10, 230, 32, 32);
					jpanel.add(DEFdice1);
				}
				if(ThrowAUX==4){
					dice(jpanel, DEFdice2, 1);
					DEFdice2.setBounds(52, 230, 32, 32);
					jpanel.add(DEFdice2);
				}
				if(ThrowAUX==5){
					dice(jpanel, DEFdice3, 1);
					DEFdice3.setBounds(92, 230, 32, 32);
					jpanel.add(DEFdice3);
					Throw.setText("OK");
				}
				if(ThrowAUX>=6){
					
					if(atkValue>defValue){
						defTerr.looseExercitos(3);
						if(defTerr.getExercitos()<0){
							map.changeTerritorio(defTerr, atk);
							atk.addTerritorio(defTerr);
							atkTerr.looseExercitos(3);
							defTerr.resetExercitos();
							defTerr.setExercitos(3);
							for(Player p: players){
								if(p.getName()==atk.getName()){
									p = atk;
								}
							}
							game.changeLeftComponent(map);
							side.updateNewPlayers(players);
							game.changeRightComponent(side);
						}
						JOptionPane.showMessageDialog(jframe, atkTerr.getTerritorio()+" venceu!!");
						System.out.println("atacante venceu. defensor perdeu 3 exercitos: "+defTerr.getExercitos());
					}
					else if(defValue>atkValue){
						atkTerr.looseExercitos(3);
						if(defTerr.getExercitos()<0){
							map.changeTerritorio(atkTerr, def);
							game.changeLeftComponent(map);
						}
						JOptionPane.showMessageDialog(jframe, defTerr.getTerritorio()+" venceu!!");
						System.out.println("defensor venceu. atacante perdeu 3 exercitos: "+atkTerr.getExercitos());
					}
					else if(atkValue == defValue){
						JOptionPane.showMessageDialog(jframe, "Empate");
						jframe.dispose();
					}
					jframe.dispose();
				}
				ThrowAUX++;
			}
		});
		
	}
	
	/* Gerador de dados */
	private void dice (JPanel jpanel, JLabel dice, int atkORdef){
		
		jpanel.repaint();
		jpanel.setLayout(null);
		
		ImageIcon dice1atk = new ImageIcon("src/img/dados/dado_ataque_1.png");
		ImageIcon dice2atk = new ImageIcon("src/img/dados/dado_ataque_2.png");
		ImageIcon dice3atk = new ImageIcon("src/img/dados/dado_ataque_3.png");
		ImageIcon dice4atk = new ImageIcon("src/img/dados/dado_ataque_4.png");
		ImageIcon dice5atk = new ImageIcon("src/img/dados/dado_ataque_5.png");
		ImageIcon dice6atk = new ImageIcon("src/img/dados/dado_ataque_6.png");
		
		ImageIcon dice1def = new ImageIcon("src/img/dados/dado_defesa_1.png");
		ImageIcon dice2def = new ImageIcon("src/img/dados/dado_defesa_2.png");
		ImageIcon dice3def = new ImageIcon("src/img/dados/dado_defesa_3.png");
		ImageIcon dice4def = new ImageIcon("src/img/dados/dado_defesa_4.png");
		ImageIcon dice5def = new ImageIcon("src/img/dados/dado_defesa_5.png");
		ImageIcon dice6def = new ImageIcon("src/img/dados/dado_defesa_6.png");
		
		Random random = new Random();
		
		int randomNumber = random.nextInt(6);

		if (atkORdef == 0) {
			switch (randomNumber) {

			case 0:
				dice.setIcon(dice1atk);
				atkValue = atkValue + 1;
				break;
			case 1:
				dice.setIcon(dice2atk);
				atkValue = atkValue + 2;
				break;
			case 2:
				dice.setIcon(dice3atk);
				atkValue = atkValue + 3;
				break;
			case 3:
				dice.setIcon(dice4atk);
				atkValue = atkValue + 4;
				break;
			case 4:
				dice.setIcon(dice5atk);
				atkValue = atkValue + 5;
				break;
			case 5:
				dice.setIcon(dice6atk);
				atkValue = atkValue + 6;
				break;
			}
		}
		if (atkORdef == 1) {
			switch (randomNumber) {

			case 0:
				dice.setIcon(dice1def);
				defValue = defValue + 1;
				break;
			case 1:
				dice.setIcon(dice2def);
				defValue = defValue + 2;
				break;
			case 2:
				dice.setIcon(dice3def);
				defValue = defValue + 3;
				break;
			case 3:
				dice.setIcon(dice4def);
				defValue = defValue + 4;
				break;
			case 4:
				dice.setIcon(dice5def);
				defValue = defValue + 5;
				break;
			case 5:
				dice.setIcon(dice6def);
				defValue = defValue + 6;
				break;
			}
		}
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,1024, 768, null);      
       
    }
}
