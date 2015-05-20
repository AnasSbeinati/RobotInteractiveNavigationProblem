/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotControllers class</p>
 */
package RobotControllers;


public class LeftStep extends Step{

	public LeftStep(Position pos) {
		super(pos);
	}

	@Override
	public Position move() {
		nextPos= new Position (prevPos.getX()-1, prevPos.getY(), 'l');
		return nextPos;
	}

}
