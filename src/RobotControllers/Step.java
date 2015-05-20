package RobotControllers;

/* Step class: each robot step is identified by this class
 * it stores the current position and the next position that the selected movement produced */

public abstract class Step {
	protected Position nextPos ; 
	protected Position prevPos ; 
	Step(Position pos){
		prevPos = pos;
	}
	
	public abstract Position move() ;
	public Position moveBack() { return prevPos; };

}
