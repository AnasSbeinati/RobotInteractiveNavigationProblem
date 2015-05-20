/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotNavigationPanel Class</p>
 */
package Main;
import RobotControllers.Position;
import RobotControllers.RobotController;
import RobotControllers.RoomMap;
import RobotPlanner.FRLPlanner;


public class RobotNavigationPanel {

	public static void main(String[] args) {
		/* Test Case 1
		RoomMap room1 = new RoomMap(4,4);
		room1.generateRoomMapFromFile("map1");
		room1.showMap();
		FRLPlanner roboplanner=new FRLPlanner(room1);
		RobotController controller= new RobotController(room1,roboplanner);
		System.out.println("\n"+controller.navigate(new Position(0, 0,' '), new Position(3, 3,' ')));
		room1.showMap();
		System.out.println("\n"+controller.navigateBack(new Position(0, 0,' '), new Position(3, 3,' ')));
		room1.showMap();
		*/
		
		RobotController controller= new RobotController();
		controller.navigateInteractively();
	}

}
