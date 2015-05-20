/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>FacePaint Class</p>
 */
package RobotFaceGraphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import RobotFace.RobotFace;

public class  FacePaint extends JPanel{

	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>paintComponent class</p>
	 */
	 @Override
	 public void paintComponent(Graphics g) {
	    Graphics2D g2d= (Graphics2D) g; 
		super.paintComponent(g);
		RobotFace.getInstance().get_leftEyebrow().get_fimp().setG2d(g2d);
		RobotFace.getInstance().get_rightEyebrow().get_fimp().setG2d(g2d);
		RobotFace.getInstance().get_rightEye().get_fimp().setG2d(g2d);
		RobotFace.getInstance().get_leftEye().get_fimp().setG2d(g2d);
        RobotFace.getInstance().get_lip().get_fimp().setG2d(g2d);
        
		RobotFace.getInstance().get_leftEyebrow().get_fimp().activateComponent();
		RobotFace.getInstance().get_rightEyebrow().get_fimp().activateComponent();
		RobotFace.getInstance().get_rightEye().get_fimp().activateComponent();
		RobotFace.getInstance().get_leftEye().get_fimp().activateComponent();
		RobotFace.getInstance().get_lip().get_fimp().activateComponent();
        
	 
	 }
}
