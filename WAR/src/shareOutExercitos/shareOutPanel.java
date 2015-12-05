package shareOutExercitos;

import game.sideBar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class shareOutPanel extends JPanel{
	
	private BufferedImage image;
	private int changeExercitos;
	private List<Territorio> lstTerritoriosSend;
	private int exercitosUtilizados;
	private int inputExercitos;
	
	public shareOutPanel(MapaFacade map, sideBar sideBarPanel,JFrame jframe, int exercitos, List<Territorio> lstTerritorios, Player turnPlayer){
		
		JPanel jpanel = this;
		jpanel.setLayout(null);
		
		changeExercitos = exercitos;
		
		if(turnPlayer.getTerritorios().containsAll(map.getAmericaDoNorte()))
			changeExercitos = changeExercitos+5;
		if(turnPlayer.getTerritorios().containsAll(map.getAmericaDoSul()))
			changeExercitos = changeExercitos+2;
		if(turnPlayer.getTerritorios().containsAll(map.getAfrica()))
			changeExercitos = changeExercitos+3;
		if(turnPlayer.getTerritorios().containsAll(map.getEuropa()))
			changeExercitos = changeExercitos+5;
		if(turnPlayer.getTerritorios().containsAll(map.getAsia()))
			changeExercitos = changeExercitos+7;
		if(turnPlayer.getTerritorios().containsAll(map.getOceania()))
			changeExercitos = changeExercitos+2;
		
		try {                
			image = ImageIO.read(new File("src/img/Solid Mint.png"));
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		Territorio[] arrayTerritorios = new Territorio[lstTerritorios.size()];
		lstTerritorios.toArray(arrayTerritorios);
		String[] arrayTerritoriosName = new String [lstTerritorios.size()];
		
		for(int i=0; i<arrayTerritorios.length; i++){
			arrayTerritoriosName[i]= arrayTerritorios[i].getTerritorio();
		}
		
		JComboBox<String> chooseTerritorio = new JComboBox<String>(arrayTerritoriosName);
		chooseTerritorio.setVisible(true);
		chooseTerritorio.setBounds(15, 45, 465, 30);
		jpanel.add(chooseTerritorio);

		JLabel numExercitos = new JLabel("Exércitos disponiveis para distribuição: "+changeExercitos);
		numExercitos.setBounds(15, 5, 465, 30);
		numExercitos.setFont(new Font("Verdana", 1, 13));
		numExercitos.setVisible(true);
		jpanel.add(numExercitos);
		
		JButton OK = new JButton("OK");
		OK.setBounds(500/2-100/2, 300, 100,40);
		
		jpanel.add(OK);
		
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println((String)chooseTerritorio.getSelectedItem());
				String inputExercitosString = JOptionPane.showInputDialog(jframe, "Inserir quantos exércitos?");
				
				jpanel.remove(numExercitos);
				inputExercitos=0;
				
				try{
					inputExercitos = Integer.parseInt(inputExercitosString);
				}
				catch (NumberFormatException ne){
					JOptionPane.showMessageDialog(jframe, "Valor Inválido");
				}
				
				if(inputExercitos>0 && inputExercitos<=changeExercitos){
					
					setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(), inputExercitos);
					changeExercitos = changeExercitos - inputExercitos;
				}
				else if(inputExercitos != 0)
					JOptionPane.showMessageDialog(jframe, "Quantidade Inválida");
				
				for(Territorio t: lstTerritorios){
					if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
						System.out.println(t.getTerritorio()+" recebeu "+t.getExercitos()+" exércitos.");
					}
				}
				
				
				if(changeExercitos==0){
					jpanel.remove(OK);
					JButton OK2 = new JButton("OK");
					OK2.setBounds(500/2-100/2, 300, 100,40);
					OK2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jframe.dispose();
						}
					});
					jpanel.add(OK2);
					jpanel.repaint();
				}
				
				numExercitos.setText("Exércitos disponiveis para distribuição: "+changeExercitos);
				numExercitos.setBounds(15, 5, 465, 30);
				numExercitos.setFont(new Font("Verdana", 1, 13));
				numExercitos.setVisible(true);
				jpanel.add(numExercitos);
				
				jpanel.repaint();
			}
		});
		
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
	}	
	
	public void setExercitosToTerritorio (List<Territorio> lstTerritorios, String Territorio, int exercitos){
		
		for(Territorio t: lstTerritorios){
			if(t.getTerritorio() == Territorio){
				t.setExercitos(exercitos);
			}
		}
		lstTerritoriosSend = lstTerritorios;

	}
	
	public List<Territorio> getTerritorio (){
		return lstTerritoriosSend;
	}
	
	public int getExercitosUtilizados(){
		return exercitosUtilizados;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 1024, 768, null);

	}
}
