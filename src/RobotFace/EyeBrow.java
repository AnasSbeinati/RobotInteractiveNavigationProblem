/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>EyeBrow Class</p>
 */
package RobotFace;


public abstract class EyeBrow extends FaceComponent{

    public EyeBrow(FaceImpAPI fimp) {
	 super(fimp);
    } 
    

	abstract public void up();
    abstract public void down();
    abstract public void init();
    
}
