package Observer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controller.Territorio;

public abstract class PlayerGrabber implements Subject{

	private ArrayList<Observer> observers;
	private Color color;
	private int number;
	private String name;
	private List<Territorio> Territorios = new ArrayList<Territorio>();
	private int exercitos;
	private int goalNumber;
	
	public PlayerGrabber(){
		
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer newObserver) {

		observers.add(newObserver);
			         
	}
	
	public void unregister (Observer deleteObserver){
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		System.out.println("Observer "+(observerIndex+1)+" deleted.");
		
		observers.remove(observerIndex);
	}
		
	public void notifyObserver(){
		
		for(Observer o: observers){
			o.update(color, number, name, Territorios, exercitos, goalNumber);
		}
	}
	
/* Funções set */
	
	public void setColor(Color c){
		color = c;
		notifyObserver();
	}
	
	public void setNumber(int num){
		number = num;
		notifyObserver();
	}
	public void setName(String n){
		name = n;
		notifyObserver();
	}
	
	public void setExercitos (int exe){
		exercitos = exe;
		notifyObserver();
	}
	
	public void setGoal (int n){
		goalNumber = n;
		notifyObserver();
	}
	
	/* Funções add */
	
	public void addTerritorio (Territorio t){
		Territorios.add(t);
		notifyObserver();
	}
	
}
