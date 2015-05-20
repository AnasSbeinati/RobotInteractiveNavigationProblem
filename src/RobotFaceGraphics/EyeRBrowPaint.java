/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>EyeRBrowPaint Class</p>
 */
package RobotFaceGraphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import RobotFace.FaceImpAPI;

public class EyeRBrowPaint implements FaceImpAPI {

	int right_ed=0;
	Graphics2D g2d;
    
	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}

	@Override
	public void changeComponentParameters(String type) {
	 if(type.compareTo("ri")==0){
		 right_ed=0;
	 }
	 if(type.compareTo("ru")==0){
		 right_ed=1;
	 }
	 if(type.compareTo("rd")==0){
		 right_ed=2;
	 }
		
	}

	@Override
	public void activateComponent() {
	    if (right_ed ==0) g2d.drawLine(130, 30, 200, 30);
	    if (right_ed ==1) g2d.drawLine(130, 30-20, 200, 30);        
	    if (right_ed ==2) g2d.drawLine(130, 30+20, 200, 30);
	}


}
