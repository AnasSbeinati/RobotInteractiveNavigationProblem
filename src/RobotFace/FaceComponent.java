/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>FaceComponent Class</p>
 */
package RobotFace;

public class FaceComponent {
	protected  FaceImpAPI _fimp;
    public FaceComponent(FaceImpAPI fimp) {
	 _fimp =fimp;
    } 
    /**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>paintComponent class</p>
	 */
	public FaceImpAPI get_fimp() {
		return _fimp;
	}

}
