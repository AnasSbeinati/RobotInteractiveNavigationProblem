package RobotFacialExpressions;

import RobotFace.Eye;
import RobotFace.LeftEyeBrow;
import RobotFace.Lip;
import RobotFace.RightEyeBrow;
import RobotFace.RobotFace;
import RobotFaceGraphics.EyeLBrowPaint;
import RobotFaceGraphics.EyeRBrowPaint;
import RobotFaceGraphics.EyesPaint;
import RobotFaceGraphics.LipPaint;

public class FacialExpressionsBuilder {

  private RobotFace _roboFace;


public void initFace(){
	_roboFace = RobotFace.getInstance(); 
	
	//Build Eyebrow with specifying the implementor of eyeBrowMovements 
	_roboFace.set_leftEyebrow(new LeftEyeBrow(new EyeLBrowPaint()));
	_roboFace.set_rightEyebrow(new RightEyeBrow(new EyeRBrowPaint()));
    
	//Build Eyes with specifying the implementor of eyesMovements
	EyesPaint ep=new EyesPaint();
	_roboFace.set_leftEye(new Eye(ep));
	_roboFace.set_rightEye(new Eye(ep));

   //Build Lip
	_roboFace.set_lip(new Lip(new LipPaint()));

}
  
  public RobotFace getHappyFace(){
	  _roboFace.get_leftEyebrow().up();
	  _roboFace.get_rightEyebrow().up();
	  _roboFace.get_leftEye().init();
	  _roboFace.get_rightEye().init();	    
	  _roboFace.get_lip().makesSmile();
	  return _roboFace;
  }

  public RobotFace getSadFace(){
	  _roboFace.get_leftEyebrow().down();
	  _roboFace.get_rightEyebrow().down();
	  _roboFace.get_leftEye().init();
	  _roboFace.get_rightEye().init();	
	  _roboFace.get_lip().makeSad();
	  return _roboFace;
  }
  
  public RobotFace getWonderingFace(){
	  _roboFace.get_leftEyebrow().up();
	  _roboFace.get_rightEyebrow().down();
	  _roboFace.get_leftEye().right();
	  _roboFace.get_rightEye().right();
	  _roboFace.get_lip().init();
	  return _roboFace;
  }
	
}
