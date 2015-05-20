/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>LeftEyeBrow Class</p>
 */
package RobotFace;


public class LeftEyeBrow extends EyeBrow {

	public LeftEyeBrow(FaceImpAPI fimp) {
		super(fimp);
	}

	@Override
	public void up() {
		  //Fill Here  
		_fimp.changeComponentParameters("lu");
 	}

	@Override
	public void down() {
		  //Fill Here 
		_fimp.changeComponentParameters("ld");
	}

	@Override
	public void init() {
		  //Fill Here  
		_fimp.changeComponentParameters("li");
	}

}
