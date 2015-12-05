package newGame;

import game.gameBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import newGame.Player;
import cards.RandomGoals;

@SuppressWarnings("serial")
public class newGameContent extends JPanel {

	private BufferedImage image;
	private Player[] sendPlayers;
	
	public newGameContent(JFrame newGameWindow) {

		JPanel jpanel = this;

		try {
			image = ImageIO.read(new File("src/img/war_inicio.png"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		
		jpanel.setLayout(null);

		JButton novoJogo = new JButton("Novo Jogo");
		JButton fecharJogo = new JButton("Fechar Jogo");

		novoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int pad = 40; // Espacamento entre as JLabel com a ordem dos jogadores.

				fecharJogo.setVisible(false);
				novoJogo.setVisible(false);

				repaint();

				try {
					image = ImageIO.read(new File("src/img/war_soldiers.png"));
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
					System.exit(1);
				}

				JButton treePlayers = new JButton("3 Jogadores");
				JButton fourPlayers = new JButton("4 Jogadores");
				JButton fivePlayers = new JButton("5 Jogadores");
				JButton sixPlayers = new JButton("6 Jogadores");

				/* Botão de três jogadores */

				treePlayers.setLayout(null);
				treePlayers.setBounds(277, 150, 110, 30);
				add(treePlayers);

				treePlayers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						sendPlayers = new Player[3];
						
						for (int z = 0; z < sendPlayers.length; z++) {
							sendPlayers[z] = new Player();
						}
						
						repaint();

						try {
							image = ImageIO.read(new File(
									"src/img/war_players.png"));
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
							System.exit(1);
						}
						
						/* Botão de OK que termina a janela com a ordem
						 * dos jogadores e inicia uma nova janela com o
						 * mapa do jogo */
						
						JButton OK = new JButton("OK");
						OK.setLayout(null);
						OK.setBounds(1024 / 2 - 110 / 2, 500, 110, 30);
						add(OK);
						OK.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gameBoard j = new gameBoard(sendPlayers);
								j.setVisible(true);
								newGameWindow.dispose();
							}
						});
						/* Fim botão de OK */

						/* Criação de um vetor de Player */
						
						Player players[] = new Player[3];

						for (int k = 0; k < players.length; k++) {
							players[k] = new Player();
						}
						
						/* Fim da criação do vetor de Player */

						treePlayers.setVisible(false);
						fourPlayers.setVisible(false);
						fivePlayers.setVisible(false);
						sixPlayers.setVisible(false);

						System.out.printf("BOTÃO 3 PRESSIONADO\n");

						setPlayers play = new setPlayers();

						players = play.numberOfPlayers(3);

						/* Etiquetas (label) com os nomes e as cores
						 * dos jogadores de cada posição. */
						
						JLabel first = new JLabel();
						JLabel firstColor = new JLabel();

						first.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 3; aux++) {
							if (players[aux].getNumber() == 0) {
								first.setText("1°       "
										+ players[aux].getName());
								firstColor.setBackground(players[aux]
										.getColor());
							}
						}
						first.setForeground(Color.black);
						first.setBounds(250, 60 + 0 * pad, 2000, 50);
						firstColor.setBounds(285, 72 + 0 * pad, 25, 25);
						firstColor.setBorder(new LineBorder(Color.black, 2));
						firstColor.setOpaque(true);
						jpanel.add(first);
						jpanel.add(firstColor);

						JLabel second = new JLabel();
						JLabel secondColor = new JLabel();

