/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotFaceFrame Class</p>
 */
package RobotFaceGraphics;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import RobotFace.RobotFace;
import RobotFacialExpressions.FacialExpressionsBuilder;

public class RobotFaceFrame extends JFrame {
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>navigateInteractively class</p>
	 */
    public RobotFaceFrame() {
    	initUI();
    }
    /**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>initUI class</p>
	 */
    private void initUI() {

    	final FacePaint face_g=new FacePaint(); 
        
        add(face_g);
        
        setTitle("Robot Face");
        setSize(250, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>RenderFace class</p>
	 */
    static RobotFaceFrame ex = new RobotFaceFrame();
    public static void RenderFace() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                 	
                ex.setVisible(true);
            }
        });
    }

        
    public static void KillFace() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                ex.setVisible(false);
            }
        });
    }
}

