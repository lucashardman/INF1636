package Observer;

import java.awt.Color;
import java.util.List;

import controller.Territorio;

public interface Observer {

	public void update(Color color, int number, String name, List<Territorio> Territorios, int exercitos, int goalNumber);
}
