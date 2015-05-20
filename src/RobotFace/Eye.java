package RobotFace;
/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>Eye Class</p>
 */
public class Eye extends FaceComponent{


	 public Eye(FaceImpAPI fimp) {
	    super(fimp);
    } 
    

	public void right(){
		  //Fill Here  
		_fimp.changeComponentParameters("r");
	}
	
	public void left(){
		  //Fill Here 
		_fimp.changeComponentParameters("l");
	}
	
	public void init(){
		  //Fill Here    
		_fimp.changeComponentParameters("n");
	}


}
