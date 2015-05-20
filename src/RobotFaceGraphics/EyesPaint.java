package RobotFaceGraphics;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import RobotFace.FaceImpAPI;

public class EyesPaint extends JPanel implements FaceImpAPI  {


	Graphics2D g2d;
    int pos=0;
	@Override
	public void changeComponentParameters(String type) {
		 if(type.compareTo("n")==0){
			 pos=0;
		 }
		 if(type.compareTo("r")==0){
			 pos=1;
		 }
		 if(type.compareTo("l")==0){
			 pos=2;
		 }	
	}

	@Override
	public void activateComponent() {
		// TODO Auto-generated method stub
		int x=65,y=100,r=40, x1=65,y1=100, r1=80;
		x = x -(r/2);
		y = y -(r/2);
		x1 = x1 -(r1/2);
		y1 = y1 -(r1/2);
		int delta =100;
		//g2d.drawOval(x, y, r, r);
		if(pos == 0){
			g2d.fillOval(x, y, r, r);
			g2d.drawOval(x1, y1, r1, r1);
	
			g2d.fillOval(x+delta, y, r, r);
			g2d.drawOval(x1+delta, y1, r1, r1);
		
		}
		if(pos == 1){ 
			g2d.fillOval(x+10, y, r, r);
			g2d.drawOval(x1, y1, r1, r1);
			
			g2d.fillOval(x+10+delta, y, r, r);
			g2d.drawOval(x1+delta, y1, r1, r1);
		
		}
		if(pos == 2){ 
			g2d.fillOval(x-10 , y, r, r);
			g2d.drawOval(x1, y1, r1, r1);
			
			g2d.fillOval(x-10 +delta , y, r, r);
			g2d.drawOval(x1+delta, y1, r1, r1);
		}
	}

	@Override
	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	

}