						second.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 3; aux++) {
							if (players[aux].getNumber() == 1) {
								second.setText("2°       "
										+ players[aux].getName());
								secondColor.setBackground(players[aux]
										.getColor());
							}
						}
						second.setForeground(Color.black);
						second.setBounds(250, 60 + 1 * pad, 2000, 50);
						secondColor.setBounds(285, 72 + 1 * pad, 25, 25);
						secondColor.setBorder(new LineBorder(Color.black, 2));
						secondColor.setOpaque(true);
						jpanel.add(second);
						jpanel.add(secondColor);

						JLabel third = new JLabel();
						JLabel thirdColor = new JLabel();

						third.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 3; aux++) {
							if (players[aux].getNumber() == 2) {
								third.setText("3°       "
										+ players[aux].getName());
								thirdColor.setBackground(players[aux]
										.getColor());
							}
						}
						third.setForeground(Color.black);
						third.setBounds(250, 60 + 2 * pad, 2000, 50);
						thirdColor.setBounds(285, 72 + 2 * pad, 25, 25);
						thirdColor.setBorder(new LineBorder(Color.black, 2));
						thirdColor.setOpaque(true);
						jpanel.add(third);
						jpanel.add(thirdColor);

						for (int i = 0; i < players.length; i++) {

							System.out.println(players[i].getNumber());
							System.out.println(players[i].getColor());
							System.out.println(players[i].getName());
							sendPlayers[i].setNumber(players[i].getNumber());
							sendPlayers[i].setColor(players[i].getColor());
							sendPlayers[i].setName(players[i].getName());
						}
						
						RandomGoals g = new RandomGoals(sendPlayers);
						sendPlayers = g.getGoals();
						
						/* Fim: tratamento das etiquetas (label) */
					}
				});

				/* Fim: botão de três jogadores */

				/* Botão de quatro jogadores */

				fourPlayers.setLayout(null);
				fourPlayers.setBounds(15 + 277 + 1 * 110, 150, 110, 30);
				add(fourPlayers);

				fourPlayers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						sendPlayers = new Player[4];
						
						for (int z = 0; z < sendPlayers.length; z++) {
							sendPlayers[z] = new Player();
						}
						
						repaint();

						try {
							image = ImageIO.read(new File(
									"src/img/war_players.png"));
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
							System.exit(1);
						}

						JButton OK = new JButton("OK");
						OK.setLayout(null);
						OK.setBounds(1024 / 2 - 110 / 2, 500, 110, 30);
						add(OK);
						OK.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gameBoard j = new gameBoard(sendPlayers);
								j.setVisible(true);
								newGameWindow.dispose();
							}
						});

						Player players[] = new Player[4];

						for (int k = 0; k < players.length; k++) {
							players[k] = new Player();
						}

						treePlayers.setVisible(false);
						fourPlayers.setVisible(false);
						fivePlayers.setVisible(false);
						sixPlayers.setVisible(false);

						System.out.printf("BOTÃO 4 PRESSIONADO\n");

						setPlayers play = new setPlayers();

						players = play.numberOfPlayers(4);

						JLabel first = new JLabel();
						JLabel firstColor = new JLabel();

						first.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 4; aux++) {
							if (players[aux].getNumber() == 0) {
								first.setText("1°       "
										+ players[aux].getName());
								firstColor.setBackground(players[aux]
										.getColor());
							}
						}
						first.setForeground(Color.black);
						first.setBounds(250, 60 + 0 * pad, 2000, 50);
						firstColor.setBounds(285, 72 + 0 * pad, 25, 25);
						firstColor.setBorder(new LineBorder(Color.black, 2));
						firstColor.setOpaque(true);

						jpanel.add(first);
						jpanel.add(firstColor);

						JLabel second = new JLabel();
						JLabel secondColor = new JLabel();

						second.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 4; aux++) {
							if (players[aux].getNumber() == 1) {
								second.setText("2°       "
										+ players[aux].getName());
								secondColor.setBackground(players[aux]
										.getColor());
							}
						}
						second.setForeground(Color.black);
						second.setBounds(250, 60 + 1 * pad, 2000, 50);
						secondColor.setBounds(285, 72 + 1 * pad, 25, 25);
						secondColor.setBorder(new LineBorder(Color.black, 2));
						secondColor.setOpaque(true);
						jpanel.add(second);
						jpanel.add(secondColor);

						JLabel third = new JLabel();
						JLabel thirdColor = new JLabel();

						third.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 4; aux++) {
							if (players[aux].getNumber() == 2) {
								third.setText("3°       "
										+ players[aux].getName());
								thirdColor.setBackground(players[aux]
										.getColor());
							}
						}
						third.setForeground(Color.black);
						third.setBounds(250, 60 + 2 * pad, 2000, 50);
						thirdColor.setBounds(285, 72 + 2 * pad, 25, 25);
						thirdColor.setBorder(new LineBorder(Color.black, 2));
						thirdColor.setOpaque(true);
						jpanel.add(third);
						jpanel.add(thirdColor);

						JLabel fourth = new JLabel();
						JLabel fourthColor = new JLabel();

						fourth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 4; aux++) {
							if (players[aux].getNumber() == 3) {
								fourth.setText("4°       "
										+ players[aux].getName());
								fourthColor.setBackground(players[aux]
										.getColor());
							}
						}
						fourth.setForeground(Color.black);
						fourth.setBounds(250, 60 + 3 * pad, 2000, 50);
						fourthColor.setBounds(285, 72 + 3 * pad, 25, 25);
						fourthColor.setBorder(new LineBorder(Color.black, 2));
						fourthColor.setOpaque(true);
						jpanel.add(fourth);
						jpanel.add(fourthColor);

						for (int i = 0; i < players.length; i++) {
							System.out.println(players[i].getNumber());
							System.out.println(players[i].getColor());
							System.out.println(players[i].getName());
							sendPlayers[i].setNumber(players[i].getNumber());
							sendPlayers[i].setColor(players[i].getColor());
							sendPlayers[i].setName(players[i].getName());
						}
						RandomGoals g = new RandomGoals(sendPlayers);
						sendPlayers = g.getGoals();
					}
				});

				/* Fim: botão de quatro jogadores */

				/* Botão de cinco jogadores */

				fivePlayers.setLayout(null);
				fivePlayers.setBounds(30 + 277 + 2 * 110, 150, 110, 30);
				add(fivePlayers);

				fivePlayers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						sendPlayers = new Player[5];
						
						for (int z = 0; z < sendPlayers.length; z++) {
							sendPlayers[z] = new Player();
						}
						
						repaint();

						try {
							image = ImageIO.read(new File(
									"src/img/war_players.png"));
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
							System.exit(1);
						}

						JButton OK = new JButton("OK");
						OK.setLayout(null);
						OK.setBounds(1024 / 2 - 110 / 2, 500, 110, 30);
						add(OK);
						OK.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gameBoard j = new gameBoard(sendPlayers);
								j.setVisible(true);
								newGameWindow.dispose();
							}
						});

						Player players[] = new Player[5];

						for (int k = 0; k < players.length; k++) {
							players[k] = new Player();
						}

						treePlayers.setVisible(false);
						fourPlayers.setVisible(false);
						fivePlayers.setVisible(false);
						sixPlayers.setVisible(false);

						System.out.printf("BOTÃO 5 PRESSIONADO\n");

						setPlayers play = new setPlayers();

						players = play.numberOfPlayers(5);

						JLabel first = new JLabel();
						JLabel firstColor = new JLabel();

						first.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 5; aux++) {
							if (players[aux].getNumber() == 0) {
								first.setText("1°       "
										+ players[aux].getName());
								firstColor.setBackground(players[aux]
										.getColor());
							}
						}
						first.setForeground(Color.black);
						first.setBounds(250, 60 + 0 * pad, 2000, 50);
						firstColor.setBounds(285, 72 + 0 * pad, 25, 25);
						firstColor.setBorder(new LineBorder(Color.black, 2));
						firstColor.setOpaque(true);

						jpanel.add(first);
						jpanel.add(firstColor);

						JLabel second = new JLabel();
						JLabel secondColor = new JLabel();

						second.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 5; aux++) {
							if (players[aux].getNumber() == 1) {
								second.setText("2°       "
										+ players[aux].getName());
								secondColor.setBackground(players[aux]
										.getColor());
							}
						}
						second.setForeground(Color.black);
						second.setBounds(250, 60 + 1 * pad, 2000, 50);
						secondColor.setBounds(285, 72 + 1 * pad, 25, 25);
						secondColor.setBorder(new LineBorder(Color.black, 2));
						secondColor.setOpaque(true);
						jpanel.add(second);
						jpanel.add(secondColor);

						JLabel third = new JLabel();
						JLabel thirdColor = new JLabel();

						third.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 5; aux++) {
							if (players[aux].getNumber() == 2) {
								third.setText("3°       "
										+ players[aux].getName());
								thirdColor.setBackground(players[aux]
										.getColor());
							}
						}
						third.setForeground(Color.black);
						third.setBounds(250, 60 + 2 * pad, 2000, 50);
						thirdColor.setBounds(285, 72 + 2 * pad, 25, 25);
						thirdColor.setBorder(new LineBorder(Color.black, 2));
						thirdColor.setOpaque(true);
						jpanel.add(third);
						jpanel.add(thirdColor);

						JLabel fourth = new JLabel();
						JLabel fourthColor = new JLabel();

						fourth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 5; aux++) {
							if (players[aux].getNumber() == 3) {
								fourth.setText("4°       "
										+ players[aux].getName());
								fourthColor.setBackground(players[aux]
										.getColor());
							}
						}
						fourth.setForeground(Color.black);
						fourth.setBounds(250, 60 + 3 * pad, 2000, 50);
						fourthColor.setBounds(285, 72 + 3 * pad, 25, 25);
						fourthColor.setBorder(new LineBorder(Color.black, 2));
						fourthColor.setOpaque(true);
						jpanel.add(fourth);
						jpanel.add(fourthColor);

						JLabel fifth = new JLabel();
						JLabel fifthColor = new JLabel();

						fifth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 5; aux++) {
							if (players[aux].getNumber() == 4) {
								fifth.setText("5°       "
										+ players[aux].getName());
								fifthColor.setBackground(players[aux]
										.getColor());
							}
						}
						fifth.setForeground(Color.black);
						fifth.setBounds(250, 60 + 4 * pad, 2000, 50);
						fifthColor.setBounds(285, 72 + 4 * pad, 25, 25);
						fifthColor.setBorder(new LineBorder(Color.black, 2));
						fifthColor.setOpaque(true);
						jpanel.add(fifth);
						jpanel.add(fifthColor);

						for (int i = 0; i < players.length; i++) {

							System.out.println(players[i].getNumber());
							System.out.println(players[i].getColor());
							System.out.println(players[i].getName());
							sendPlayers[i].setNumber(players[i].getNumber());
							sendPlayers[i].setColor(players[i].getColor());
							sendPlayers[i].setName(players[i].getName());
						}
						RandomGoals g = new RandomGoals(sendPlayers);
						sendPlayers = g.getGoals();
					}
				});

				/* Fim: botão de cinco jogadores */

				/* Botão de seis jogadores */

				sixPlayers.setLayout(null);
				sixPlayers.setBounds(45 + 277 + 3 * 110, 150, 110, 30);
				add(sixPlayers);

				sixPlayers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						sendPlayers = new Player[6];
						
						for (int z = 0; z < sendPlayers.length; z++) {
							sendPlayers[z] = new Player();
						}
						
						repaint();

						try {
							image = ImageIO.read(new File(
									"src/img/war_players.png"));
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
							System.exit(1);
						}

						JButton OK = new JButton("OK");
						OK.setLayout(null);
						OK.setBounds(1024 / 2 - 110 / 2, 500, 110, 30);
						add(OK);
						OK.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gameBoard j = new gameBoard(sendPlayers);
								j.setVisible(true);
								newGameWindow.dispose();
							}
						});

						Player players[] = new Player[6];

						for (int k = 0; k < players.length; k++) {
							players[k] = new Player();
						}

						setPlayers play = new setPlayers();

						players = play.numberOfPlayers(6);

						treePlayers.setVisible(false);
						fourPlayers.setVisible(false);
						fivePlayers.setVisible(false);
						sixPlayers.setVisible(false);

						System.out.printf("BOTÃO 6 PRESSIONADO\n");

						JLabel first = new JLabel();
						JLabel firstColor = new JLabel();

						first.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 0) {
								first.setText("1°       "
										+ players[aux].getName());
								firstColor.setBackground(players[aux]
										.getColor());
							}
						}
						first.setForeground(Color.black);
						first.setBounds(250, 60 + 0 * pad, 2000, 50);
						firstColor.setBounds(285, 72 + 0 * pad, 25, 25);
						firstColor.setBorder(new LineBorder(Color.black, 2));
						firstColor.setOpaque(true);

						jpanel.add(first);
						jpanel.add(firstColor);

						JLabel second = new JLabel();
						JLabel secondColor = new JLabel();

						second.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 1) {
								second.setText("2°       "
										+ players[aux].getName());
								secondColor.setBackground(players[aux]
										.getColor());
							}
						}
						second.setForeground(Color.black);
						second.setBounds(250, 60 + 1 * pad, 2000, 50);
						secondColor.setBounds(285, 72 + 1 * pad, 25, 25);
						secondColor.setBorder(new LineBorder(Color.black, 2));
						secondColor.setOpaque(true);
						jpanel.add(second);
						jpanel.add(secondColor);

						JLabel third = new JLabel();
						JLabel thirdColor = new JLabel();

						third.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 2) {
								third.setText("3°       "
										+ players[aux].getName());
								thirdColor.setBackground(players[aux]
										.getColor());
							}
						}
						third.setForeground(Color.black);
						third.setBounds(250, 60 + 2 * pad, 2000, 50);
						thirdColor.setBounds(285, 72 + 2 * pad, 25, 25);
						thirdColor.setBorder(new LineBorder(Color.black, 2));
						thirdColor.setOpaque(true);
						jpanel.add(third);
						jpanel.add(thirdColor);

						JLabel fourth = new JLabel();
						JLabel fourthColor = new JLabel();

						fourth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 3) {
								fourth.setText("4°       "
										+ players[aux].getName());
								fourthColor.setBackground(players[aux]
										.getColor());
							}
						}
						fourth.setForeground(Color.black);
						fourth.setBounds(250, 60 + 3 * pad, 2000, 50);
						fourthColor.setBounds(285, 72 + 3 * pad, 25, 25);
						fourthColor.setBorder(new LineBorder(Color.black, 2));
						fourthColor.setOpaque(true);
						jpanel.add(fourth);
						jpanel.add(fourthColor);

						JLabel fifth = new JLabel();
						JLabel fifthColor = new JLabel();

						fifth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 4) {
								fifth.setText("5°       "
										+ players[aux].getName());
								fifthColor.setBackground(players[aux]
										.getColor());
							}
						}
						fifth.setForeground(Color.black);
						fifth.setBounds(250, 60 + 4 * pad, 2000, 50);
						fifthColor.setBounds(285, 72 + 4 * pad, 25, 25);
						fifthColor.setBorder(new LineBorder(Color.black, 2));
						fifthColor.setOpaque(true);
						jpanel.add(fifth);
						jpanel.add(fifthColor);

						JLabel sixth = new JLabel();
						JLabel sixthColor = new JLabel();

						sixth.setFont(new Font("Verdana", 1, 20));
						for (int aux = 0; aux < 6; aux++) {
							if (players[aux].getNumber() == 5) {
								sixth.setText("6°       "
										+ players[aux].getName());
								sixthColor.setBackground(players[aux]
										.getColor());
							}
						}
						sixth.setForeground(Color.black);
						sixth.setBounds(250, 60 + 5 * pad, 2000, 50);
						sixthColor.setBounds(285, 72 + 5 * pad, 25, 25);
						sixthColor.setBorder(new LineBorder(Color.black, 2));
						sixthColor.setOpaque(true);
						jpanel.add(sixth);
						jpanel.add(sixthColor);

						treePlayers.setVisible(false);
						fourPlayers.setVisible(false);
						fivePlayers.setVisible(false);
						sixPlayers.setVisible(false);

						for (int i = 0; i < players.length; i++) {
							System.out.println(players[i].getNumber());
							System.out.println(players[i].getColor());
							System.out.println(players[i].getName());
							sendPlayers[i].setNumber(players[i].getNumber());
							sendPlayers[i].setColor(players[i].getColor());
							sendPlayers[i].setName(players[i].getName());
						}
						RandomGoals g = new RandomGoals(sendPlayers);
						sendPlayers = g.getGoals();
					}
				});

				/* Fim: botão de seis jogadores */
			}

		});
		
		novoJogo.setLayout(null);
		novoJogo.setBounds(277, 550, 220, 30);

		fecharJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		fecharJogo.setLayout(null);
		fecharJogo.setBounds(250 + 277, 550, 220, 30);

		this.add(novoJogo);
		this.add(fecharJogo);

	}

	public Player[] getPlayers(){
		return sendPlayers;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 1024, 768, null);

	}
}
