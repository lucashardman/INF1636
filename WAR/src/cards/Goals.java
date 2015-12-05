package cards;

public class Goals {
	
	private String goal0 = "Conquistar a Europa, a Ásia e um terceiro continente.";
	private String goal1 = "Conquistar a Ásia e a América do Sul.";
	private String goal2 = "Conquistar a Europa, a América do Sul e um terceiro continente.";
	private String goal3 = "Conquistar 18 territórios e ocupar cada um deles com pelo menos 2 exércitos.";
	private String goal4 = "Conquistar a Ásia e a África.";
	private String goal5 = "Conquistar a América do Norte e a África.";
	private String goal6 = "Conquistar 24 territórios a sua escolha.";
	private String goal7 = "Conquistar a América do Norte e a Oceania";
	
	public String getGoal(int goalNumber){
		
		String goal = null;
		
		if(goalNumber == 0)
			goal = goal0;
		if(goalNumber == 1)
			goal = goal1;
		if(goalNumber == 2)
			goal = goal2;
		if(goalNumber == 3)
			goal = goal3;
		if(goalNumber == 4)
			goal = goal4;
		if(goalNumber == 5)
			goal = goal5;
		if(goalNumber == 6)
			goal = goal6;
		if(goalNumber == 7)
			goal = goal7;
		
		return goal;
	}
	
	public String getGoal0(){
		return goal0;
	}
	public String getGoal1(){
		return goal1;
	}	
	public String getGoal2(){
		return goal2;
	}
	public String getGoal3(){
		return goal3;
	}
	public String getGoal4(){
		return goal4;
	}
	public String getGoal5(){
		return goal5;
	}
	public String getGoal6(){
		return goal6;
	}
	public String getGoal7(){
		return goal7;
	}
	
}
