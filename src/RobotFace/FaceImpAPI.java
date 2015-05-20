/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>FaceImpAPI Class</p>
 */
package RobotFace;

import java.awt.Graphics2D;


public interface FaceImpAPI {
	public void activateComponent();
	public void changeComponentParameters(String type);
	public void setG2d(Graphics2D g2d);

}
