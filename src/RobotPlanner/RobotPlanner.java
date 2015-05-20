package RobotPlanner;
import RobotControllers.Position;
import RobotControllers.Step;


public interface  RobotPlanner {

	
	public Position getNextPosition(Position pos);
	public Step getStep();
}
