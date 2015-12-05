package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import newGame.Player;
import controller.MapaFacade;
import controller.Territorio;

public class sortTerritorios{

	private List<Territorio> lstTerritorios = new ArrayList<Territorio>();
	private Player[] newPlayers;
	
	public sortTerritorios(MapaFacade map, Player[] players){
		
		lstTerritorios = map.getTerritorios();
		Territorio[] ArrayTerritorios = new Territorio[lstTerritorios.size()];
				
		ArrayTerritorios = lstTerritorios.toArray(ArrayTerritorios);
		
		shuffleArray(ArrayTerritorios);
		
		int j=0;
		for(int i=0;i<ArrayTerritorios.length;i++){
			
			players[j].addTerritorio(ArrayTerritorios[i]);
			
			j++;
			if(j==players.length){
				j=0;
			}
		}
		newPlayers = players;
	}
	
	public Player[] getNewPlayers(){
		return newPlayers;
	}
	
	private void shuffleArray(Territorio[] ar){
	  
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--){
	    
	      int index = rnd.nextInt(i + 1);
	      
	      Territorio a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}
