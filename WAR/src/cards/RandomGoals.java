package cards;

import java.util.ArrayList;
import java.util.Random;

import newGame.Player;

public class RandomGoals extends Goals{
	
	private Player[] newPlayers;
	
	public RandomGoals(Player[] players){
		
		ArrayList<Integer> listOfGoals = new ArrayList<Integer>(19);
		
		Integer[] arrayOfGoals = new Integer[19];
		
		Random random = new Random();

		/********************************************************/
		while (listOfGoals.size() < 7){

			int num = random.nextInt(7);
			if(!listOfGoals.contains(num)){
				listOfGoals.add(num);
			}
		}
		/********************************************************/
		arrayOfGoals = listOfGoals.toArray(arrayOfGoals);
		
		for(int i=0; i<players.length; i++){
			players[i].setGoal(arrayOfGoals[i]);
			
		}
		
		
		newPlayers =  players;
	}
	
	public Player[] getGoals(){
		return newPlayers;
	}
}
