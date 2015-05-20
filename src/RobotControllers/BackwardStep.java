/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>BackwardStep class</p>
 */
package RobotControllers;


public class BackwardStep extends Step{

	BackwardStep(Position pos) {
		super(pos);
	}

	@Override
	public Position move() {
		nextPos= new Position (prevPos.getX(), prevPos.getY()-1,'b');
		return nextPos;
	}

}
