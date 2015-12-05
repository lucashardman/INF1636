
package newGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.Territorio;

public class Player {
	
	/* Propriedades de Player */
	
	private Color color;
	private int number;
	private String name;
	private List<Territorio> Territorios = new ArrayList<Territorio>();
	private int exercitos;
	private int goalNumber;
	
	/* Funções set */
	
	public void setColor(Color c){
		color = c;
	}
	
	public void setNumber(int num){
		number = num;
	}
	public void setName(String n){
		name = n;
	}
	
	public void setExercitos (int exe){
		exercitos = exe;
	}
	
	public void setGoal (int n){
		goalNumber = n;
	}
	
	/* Funções add */
	
	public void addTerritorio (Territorio t){
		Territorios.add(t);
	}
	
	/* Funções get */
	
	public Color getColor(){
		return color;
	}
	
	public int getNumber(){
		return number;
	}
	public String getName(){
		return name;
	}
	
	public int getExercitos(){
		return exercitos;
	}
	
	public int getGoal(){
		return goalNumber;
	}
	
	public List<Territorio> getTerritorios(){
		return Territorios;
	}
}
