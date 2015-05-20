/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>ForwardStep class</p>
 */
package RobotControllers;


public class ForwardStep extends Step{

	public ForwardStep(Position pos) {
		super(pos);
	}

	@Override
	public Position move() {
		nextPos= new Position (prevPos.getX(), prevPos.getY()+1,'f');
		return nextPos;
	}

}
