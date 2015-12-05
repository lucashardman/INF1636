package newGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class setPlayers {
	
	public Player[] numberOfPlayers (int number){
		
		Player players[] = new Player[number];
		Object numberArray[] = new Object[number];
		Object colorArray[] = new Object[number];
		
		for (int k=0; k<players.length; k++) {
			players[k]=new Player();
		}
		
		numberArray = randomNumber(number).toArray();
		colorArray = randomColor(number).toArray();
		
		for(int i = 0; i<number;i++){
			
			players[i].setNumber((int)numberArray[i]);
			players[i].setColor((Color)colorArray[i]);
			
			if(players[i].getColor() == Color.black) players[i].setName("Exército Preto");
			if(players[i].getColor() == Color.blue) players[i].setName("Exército Azul");
			if(players[i].getColor() == Color.cyan) players[i].setName("Exército Ciano");
			if(players[i].getColor() == Color.gray) players[i].setName("Exército Cinza");
			if(players[i].getColor() == Color.green) players[i].setName("Exército Verde");
			if(players[i].getColor() == Color.magenta) players[i].setName("Exército Magenta");
			if(players[i].getColor() == Color.orange) players[i].setName("Exército Laranja");
			if(players[i].getColor() == Color.pink) players[i].setName("Exército Rosa");
			if(players[i].getColor() == Color.red) players[i].setName("Exército Vermelho");
			if(players[i].getColor() == Color.white) players[i].setName("Exército Branco");
			if(players[i].getColor() == Color.yellow) players[i].setName("Exército Amarelo");

		}
		return players;
	}
	
	private ArrayList<Color> randomColor(int number){
		Random random = new Random();
		
		Color c[] = new Color[]{Color.black, Color.blue, Color.cyan, Color.gray,
								Color.green, Color.magenta, Color.orange, Color.pink,
								Color.red, Color.white, Color.yellow};
		
		ArrayList<Integer> listOfIndex = new ArrayList<Integer>(number);
		Object indexArray[] = new Object [number];
		ArrayList<Color> listOfColors = new ArrayList<Color>(number);
		
		while (listOfIndex.size() < number){
			int col = random.nextInt(10);
			if(!listOfIndex.contains(col)){
				listOfIndex.add(col);
				
			}
		}
	
		indexArray = listOfIndex.toArray();
		
		for(int i=0; i<number; i++){
			listOfColors.add(c[(int)indexArray[i]]);
		}
		
		return listOfColors;
	}

	private ArrayList<Integer> randomNumber(int number){
		
		ArrayList<Integer> listOfRandons = new ArrayList<Integer>(number);
		
		Random random = new Random();
		
		while (listOfRandons.size() < number){
			int num = random.nextInt(number);
			if(!listOfRandons.contains(num)){
				listOfRandons.add(num);
				
			}
		}
		
		return listOfRandons;
	}
	
}
