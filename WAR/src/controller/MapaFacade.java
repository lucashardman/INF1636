package controller;

import game.playerTerritorios;

import java.util.ArrayList;
import java.util.List;

import newGame.Player;

@SuppressWarnings("serial")
public class MapaFacade extends playerTerritorios{

	public MapaFacade(Player[] players) {
		super(players);
		// TODO Auto-generated constructor stub
	}
	


	public List<Territorio> getTerritorios(){
		return lstTerritorios;
	}
	
	public void updateMapa(List<Territorio> t){
		lstTerritorios = t;
	}
	
	public List<Territorio> getAlascaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Calgary"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Sib�ria"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getCalgaryBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Groelandia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Alasca"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getGroelandiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Quebec"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Calgary"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Reino Unido"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getVancouverBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Alasca"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Calgary"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Quebec"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
			if(l.getTerritorio()=="California"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getQuebecBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Groelandia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova York"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	public List<Territorio> getCaliforniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mexico"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	public List<Territorio> getTexasBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Mexico"){
				lst.add(l);
			}
			if(l.getTerritorio()=="California"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Quebec"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova York"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getNovaYorkBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Quebec"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getMexicoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="California"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Venezuela"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getVenezuelaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Mexico"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Peru"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Brasil"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getPeruBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Brasil"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Argentina"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Venezuela"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getBrasilBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Argentina"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Peru"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Venezuela"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getArgentinaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Peru"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Brasil"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getAfricaDoSulBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Angola"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getAngolaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Africa do Sul"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getArgeliaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
			if(l.getTerritorio()=="It�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Espanha"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getEgitoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Arg�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jord�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Rom�nia"){
				lst.add(l);
			}
		}
		
		return lst;
	}
	
	public List<Territorio> getNigeriaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
		
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Brasil"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Arg�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Angola"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
		}
		
		return lst;
	}

	public List<Territorio> getSomaliaBorder(){
	
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Angola"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Africa do Sul"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ar�bia Saudita"){
				lst.add(l);
			}
		}
	
		return lst;
	}

	public List<Territorio> getEspanhaBorder(){
	
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Fran�a"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Arg�lia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getFrancaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Espanha"){
				lst.add(l);
			}
			if(l.getTerritorio()=="It�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Reino Unido"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Su�cia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getItaliaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Fran�a"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Arg�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Su�cia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Pol�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Rom�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getPoloniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="It�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ucr�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Rom�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getReinoUnidoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Groelandia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Fran�a"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getRomeniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="It�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ucr�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Pol�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getSueciaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Fran�a"){
				lst.add(l);
			}
			if(l.getTerritorio()=="It�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Est�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getUcraniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Pol�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Rom�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getArabiaSauditaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jord�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Iraque"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getBangladeshBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Tail�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Indon�sia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getCazaquistaoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Sib�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Russia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mong�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jap�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getMongoliaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jap�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getChinaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Norte"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mong�lia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getCoreiaDoNorteBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jap�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getCoreiaDoSulBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cor�ia do Norte"){
				lst.add(l);
			}
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Bangladesh"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Tail�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getEstoniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Su�cia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Russia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getLetoniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Su�cia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Est�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Russia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cazaquistao"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Pol�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ucr�nia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getIndiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Bangladesh"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Indon�sia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getIraBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Siria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Iraque"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getIraqueBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Siria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ir�"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jord�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ar�bia Saudita"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getJapaoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cor�ia do Norte"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mong�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getJordaniaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Siria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Iraque"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ar�bia Saudita"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getPaquistaoBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Siria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ir�"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getRussiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Est�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Sib�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getSiberiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Russia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Alasca"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getSiriaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Jord�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Iraque"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ir�"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getTailandiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Bangladesh"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getTurquiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Siria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getAustraliaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Perth"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Indon�sia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova Zel�ndia"){
				lst.add(l);
			}

		}
	
		return lst;
	}
	
	public List<Territorio> getIndonesiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Bangladesh"){
				lst.add(l);
			}
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Austr�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova Zel�ndia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getNovaZelandiaBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Austr�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Indon�sia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getPerthBorder(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Austr�lia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getAmericaDoNorte(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Alasca"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Calgary"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Groelandia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Vancouver"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Quebec"){
				lst.add(l);
			}
			if(l.getTerritorio()=="California"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Texas"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova York"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mexico"){
				lst.add(l);
			}
		}
	
		return lst;
	}

	public List<Territorio> getAmericaDoSul() {

		List<Territorio> lst = new ArrayList<Territorio>();

		for (Territorio l : lstTerritorios) {
			if (l.getTerritorio() == "Venezuela") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Pery") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Brasil") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Argentina") {
				lst.add(l);
			}
		}

		return lst;
	}

	public List<Territorio> getEuropa() {

		List<Territorio> lst = new ArrayList<Territorio>();

		for (Territorio l : lstTerritorios) {
			if (l.getTerritorio() == "Reino Unido") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Su�cia") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Espanha") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Fran�a") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Pol�nia") {
				lst.add(l);
			}
			if (l.getTerritorio() == "It�lia") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Rom�nia") {
				lst.add(l);
			}
			if (l.getTerritorio() == "Ucr�nia") {
				lst.add(l);
			}
		}

		return lst;
	}
	
	public List<Territorio> getAfrica(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Arg�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Egito"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nig�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Som�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Angola"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Africa do Sul"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
	public List<Territorio> getOceania(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Indon�sia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Perth"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Austr�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Nova Zel�ndia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
	
public List<Territorio> getAsia(){
		
		List<Territorio> lst = new ArrayList<Territorio>();
	
		for(Territorio l: lstTerritorios){
			if(l.getTerritorio()=="Est�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Russia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Sib�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Let�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cazaquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Turquia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="China"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Mong�lia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jap�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="S�ria"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Paquist�o"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Jord�nia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ar�bia Saudita"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Iraque"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Ir�"){
				lst.add(l);
			}
			if(l.getTerritorio()=="�ndia"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Norte"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Cor�ia do Sul"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Bangladesh"){
				lst.add(l);
			}
			if(l.getTerritorio()=="Tail�ndia"){
				lst.add(l);
			}
		}
	
		return lst;
	}
}
