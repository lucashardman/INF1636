package moveExercito;

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

import newGame.Player;
import controller.MapaFacade;
import controller.Territorio;

@SuppressWarnings("serial")
public class moveExercitoPanel extends JPanel{

	private BufferedImage image;
	private int inputExercitos;
	private List<Territorio> lstTerritoriosSend;
	
	public moveExercitoPanel(MapaFacade map, sideBar sideBarPanel,JFrame jframe, int exercitos, List<Territorio> lstTerritorios, Player turnPlayer){
		
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
		
		JLabel fromTerr = new JLabel();
		
		fromTerr.setText("Deslocar de: ");
		fromTerr.setFont(new Font("Verdana", 1, 13));
		
		fromTerr.setBounds(10, 5, 490, 40);
		jpanel.add(fromTerr);
		
		JButton OK = new JButton("OK");
		OK.setBounds(500/2-120/2, 300, 120, 30);
		OK.setEnabled(false);
		
		List<Territorio> listTerritoriosPlayer = turnPlayer.getTerritorios();
		Territorio[] arrayTerritoriosPlayer = new Territorio[listTerritoriosPlayer.size()];
		arrayTerritoriosPlayer = listTerritoriosPlayer.toArray(arrayTerritoriosPlayer);
		
		String arrayTerritoriosNamePlayer[] = new String[arrayTerritoriosPlayer.length];
		
		for(int i=0; i<arrayTerritoriosPlayer.length; i++){
			arrayTerritoriosNamePlayer[i]= arrayTerritoriosPlayer[i].getTerritorio();
		}

		JComboBox<String> chooseTerritorio = new JComboBox<String>(arrayTerritoriosNamePlayer);
		chooseTerritorio.setVisible(true);
		chooseTerritorio.setBounds(15, 45, 465, 30);
		chooseTerritorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OK.setEnabled(true);
			}
		});
		jpanel.add(chooseTerritorio);
		
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OK.setEnabled(false);
				chooseTerritorio.setEnabled(false);
				JLabel toTerr = new JLabel();
				
				toTerr.setText("Para: ");
				toTerr.setFont(new Font("Verdana", 1, 13));
				
				toTerr.setBounds(10, 75, 490, 40);
				jpanel.add(toTerr);
				
				if((String)chooseTerritorio.getSelectedItem() == "Alasca"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getAlascaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				if((String)chooseTerritorio.getSelectedItem() == "Calgary"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getCalgaryBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Groelandia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getGroelandiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Vancouver"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getVancouverBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Quebec"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getQuebecBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "California"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getCaliforniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				if((String)chooseTerritorio.getSelectedItem() == "Texas"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getTexasBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Nova York"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getNovaYorkBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Mexico"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getMexicoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Venezuela"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getVenezuelaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Peru"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getPeruBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Brasil"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getBrasilBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Argentina"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getArgentinaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Africa do Sul"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getAfricaDoSulBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Angola"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getAngolaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Arg�lia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getArgeliaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Egito"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getEgitoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Nig�ria"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getNigeriaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Som�lia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getSomaliaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Espanha"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getEspanhaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Fran�a"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getFrancaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "It�lia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getItaliaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Pol�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getPoloniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Reino Unido"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getReinoUnidoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Rom�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getRomeniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Su�cia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getSueciaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Ucr�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getUcraniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Ar�bia Saudita"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getArabiaSauditaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				if((String)chooseTerritorio.getSelectedItem() == "Bangladesh"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getBangladeshBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Cazaquist�o"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getCazaquistaoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Mong�lia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getMongoliaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "China"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getChinaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Cor�ia do Norte"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getCoreiaDoNorteBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Cor�ia do Sul"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getCoreiaDoSulBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Est�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getEstoniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Let�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getLetoniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "�ndia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getIndiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Ir�"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getIraBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Iraque"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getIraqueBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Jap�o"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getJapaoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Jord�nia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getJordaniaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Paquist�o"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getPaquistaoBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Russia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getRussiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Sib�ria"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getSiberiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Siria"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getSiriaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Tail�ndia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getTailandiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Turquia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getTurquiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Austr�lia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getAustraliaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Indon�sia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getIndonesiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Nova Zel�ndia"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getNovaZelandiaBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
				
				if((String)chooseTerritorio.getSelectedItem() == "Perth"){
					jpanel.setLayout(null);
					jpanel.repaint();
					
					JButton Mover = new JButton("Mover");
					Mover.setBounds(500/2-120/2, 300, 120, 30);
					Mover.setEnabled(false);
					
					List<Territorio> listTerritoriosBorder = map.getPerthBorder();
					Territorio[] arrayTerritoriosBorder = new Territorio[listTerritoriosBorder.size()];
					arrayTerritoriosBorder = listTerritoriosBorder.toArray(arrayTerritoriosBorder);
					
					String arrayTerritoriosNameBorder[] = new String[arrayTerritoriosBorder.length];
					
					for(int i=0; i<arrayTerritoriosBorder.length; i++){
						arrayTerritoriosNameBorder[i] = arrayTerritoriosBorder[i].getTerritorio();
					}
					JComboBox<String> chooseNewTerritorio = new JComboBox<String>(arrayTerritoriosNameBorder);
					chooseNewTerritorio.setVisible(true);
					chooseNewTerritorio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OK.setVisible(false);
							Mover.setEnabled(true);
						}
					});
					chooseNewTerritorio.setBounds(15, 115, 465, 30);
					jpanel.add(chooseNewTerritorio);
	
					Mover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							int flag=0;
							for(Territorio t: turnPlayer.getTerritorios()){
								if(t.getTerritorio()==(String)chooseNewTerritorio.getSelectedItem()){
									flag ++;
								}
							}
							
							if(flag == 0){
								JOptionPane.showMessageDialog(jframe, "Territ�rio de outro jogador");
							}
							else{
								String inputExercitosString = JOptionPane.showInputDialog(jframe, "Mover quantos ex�rcitos?");
							
								inputExercitos=0;
							
								try{
									inputExercitos = Integer.parseInt(inputExercitosString);
								}
								catch (NumberFormatException ne){
									JOptionPane.showMessageDialog(jframe, "Valor Inv�lido");
								}
								Territorio aux = null;
								for(Territorio t: lstTerritorios){
									if(t.getTerritorio() == (String)chooseTerritorio.getSelectedItem()){
										aux = t;
									}
								}
							
								if(inputExercitos<aux.getExercitos()){
									setExercitosToTerritorio(lstTerritorios, (String)chooseTerritorio.getSelectedItem(),(String)chooseNewTerritorio.getSelectedItem(), inputExercitos);
								}
								else{
									JOptionPane.showMessageDialog(jframe, "N�o possui ex�rcitos suficientes");
									jframe.dispose();
								}
							}
						}
					});

					jpanel.add(Mover);
				
				}
			}
		});
		jpanel.add(OK);

	}
	
	public void setExercitosToTerritorio (List<Territorio> lstTerritorios, String fromTerritorio, String toTerritorio, int exercitos){
		
		for(Territorio t: lstTerritorios){
			if(t.getTerritorio() == toTerritorio){
				t.setExercitos(exercitos);
			}
			if(t.getTerritorio() == fromTerritorio){
				t.looseExercitos(exercitos);
			}
		}
		lstTerritoriosSend = lstTerritorios;

	}
	
	public List<Territorio> getTerritorio (){
		return lstTerritoriosSend;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 1024, 768, null);

	}
}
