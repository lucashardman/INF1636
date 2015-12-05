package cards;

public class Goals {
	
	private String goal0 = "Conquistar a Europa, a �sia e um terceiro continente.";
	private String goal1 = "Conquistar a �sia e a Am�rica do Sul.";
	private String goal2 = "Conquistar a Europa, a Am�rica do Sul e um terceiro continente.";
	private String goal3 = "Conquistar 18 territ�rios e ocupar cada um deles com pelo menos 2 ex�rcitos.";
	private String goal4 = "Conquistar a �sia e a �frica.";
	private String goal5 = "Conquistar a Am�rica do Norte e a �frica.";
	private String goal6 = "Conquistar 24 territ�rios a sua escolha.";
	private String goal7 = "Conquistar a Am�rica do Norte e a Oceania";
	
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
