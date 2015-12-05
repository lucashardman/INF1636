package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cards.GoalAchieved;
import cards.cardsWindow;
import cards.winnerWindow;
import shareOutExercitos.shareOutWindow;
import controller.MapaFacade;
import controller.Territorio;
import dice.diceChallengeWindow;
import moveExercito.moveExercitoWindow;
import newGame.Player;
import newGame.newGameWindow;

@SuppressWarnings("serial")
public class sideBar extends JPanel{

	private BufferedImage image;
	private int turn;
	private Player[] newPlayers;
	private static sideBar singleton = null;
	
	private sideBar(Player[] players, MapaFacade map, gameBoard game){
		
		sideBar jpanel = this;
		
		try {                
			image = ImageIO.read(new File("src/img/Solid Mint.png"));
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		
		////////////////////////////////////////////////////////////////
		/* Distribuição inicial de territorios                        */
		/* para os jogadores e ordenação dos mesmos em turnos.        */
		
		sortTerritorios sortTerr = new sortTerritorios(map, players);
		newPlayers = sortTerr.getNewPlayers();
		
		order(newPlayers);
		
		for(int i=0; i<players.length; i++){
			System.out.printf(players[i].getName()+" recebe: ");
			newPlayers[i].setExercitos(1);
			
			for(Territorio t: players[i].getTerritorios()){
				System.out.printf(t.getTerritorio()+", ");
			}
			System.out.printf("\n");
		}
		
		MapaFacade playerTerr = new MapaFacade(newPlayers);
		game.changeLeftComponent(playerTerr);

		List<Territorio> aux = new ArrayList<Territorio>();
		aux = map.getTerritorios();
		for(Territorio t: aux){
			t.setExercitos(1);
		}
		playerTerr.updateMapa(aux);
		game.changeLeftComponent(playerTerr);
		
		////////////////////////////////////////////////////////////////

		Icon exitIcon = new ImageIcon("src/img/exit.png");
		
		JButton exit = new JButton(exitIcon);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(205, 730, 32, 32);
		exit.setToolTipText("Sair");
		jpanel.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(5);
				
			}
		});
		
		Icon restartIcon = new ImageIcon("src/img/restart.png");
		
		JButton restart = new JButton(restartIcon);
		restart.setBorderPainted(false);
		restart.setContentAreaFilled(false);
		restart.setBounds(165, 730, 32, 32);
		restart.setToolTipText("Reiniciar o jogo");
		jpanel.add(restart);
		
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.dispose();
				
				newGameWindow k = new newGameWindow();
				k.setResizable(false);
		        k.setVisible(true);
				
			}
		});
		
		Icon aboutIcon = new ImageIcon("src/img/about.png");
		
		JButton about = new JButton(aboutIcon);
		about.setBorderPainted(false);
		about.setContentAreaFilled(false);
		about.setBounds(120, 730, 32, 32);
		about.setToolTipText("Sobre");
		jpanel.add(about);
		
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame aboutWindow = new JFrame("Sobre");
				JPanel aboutPanel = new JPanel();
				
				Toolkit tk=Toolkit.getDefaultToolkit();
				Dimension screenSize = tk.getScreenSize();
				
				int sl=screenSize.width;
				int sa=screenSize.height;
				int x=sl/2-400/2;
				int y=sa/2-300/2;
				
				aboutWindow.setResizable(false);
				aboutPanel.setBackground(Color.white);
				
				JLabel text = new JLabel ();
				text.setBounds(10, -45, 400, 300);

				text.setText("<html>Este jogo WAR é um projeto da disciplina [INF1636] "+
							 "Programação\nOrientada a Objetos da Pontifícia Universidade "+
							 "Católica do Rio de Janeiro e tem o objetivo de avaliar o "+
							 "aprendizado da linguagem Java e dos conceitos de orientação a objetos.<br><br>"+
							 "Equipe:<br><br>Thays Monteiro - 1121886<br>E-Mail: thaysc.monteiro@gmail.com<br><br>Lucas Hardman - 1113567"+
							 "<br>E-Mail: lucas.hardman@me.com</html>");
				aboutPanel.add(text);
				
				ImageIcon img = new ImageIcon("src/icon.png");
				aboutWindow.setIconImage(img.getImage());
				
				aboutPanel.setLayout(null);
				

				
				aboutWindow.setBounds(x,y,450,300);
				
				aboutWindow.add(aboutPanel);
				
				aboutWindow.setVisible(true);
			}
		});
		
		JButton next = new JButton("Iniciar");
		
		next.setLayout(null);
		next.setBounds(250/2 - 110/2, 650, 110, 30);
		jpanel.add(next);
		
		JLabel shuffleTerritorios = new JLabel();
		shuffleTerritorios.setText("<html>Os territórios foram distribuidos<br>entre os jogadores e cada um <br>possui 1 exército.</html>");
		shuffleTerritorios.setFont(new Font("Verdana", 1, 13));
		shuffleTerritorios.setBounds(7, -45, 260, 300);
		jpanel.add(shuffleTerritorios);
		
		repaint();
		
		setLayout(null);
		
		turn = 0;
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jpanel.removeAll();
				jpanel.add(next);
				jpanel.add(about);
				jpanel.add(exit);
				jpanel.add(restart);
				
				next.setText("Próximo");

				turn( playerTerr, turn, jpanel, game);	
				
				/*********************************/
				if(turn-1>-1){
					GoalAchieved achieved = new GoalAchieved(newPlayers[turn-1], map);
					if(achieved.getWinner()!=null){
						
						winnerWindow winnerAnnounce = new winnerWindow(newPlayers[turn-1]);
						winnerAnnounce.setResizable(false);
						winnerAnnounce.setVisible(true);
						jpanel.remove(next);
						JButton end = new JButton("Fim");
						
						end.setLayout(null);
						end.setBounds(250/2 - 110/2, 650, 110, 30);
						jpanel.add(end);
						end.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);
							}
						});
						System.out.println(achieved.getWinner().getName()+" venceu!!!!!");
					}
				}
				/********************************/
				
				turn++;
				
				if(turn == newPlayers.length)
					turn = 0;
					
			}
		});

	}
	
	public static sideBar getSideBar(Player[] players, MapaFacade map, gameBoard game){
		
		if(singleton == null)
			singleton = new sideBar(players, map, game);
		
		return singleton;
	}
	
	/* Trata da atualização dos elementos do JPanel em cada turno */
	private void turn (MapaFacade map, int turn, sideBar jpanel, gameBoard game){
		
		repaint();
		
		setLayout(null);
		
		List<Territorio> aux = new ArrayList<Territorio>();
		aux = newPlayers[turn].getTerritorios();
		newPlayers[turn].setExercitos(aux.size()/2);

		JLabel ColorTop = new JLabel();
		JLabel ColorBottom = new JLabel();
		JLabel playerName = new JLabel();
		playerName.setBounds(10, 0, 250, 40);
		playerName.setFont(new Font("Verdana", 1, 20));

		playerName.setText(newPlayers[turn].getName());
		ColorTop.setBackground(newPlayers[turn].getColor());
		ColorBottom.setBackground(newPlayers[turn].getColor());
		
		jpanel.add(playerName);
		
		ColorTop.setBounds(10, 40, 225, 25);
		
		ColorTop.setBorder(new LineBorder(Color.black, 2));
		ColorTop.setOpaque(true);
		jpanel.add(ColorTop);
		
		ColorBottom.setBounds(10, 695, 225, 25);
		
		ColorBottom.setBorder(new LineBorder(Color.black, 2));
		ColorBottom.setOpaque(true);
		jpanel.add(ColorBottom);
		
		Icon diceIcon = new ImageIcon("src/img/dados/dice_icon.png");
		
		JButton dice = new JButton(diceIcon);
		dice.setBorderPainted(false);
		dice.setContentAreaFilled(false);
		dice.setBounds(20, 80, 64, 64);
		dice.setToolTipText("Rodar os dados");

		dice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceChallengeWindow challenge = new diceChallengeWindow(game, map, newPlayers, newPlayers[turn], jpanel);
				challenge.setResizable(false);
				challenge.setVisible(true);
			}
		});
		
		jpanel.add(dice);
		
		Icon exercitosIcon = new ImageIcon("src/img/exercitos.png");
		
		JButton exercitos = new JButton(exercitosIcon);
		exercitos.setBorderPainted(false);
		exercitos.setContentAreaFilled(false);
		exercitos.setBounds(144, 80, 64, 64);
		exercitos.setToolTipText("Distribuir Exércitos");

		exercitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shareOutWindow shareOut = new shareOutWindow(map, jpanel, newPlayers[turn].getExercitos(), newPlayers[turn].getTerritorios(), newPlayers[turn]);
				shareOut.setResizable(false);
				shareOut.setVisible(true);
				shareOut.getTerritorio();
				exercitos.setEnabled(false);
			}
		});
		
		jpanel.add(exercitos);
		
		Icon moveExercitoIcon = new ImageIcon("src/img/moveMap.png");
		
		JButton moveExercitoButton = new JButton(moveExercitoIcon);
		moveExercitoButton.setBorderPainted(false);
		moveExercitoButton.setContentAreaFilled(false);
		moveExercitoButton.setBounds(20, 164, 64, 64);
		moveExercitoButton.setToolTipText("Avançar fronteira");

		moveExercitoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveExercitoWindow moveExercito = new moveExercitoWindow(map, jpanel, newPlayers[turn].getExercitos(), newPlayers[turn].getTerritorios(), newPlayers[turn]);
				moveExercito.setResizable(false);
				moveExercito.setVisible(true);
				
				
			}
		});
		
		jpanel.add(moveExercitoButton);
		
		Icon cardsIcon = new ImageIcon("src/img/cards.png");
		
		JButton cardsButton = new JButton(cardsIcon);
		cardsButton.setBorderPainted(false);
		cardsButton.setContentAreaFilled(false);
		cardsButton.setBounds(144, 164, 64, 64);
		cardsButton.setToolTipText("Cartas");

		cardsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardsWindow cards = new cardsWindow(newPlayers[turn]);
				cards.setResizable(false);
				cards.setVisible(true);
				
				
			}
		});
		
		jpanel.add(cardsButton);
		
		System.out.println(newPlayers[turn].getGoal());
		
	}
	
	/* Algoritimo para ordenação de Player[] */
	private static void order(Player[] array) {
		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i].getNumber() < array[menor].getNumber()) {
					menor = i;
				}
			}
			if (menor != fixo) {
				Player t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}
	}
	
	public void updateNewPlayers(Player[] p){
		newPlayers = p;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,1024, 768, null);      
       
    }
}
