/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotContEyeLBrowPaint Class</p>
 */
package RobotFaceGraphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import RobotFace.FaceImpAPI;

public class EyeLBrowPaint extends JPanel implements FaceImpAPI {

	int left_ed=0; // 0:normal , 1:up , 2:down
	Graphics2D g2d;

    public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	@Override
	public void changeComponentParameters(String type) {
	 if(type.compareTo("li")==0){
		 left_ed=0;
	 }
	 if(type.compareTo("lu")==0){
		 left_ed=1;
	 }
	 if(type.compareTo("ld")==0){
		 left_ed=2;
	 }
			
	}

	@Override
	public void activateComponent() {
		if (left_ed ==0) g2d.drawLine(30, 30, 100, 30);
	    if (left_ed ==1) g2d.drawLine(30, 30, 100, 30-20);        
	    if (left_ed ==2) g2d.drawLine(30, 30, 100, 30+20);
	          
	}

}
