/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>Lip Class</p>
 */
package RobotFace;

public  class Lip extends FaceComponent{


	public Lip(FaceImpAPI fimp) {
       super(fimp);
    } 
    //according to lipPaint.java I do not understand n,m,and s, so I suppose
	//that n for init m for smile s for sad
	public void makesSmile(){
		  //Fill Here 
		_fimp.changeComponentParameters("m");
	}
	public void makeSad(){
		  //Fill Here    
		_fimp.changeComponentParameters("s");
	}
	
	public void init(){
		  //Fill Here  
		_fimp.changeComponentParameters("n");
	}
}
