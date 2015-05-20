package RobotFace;

/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RightEyeBrow Class</p>
 */
public class RightEyeBrow extends EyeBrow {

	public RightEyeBrow(FaceImpAPI fimp) {
		super(fimp);
	}

	@Override
	public void up() {
		// Fill Here
		_fimp.changeComponentParameters("ru");
	}

	@Override
	public void down() {
		// Fill Here
		_fimp.changeComponentParameters("rd");
	}

	@Override
	public void init() {
		// Fill Here
		_fimp.changeComponentParameters("ri");
	}
}
