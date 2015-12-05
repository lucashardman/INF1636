package dice;

import game.gameBoard;
import game.sideBar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MapaFacade;
import controller.Territorio;
import newGame.Player;

@SuppressWarnings("serial")
public class diceChallenge extends JPanel {

	private BufferedImage image;
	private Player defender;

	public diceChallenge(gameBoard game, MapaFacade map, JFrame jframe,
			Player[] players, Player turnPlayer, sideBar side) {

		try {
			image = ImageIO.read(new File("src/img/Solid Mint.png"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}

		JPanel jpanel = this;

		jpanel.setLayout(null);

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

		JLabel atk = new JLabel();

		atk.setText("Selecione um país atacante: ");
		atk.setFont(new Font("Verdana", 1, 13));

		atk.setBounds(10, 5, 490, 40);
		jpanel.add(atk);

		List<Territorio> listTerritoriosPlayer = new ArrayList<Territorio>();
		listTerritoriosPlayer = turnPlayer.getTerritorios();
		Territorio[] arrayTerritoriosPlayer = new Territorio[listTerritoriosPlayer
				.size()];
		arrayTerritoriosPlayer = listTerritoriosPlayer
				.toArray(arrayTerritoriosPlayer);

		String arrayTerritoriosNamePlayer[] = new String[arrayTerritoriosPlayer.length];

		for (int i = 0; i < arrayTerritoriosPlayer.length; i++) {
			arrayTerritoriosNamePlayer[i] = arrayTerritoriosPlayer[i]
					.getTerritorio();
		}

		JComboBox<String> chooseTerritorioATK = new JComboBox<String>(
				arrayTerritoriosNamePlayer);
		chooseTerritorioATK.setVisible(true);
		chooseTerritorioATK.setBounds(15, 45, 465, 30);
		jpanel.add(chooseTerritorioATK);

		JLabel def = new JLabel();

		def.setText("Selecione um país para ser atacado: ");
		def.setFont(new Font("Verdana", 1, 13));

		def.setBounds(10, 75, 490, 40);
		jpanel.add(def);

		JButton OK = new JButton("OK");
		OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
		jpanel.add(OK);

		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLayout(null);
				repaint();
				jpanel.remove(OK);
				chooseTerritorioATK.setEnabled(false);

				List<Territorio> listTerritoriosPlayerOK = new ArrayList<Territorio>();
				listTerritoriosPlayerOK = turnPlayer.getTerritorios();

				if ((String) chooseTerritorioATK.getSelectedItem() == "Alasca") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getAlascaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Calgary") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getCalgaryBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Groelandia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getGroelandiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Vancouver") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getVancouverBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Quebec") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getQuebecBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "California") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getCaliforniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Texas") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getTexasBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Nova York") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getNovaYorkBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Mexico") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getMexicoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Venezuela") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getVenezuelaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Peru") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getPeruBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Brasil") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getBrasilBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Argentina") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getArgentinaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Africa do Sul") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getAfricaDoSulBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Angola") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getAngolaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Argélia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getArgeliaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Egito") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getEgitoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Nigéria") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getNigeriaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Somália") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getSomaliaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Espanha") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getEspanhaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "França") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getFrancaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Itália") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getItaliaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Polônia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getPoloniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Reino Unido") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getReinoUnidoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Romênia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getRomeniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Suécia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getSueciaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Ucrânia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getUcraniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Arábia Saudita") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getArabiaSauditaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Bangladesh") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getBangladeshBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Cazaquistão") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getCazaquistaoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Mongólia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getMongoliaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "China") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getChinaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Coréia do Norte") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getCoreiaDoNorteBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Coréia do Sul") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getCoreiaDoSulBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Estônia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getEstoniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Letônia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getLetoniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Índia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getIndiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Irã") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getIraBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Iraque") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getIraqueBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Japão") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getJapaoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Jordânia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getJordaniaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Paquistão") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getPaquistaoBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Russia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getRussiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Sibéria") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getSiberiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Siria") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getSiriaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Tailândia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getTailandiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Turquia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getTurquiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Austrália") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getAustraliaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Indonésia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getIndonesiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Nova Zelândia") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getNovaZelandiaBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

				if ((String) chooseTerritorioATK.getSelectedItem() == "Perth") {

					List<Territorio> listTerritoriosDEF = new ArrayList<Territorio>();
					listTerritoriosDEF = map.getPerthBorder();

					List<Territorio> union = new ArrayList<Territorio>();

					for (Territorio t : listTerritoriosDEF) {
						if (!listTerritoriosPlayerOK.contains(t)) {
							union.add(t);
						}
					}

					listTerritoriosDEF = union;

					Territorio[] arrayTerritorios = new Territorio[union.size()];
					arrayTerritorios = listTerritoriosDEF
							.toArray(arrayTerritorios);

					String arrayTerritoriosDEFName[] = new String[arrayTerritorios.length];

					for (int i = 0; i < arrayTerritorios.length; i++) {
						arrayTerritoriosDEFName[i] = arrayTerritorios[i]
								.getTerritorio();
					}

					JComboBox<String> chooseTerritorioDEF = new JComboBox<String>(
							arrayTerritoriosDEFName);
					chooseTerritorioDEF.setVisible(true);
					chooseTerritorioDEF.setBounds(15, 115, 465, 30);
					jpanel.add(chooseTerritorioDEF);

					JButton OK = new JButton("OK");
					OK.setBounds(500 / 2 - 120 / 2, 300, 120, 30);
					jpanel.add(OK);

					OK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (Player p : players) {
								for (Territorio t : p.getTerritorios()) {

									if (t.getTerritorio() == (String) chooseTerritorioDEF
											.getSelectedItem()) {
										defender = p;
										System.out.println("Defensor é: "
												+ p.getName());
										jframe.dispose();
									}
								}
							}

							Territorio territorioATK = null;
							Territorio territorioDEF = null;

							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioATK
										.getSelectedItem()) {
									territorioATK = t;
								}
							}
							for (Territorio t : map.getTerritorios()) {
								if (t.getTerritorio() == (String) chooseTerritorioDEF
										.getSelectedItem()) {
									territorioDEF = t;
								}
							}

							if (territorioATK.getExercitos() <= 3) {
								JOptionPane.showMessageDialog(jframe,
										"Exercitos insuficientes");
							} else {
								diceWindow challenge = new diceWindow(game,
										map, turnPlayer, defender,
										territorioATK, territorioDEF, players,
										side);
								challenge.setResizable(false);
								challenge.setVisible(true);
							}
						}
					});
				}

			}
		});

	}

	public Player getChallenged() {
		return defender;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 1024, 768, null);

	}
}
