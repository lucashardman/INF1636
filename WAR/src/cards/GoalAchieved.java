package cards;

import java.util.ArrayList;
import java.util.List;

import controller.MapaFacade;
import controller.Territorio;
import newGame.Player;

public class GoalAchieved {

	private List<Territorio> playerTerritorios;
	private Player winner = null;
	
	public GoalAchieved(Player turnPlayer, MapaFacade map){
		
		playerTerritorios = new ArrayList<Territorio>();
		
		playerTerritorios = turnPlayer.getTerritorios();
		
		if(turnPlayer.getGoal() == 0){
			
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAmericaDoSul())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAfrica())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getOceania())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 0){
			
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAmericaDoSul())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAfrica())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getOceania())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 1){
			
			if(playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAmericaDoSul())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 2){
			
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAmericaDoSul()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAmericaDoSul()) && playerTerritorios.containsAll(map.getAsia())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAmericaDoSul()) && playerTerritorios.containsAll(map.getAfrica())){
				winner = turnPlayer;
			}
			if(playerTerritorios.containsAll(map.getEuropa()) && playerTerritorios.containsAll(map.getAmericaDoSul()) && playerTerritorios.containsAll(map.getOceania())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 3){
			int auxGoal3 = 0;
			if(playerTerritorios.size() == 18){
				for(Territorio t: playerTerritorios){
					if(t.getExercitos() < 2){
						auxGoal3++;
					}
				}
				if(auxGoal3 == 0)
					winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 4){
			
			if(playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAfrica())){
				winner = turnPlayer;
			}
		}
		if(turnPlayer.getGoal() == 5){
			
			if(playerTerritorios.containsAll(map.getAfrica()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 6){
			
			if(playerTerritorios.size() >= 24){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 7){
			
			if(playerTerritorios.containsAll(map.getOceania()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
		}
		
		if(turnPlayer.getGoal() == 8){
			
			if(playerTerritorios.containsAll(map.getAsia()) && playerTerritorios.containsAll(map.getAfrica()) && playerTerritorios.containsAll(map.getAmericaDoNorte())){
				winner = turnPlayer;
			}
		}
	}
	
	public Player getWinner(){
		return winner;
	}
}
