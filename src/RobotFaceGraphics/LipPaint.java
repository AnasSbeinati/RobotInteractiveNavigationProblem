
/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>LipPaint Class</p>
 */
package RobotFaceGraphics;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import RobotFace.FaceImpAPI;

public class LipPaint extends JPanel implements FaceImpAPI  {


	Graphics2D g2d;
    int pos=0;
	@Override
	public void changeComponentParameters(String type) {
		 if(type.compareTo("n")==0){
			 pos=0;
		 }
		 if(type.compareTo("m")==0){
			 pos=1;
		 }
		 if(type.compareTo("s")==0){
			 pos=2;
		 }	
	}

	@Override
	public void activateComponent() {
		// TODO Auto-generated method stub
		int x=65,y=100,r=90;


		if(pos == 0){
			g2d.drawArc(x, y, r, r, -120, 50);
			
		}
		if(pos == 1){ 
			g2d.drawArc(x, y, r, r, -140, 110);
		
		}
		if(pos == 2){ 
			g2d.drawArc(x, y+50, r, r, 40, 110);
	
		}
	}

	@Override
	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	

}
