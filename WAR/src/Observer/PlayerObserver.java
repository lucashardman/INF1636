package Observer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.Territorio;

public abstract class PlayerObserver implements Observer{

	private Color color;
	private int number;
	private String name;
	private List<Territorio> Territorios = new ArrayList<Territorio>();
	private int exercitos;
	private int goalNumber;
	
	private static int observerIDTracker = 0;
	
	private int observerID;
	
	private Subject playerGrabber;
	
	public PlayerObserver(Subject playerGrabber){
		
		this.playerGrabber = playerGrabber;
		
		this.observerID = ++observerIDTracker;
		
		System.out.println("New observer "+this.observerID);
	
		playerGrabber.register(this);
	}
	
	public void update(Color color, int number, String name, List<Territorio> Territorios, int exercitos, int goalNumber){
		this.color = color;
		this.number = number;
		this.name = name;
		this.Territorios = Territorios;
		this.exercitos = exercitos;
		this.goalNumber = goalNumber;
	
		printPlayer();
	}
	
	public void printPlayer(){
		System.out.println(observerID+"\nColor: "+color+"\nNumber: "+number+"\nName: "+name
				+"\nTerritorios: "+Territorios+"\nExercitos: "+exercitos+"\nGoal: "+goalNumber);
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
