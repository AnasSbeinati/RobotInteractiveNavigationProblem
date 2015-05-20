package RobotControllers;

/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RightStep class</p>
 */
public class RightStep extends Step{

	public RightStep(Position pos) {
		super(pos);

	}

	@Override
	public Position move() {
		nextPos= new Position (prevPos.getX()+1, prevPos.getY(),'r');
		return nextPos;
		
	}

}
