package game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import newGame.Player;
import controller.Territorio;

@SuppressWarnings("serial")
public class playerTerritorios extends drawMap{

	private JLabel alascaPlayer = new JLabel();
	private JLabel calgaryPlayer = new JLabel();
	private JLabel groelandiaPlayer = new JLabel();
	private JLabel vancouverPlayer = new JLabel();
	private JLabel quebecPlayer = new JLabel();
	private JLabel californiaPlayer = new JLabel();
	private JLabel texasPlayer = new JLabel();
	private JLabel newyorkPlayer = new JLabel();
	private JLabel mexicoPlayer = new JLabel();
	private JLabel venezuelaPlayer = new JLabel();
	private JLabel peruPlayer = new JLabel();
	private JLabel brasilPlayer = new JLabel();
	private JLabel argentinaPlayer = new JLabel();
	private JLabel africadosulPlayer = new JLabel();
	private JLabel angolaPlayer = new JLabel();
	private JLabel argeliaPlayer = new JLabel();
	private JLabel egitoPlayer = new JLabel();
	private JLabel nigeriaPlayer = new JLabel();
	private JLabel somaliaPlayer = new JLabel();
	private JLabel espanhaPlayer = new JLabel();
	private JLabel francaPlayer = new JLabel();
	private JLabel italiaPlayer = new JLabel();
	private JLabel poloniaPlayer = new JLabel();
	private JLabel reinounidoPlayer = new JLabel();
	private JLabel romeniaPlayer = new JLabel();
	private JLabel sueciaPlayer = new JLabel();
	private JLabel ucraniaPlayer = new JLabel();
	private JLabel arabiasauditaPlayer = new JLabel();
	private JLabel bangladeshPlayer = new JLabel();
	private JLabel cazaquistaoPlayer = new JLabel();
	private JLabel mongoliaPlayer = new JLabel();
	private JLabel chinaPlayer = new JLabel();
	private JLabel coreiadonortePlayer = new JLabel();
	private JLabel coreiadosulPlayer = new JLabel();
	private JLabel estoniaPlayer = new JLabel();
	private JLabel letoniaPlayer = new JLabel();
	private JLabel indiaPlayer = new JLabel();
	private JLabel iraPlayer = new JLabel();
	private JLabel iraquePlayer = new JLabel();
	private JLabel japaoPlayer = new JLabel();
	private JLabel jordaniaPlayer = new JLabel();
	private JLabel paquistaoPlayer = new JLabel();
	private JLabel russiaPlayer = new JLabel();
	private JLabel siberiaPlayer = new JLabel();
	private JLabel siriaPlayer = new JLabel();
	private JLabel tailandiaPlayer = new JLabel();
	private JLabel turquiaPlayer = new JLabel();
	private JLabel australiaPlayer = new JLabel();
	private JLabel indonesiaPlayer = new JLabel();
	private JLabel novazelandiaPlayer = new JLabel();
	private JLabel perthPlayer = new JLabel();

	
	public playerTerritorios(Player[] players){
		
		repaint();
		setLayout(null);

		alascaPlayer.setBounds(115, 142, 15, 15);
		alascaPlayer.setOpaque(true);
		alascaPlayer.setVisible(true);
		
		alascaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(alascaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Alasca"){
					alascaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		calgaryPlayer.setBounds(225, 142, 15, 15);
		calgaryPlayer.setOpaque(true);
		calgaryPlayer.setVisible(true);
		
		calgaryPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(calgaryPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Calgary"){
					calgaryPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		groelandiaPlayer.setBounds(375, 105, 15, 15);
		groelandiaPlayer.setOpaque(true);
		groelandiaPlayer.setVisible(true);
		
		groelandiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(groelandiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Groelandia"){
					groelandiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		vancouverPlayer.setBounds(210, 185, 15, 15);
		vancouverPlayer.setOpaque(true);
		vancouverPlayer.setVisible(true);
		
		vancouverPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(vancouverPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Vancouver"){
					vancouverPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		quebecPlayer.setBounds(305, 188, 15, 15);
		quebecPlayer.setOpaque(true);
		quebecPlayer.setVisible(true);
		
		quebecPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(quebecPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Quebec"){
					quebecPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		californiaPlayer.setBounds(145, 248, 15, 15);
		californiaPlayer.setOpaque(true);
		californiaPlayer.setVisible(true);
		
		californiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(californiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "California"){
					californiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		texasPlayer.setBounds(225, 222, 15, 15);
		texasPlayer.setOpaque(true);
		texasPlayer.setVisible(true);
		
		texasPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(texasPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Texas"){
					texasPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		newyorkPlayer.setBounds(278, 258, 15, 15);
		newyorkPlayer.setOpaque(true);
		newyorkPlayer.setVisible(true);
		
		newyorkPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(newyorkPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Nova York"){
					newyorkPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		mexicoPlayer.setBounds(180, 356, 15, 15);
		mexicoPlayer.setOpaque(true);
		mexicoPlayer.setVisible(true);
		
		mexicoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(mexicoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Mexico"){
					mexicoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		venezuelaPlayer.setBounds(225, 427, 15, 15);
		venezuelaPlayer.setOpaque(true);
		venezuelaPlayer.setVisible(true);
		
		venezuelaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(venezuelaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Venezuela"){
					venezuelaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		peruPlayer.setBounds(255, 483, 15, 15);
		peruPlayer.setOpaque(true);
		peruPlayer.setVisible(true);
		
		peruPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(peruPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Peru"){
					peruPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		brasilPlayer.setBounds(322, 448, 15, 15);
		brasilPlayer.setOpaque(true);
		brasilPlayer.setVisible(true);
		
		brasilPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(brasilPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Brasil"){
					brasilPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		argentinaPlayer.setBounds(332, 563, 15, 15);
		argentinaPlayer.setOpaque(true);
		argentinaPlayer.setVisible(true);
		
		argentinaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(argentinaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Argentina"){
					argentinaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		africadosulPlayer.setBounds(592, 573, 15, 15);
		africadosulPlayer.setOpaque(true);
		africadosulPlayer.setVisible(true);
		
		africadosulPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(africadosulPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Africa do Sul"){
					africadosulPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		angolaPlayer.setBounds(590, 500, 15, 15);
		angolaPlayer.setOpaque(true);
		angolaPlayer.setVisible(true);
		
		angolaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(angolaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Angola"){
					angolaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		argeliaPlayer.setBounds(500, 370, 15, 15);
		argeliaPlayer.setOpaque(true);
		argeliaPlayer.setVisible(true);
		
		argeliaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(argeliaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Argélia"){
					argeliaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		egitoPlayer.setBounds(590, 382, 15, 15);
		egitoPlayer.setOpaque(true);
		egitoPlayer.setVisible(true);
		
		egitoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(egitoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Egito"){
					egitoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		nigeriaPlayer.setBounds(535, 420, 15, 15);
		nigeriaPlayer.setOpaque(true);
		nigeriaPlayer.setVisible(true);
		
		nigeriaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(nigeriaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Nigéria"){
					nigeriaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		somaliaPlayer.setBounds(673, 473, 15, 15);
		somaliaPlayer.setOpaque(true);
		somaliaPlayer.setVisible(true);
		
		somaliaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(somaliaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Somália"){
					somaliaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		espanhaPlayer.setBounds(473, 278, 15, 15);
		espanhaPlayer.setOpaque(true);
		espanhaPlayer.setVisible(true);
		
		espanhaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(espanhaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Espanha"){
					espanhaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		

		francaPlayer.setBounds(520, 230, 15, 15);
		francaPlayer.setOpaque(true);
		francaPlayer.setVisible(true);
		
		francaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(francaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "França"){
					francaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		italiaPlayer.setBounds(560, 255, 15, 15);
		italiaPlayer.setOpaque(true);
		italiaPlayer.setVisible(true);
		
		italiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(italiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Itália"){
					italiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		poloniaPlayer.setBounds(610, 195, 15, 15);
		poloniaPlayer.setOpaque(true);
		poloniaPlayer.setVisible(true);
		
		poloniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(poloniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Polônia"){
					poloniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		reinounidoPlayer.setBounds(485, 170, 15, 15);
		reinounidoPlayer.setOpaque(true);
		reinounidoPlayer.setVisible(true);
		
		reinounidoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(reinounidoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Reino Unido"){
					reinounidoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		romeniaPlayer.setBounds(625, 271, 15, 15);
		romeniaPlayer.setOpaque(true);
		romeniaPlayer.setVisible(true);
		
		romeniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(romeniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Romênia"){
					romeniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		sueciaPlayer.setBounds(555, 145, 15, 15);
		sueciaPlayer.setOpaque(true);
		sueciaPlayer.setVisible(true);
		
		sueciaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(sueciaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Suécia"){
					sueciaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		

		ucraniaPlayer.setBounds(663, 245, 15, 15);
		ucraniaPlayer.setOpaque(true);
		ucraniaPlayer.setVisible(true);
		
		ucraniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(ucraniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Ucrânia"){
					ucraniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		arabiasauditaPlayer.setBounds(710, 410, 15, 15);
		arabiasauditaPlayer.setOpaque(true);
		arabiasauditaPlayer.setVisible(true);
		
		arabiasauditaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(arabiasauditaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Arábia Saudita"){
					arabiasauditaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		bangladeshPlayer.setBounds(910, 442, 15, 15);
		bangladeshPlayer.setOpaque(true);
		bangladeshPlayer.setVisible(true);
		
		bangladeshPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(bangladeshPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Bangladesh"){
					bangladeshPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
	
		cazaquistaoPlayer.setBounds(892, 212, 15, 15);
		cazaquistaoPlayer.setOpaque(true);
		cazaquistaoPlayer.setVisible(true);
		
		cazaquistaoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(cazaquistaoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Cazaquistão"){
					cazaquistaoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		mongoliaPlayer.setBounds(900, 250, 15, 15);
		mongoliaPlayer.setOpaque(true);
		mongoliaPlayer.setVisible(true);
		
		mongoliaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(mongoliaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Mongólia"){
					mongoliaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		chinaPlayer.setBounds(825, 285, 15, 15);
		chinaPlayer.setOpaque(true);
		chinaPlayer.setVisible(true);
		
		chinaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(chinaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "China"){
					chinaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		coreiadonortePlayer.setBounds(963, 305, 15, 15);
		coreiadonortePlayer.setOpaque(true);
		coreiadonortePlayer.setVisible(true);
		
		coreiadonortePlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(coreiadonortePlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Coréia do Norte"){
					coreiadonortePlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		coreiadosulPlayer.setBounds(930, 328, 15, 15);
		coreiadosulPlayer.setOpaque(true);
		coreiadosulPlayer.setVisible(true);
		
		coreiadosulPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(coreiadosulPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Coréia do Sul"){
					coreiadosulPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		estoniaPlayer.setBounds(703, 145, 15, 15);
		estoniaPlayer.setOpaque(true);
		estoniaPlayer.setVisible(true);
		
		estoniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(estoniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Estônia"){
					estoniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		letoniaPlayer.setBounds(703, 188, 15, 15);
		letoniaPlayer.setOpaque(true);
		letoniaPlayer.setVisible(true);
		
		letoniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(letoniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Letônia"){
					letoniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		indiaPlayer.setBounds(819, 380, 15, 15);
		indiaPlayer.setOpaque(true);
		indiaPlayer.setVisible(true);
		
		indiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(indiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Índia"){
					indiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		iraPlayer.setBounds(733, 333, 15, 15);
		iraPlayer.setOpaque(true);
		iraPlayer.setVisible(true);
		
		iraPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(iraPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Irã"){
					iraPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		iraquePlayer.setBounds(714, 360, 15, 15);
		iraquePlayer.setOpaque(true);
		iraquePlayer.setVisible(true);
		
		iraquePlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(iraquePlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Iraque"){
					iraquePlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		japaoPlayer.setBounds(1000, 265, 15, 15);
		japaoPlayer.setOpaque(true);
		japaoPlayer.setVisible(true);
		
		japaoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(japaoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Japão"){
					japaoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		jordaniaPlayer.setBounds(650, 335, 15, 15);
		jordaniaPlayer.setOpaque(true);
		jordaniaPlayer.setVisible(true);
		
		jordaniaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(jordaniaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Jordânia"){
					jordaniaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		paquistaoPlayer.setBounds(788, 312, 15, 15);
		paquistaoPlayer.setOpaque(true);
		paquistaoPlayer.setVisible(true);
		
		paquistaoPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(paquistaoPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Paquistão"){
					paquistaoPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		russiaPlayer.setBounds(820, 153, 15, 15);
		russiaPlayer.setOpaque(true);
		russiaPlayer.setVisible(true);
		
		russiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(russiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Russia"){
					russiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		siberiaPlayer.setBounds(936, 130, 15, 15);
		siberiaPlayer.setOpaque(true);
		siberiaPlayer.setVisible(true);
		
		siberiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(siberiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Sibéria"){
					siberiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		siriaPlayer.setBounds(694, 282, 15, 15);
		siriaPlayer.setOpaque(true);
		siriaPlayer.setVisible(true);
		
		siriaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(siriaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Siria"){
					siriaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		tailandiaPlayer.setBounds(963, 367, 15, 15);
		tailandiaPlayer.setOpaque(true);
		tailandiaPlayer.setVisible(true);
		
		tailandiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(tailandiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Tailândia"){
					tailandiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		turquiaPlayer.setBounds(770, 243, 15, 15);
		turquiaPlayer.setOpaque(true);
		turquiaPlayer.setVisible(true);
		
		turquiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(turquiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Turquia"){
					turquiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		australiaPlayer.setBounds(910, 617, 15, 15);
		australiaPlayer.setOpaque(true);
		australiaPlayer.setVisible(true);
		
		australiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(australiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Austrália"){
					australiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		

		indonesiaPlayer.setBounds(928, 497, 15, 15);
		indonesiaPlayer.setOpaque(true);
		indonesiaPlayer.setVisible(true);
		
		indonesiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(indonesiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Indonésia"){
					indonesiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		

		novazelandiaPlayer.setBounds(968, 663, 15, 15);
		novazelandiaPlayer.setOpaque(true);
		novazelandiaPlayer.setVisible(true);
		
		novazelandiaPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(novazelandiaPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Nova Zelândia"){
					novazelandiaPlayer.setBackground(players[i].getColor());
				}
			}
		}
		
		
		perthPlayer.setBounds(835, 583, 15, 15);
		perthPlayer.setOpaque(true);
		perthPlayer.setVisible(true);
		
		perthPlayer.setBorder(new LineBorder(Color.black, 2));
		this.add(perthPlayer);
		for(int i=0; i<players.length; i++){
		
			for(Territorio auxList: players[i].getTerritorios()){
				if(auxList.getTerritorio() == "Perth"){
					perthPlayer.setBackground(players[i].getColor());
				}
			}
		}
	}
	
	public void changeTerritorio(Territorio t, Player player){
		
		JLabel changePlayer = new JLabel();
		
		if(t.getTerritorio()=="Alasca"){
			changePlayer.setBounds(115, 142, 15, 15);
			alascaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Calgary"){
			changePlayer.setBounds(225, 142, 15, 15);
			calgaryPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Groelandia"){
			changePlayer.setBounds(375, 105, 15, 15);
			groelandiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Vancouver"){
			changePlayer.setBounds(210, 185, 15, 15);
			vancouverPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Quebec"){
			changePlayer.setBounds(305, 188, 15, 15);
			quebecPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="California"){
			changePlayer.setBounds(145, 248, 15, 15);
			californiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Texas"){
			changePlayer.setBounds(225, 222, 15, 15);
			texasPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Nova York"){
			changePlayer.setBounds(278, 258, 15, 15);
			newyorkPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Mexico"){
			changePlayer.setBounds(180, 356, 15, 15);
			mexicoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Venezuela"){
			changePlayer.setBounds(225, 427, 15, 15);
			venezuelaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Peru"){
			changePlayer.setBounds(255, 483, 15, 15);
			peruPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Brasil"){
			changePlayer.setBounds(322, 448, 15, 15);
			brasilPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Argentina"){
			changePlayer.setBounds(332, 563, 15, 15);
			argentinaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Africa do Sul"){
			changePlayer.setBounds(592, 573, 15, 15);
			africadosulPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Angola"){
			changePlayer.setBounds(590, 500, 15, 15);
			angolaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Argélia"){
			changePlayer.setBounds(500, 370, 15, 15);
			argeliaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Egito"){
			changePlayer.setBounds(590, 382, 15, 15);
			egitoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Nigéria"){
			changePlayer.setBounds(535, 420, 15, 15);
			nigeriaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Somália"){
			changePlayer.setBounds(673, 473, 15, 15);
			somaliaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Espanha"){
			changePlayer.setBounds(473, 278, 15, 15);
			espanhaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="França"){
			changePlayer.setBounds(520, 230, 15, 15);
			francaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Itália"){
			changePlayer.setBounds(560, 255, 15, 15);
			italiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Polônia"){
			changePlayer.setBounds(610, 195, 15, 15);
			poloniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Reino Unido"){
			changePlayer.setBounds(485, 170, 15, 15);
			reinounidoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Romênia"){
			changePlayer.setBounds(625, 271, 15, 15);
			romeniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Suécia"){
			changePlayer.setBounds(555, 145, 15, 15);
			sueciaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Ucrânia"){
			changePlayer.setBounds(663, 245, 15, 15);
			ucraniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Arábia Saudita"){
			changePlayer.setBounds(710, 410, 15, 15);
			arabiasauditaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Bangladesh"){
			changePlayer.setBounds(910, 442, 15, 15);
			bangladeshPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Cazaquistão"){
			changePlayer.setBounds(892, 212, 15, 15);
			cazaquistaoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Mongólia"){
			changePlayer.setBounds(900, 250, 15, 15);
			mongoliaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="China"){
			changePlayer.setBounds(825, 285, 15, 15);
			chinaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Coréia do Norte"){
			changePlayer.setBounds(963, 305, 15, 15);
			coreiadonortePlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Coréia do Sul"){
			changePlayer.setBounds(930, 328, 15, 15);
			coreiadosulPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Estônia"){
			changePlayer.setBounds(703, 145, 15, 15);
			estoniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Letônia"){
			changePlayer.setBounds(703, 188, 15, 15);
			letoniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Índia"){
			changePlayer.setBounds(819, 380, 15, 15);
			indiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Irã"){
			changePlayer.setBounds(733, 333, 15, 15);
			iraPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Iraque"){
			changePlayer.setBounds(714, 360, 15, 15);
			iraquePlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Japão"){
			changePlayer.setBounds(1000, 265, 15, 15);
			japaoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Jordânia"){
			changePlayer.setBounds(650, 335, 15, 15);
			jordaniaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Paquistão"){
			changePlayer.setBounds(788, 312, 15, 15);
			paquistaoPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Russia"){
			changePlayer.setBounds(820, 153, 15, 15);
			russiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Sibéria"){
			changePlayer.setBounds(936, 130, 15, 15);
			siberiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Siria"){
			changePlayer.setBounds(694, 282, 15, 15);
			siriaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Tailândia"){
			changePlayer.setBounds(963, 367, 15, 15);
			tailandiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Turquia"){
			changePlayer.setBounds(770, 243, 15, 15);
			turquiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Astrália"){
			changePlayer.setBounds(910, 617, 15, 15);
			australiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Indonésia"){
			changePlayer.setBounds(928, 497, 15, 15);
			indonesiaPlayer.setVisible(false);
		}
		if(t.getTerritorio()=="Nova Zelândia"){
			changePlayer.setBounds(968, 663, 15, 15);
			novazelandiaPlayer.setVisible(false);
		}	
		if(t.getTerritorio()=="Perth"){
			changePlayer.setBounds(835, 583, 15, 15);
			perthPlayer.setVisible(false);
		}

		changePlayer.setOpaque(true);
		changePlayer.setVisible(true);
		
		changePlayer.setBorder(new LineBorder(Color.black, 2));

		changePlayer.setBackground(player.getColor());

		this.add(changePlayer);
	}
}
