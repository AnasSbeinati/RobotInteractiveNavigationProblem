/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotFace Class</p>
 */
package RobotFace;

public class RobotFace {

	private static RobotFace _roboFace;
	private Eye _leftEye;
	private Eye _rightEye;
	private EyeBrow _leftEyebrow;
	private EyeBrow _rightEyebrow;
	private Lip _lip;
	
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>getInstance class</p>
	 */
	private RobotFace() {}
	
	public static RobotFace getInstance(){
		if ( _roboFace == null)
			_roboFace = new RobotFace();
		
		return _roboFace;
	}
	
	
	/* Getters & Setters */
	public Eye get_leftEye() {
		return _leftEye;
	}
	public void set_leftEye(Eye _leftEye) {
		this._leftEye = _leftEye;
	}
	public Eye get_rightEye() {
		return _rightEye;
	}
	public void set_rightEye(Eye _rightEye) {
		this._rightEye = _rightEye;
	}
	public EyeBrow get_leftEyebrow() {
		return _leftEyebrow;
	}
	public void set_leftEyebrow(EyeBrow _leftEyebrow) {
		this._leftEyebrow = _leftEyebrow;
	}
	public EyeBrow get_rightEyebrow() {
		return _rightEyebrow;
	}
	public void set_rightEyebrow(EyeBrow _rightEyebrow) {
		this._rightEyebrow = _rightEyebrow;
	}
	public Lip get_lip() {
		return _lip;
	}
	public void set_lip(Lip _lip) {
		this._lip = _lip;
	}
	
}
