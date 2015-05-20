package RobotControllers;
/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RobotController Class</p>
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import RobotFaceGraphics.RobotFaceFrame;
import RobotFacialExpressions.FacialExpressionsBuilder;
import RobotPlanner.RobotPlanner;
import RobotSound.Sound;
import RobotSound.SoundProducer;
import SensorsUtilities.InfraredSensor;
import SensorsUtilities.SensorsObserver;
import SensorsUtilities.UltraSensor;

public class RobotController extends SensorsObserver {
	private RoomMap _roommap;
	private ArrayList<Step> steps = new ArrayList<Step>();
	private RobotPlanner roboplanner;

	public RobotController() {
		sensors[0] = new InfraredSensor();
		sensors[0].attach(this);

		sensors[1] = new UltraSensor();
		sensors[1].attach(this);

	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public RobotController(RoomMap room, RobotPlanner planner) {
		sensors[0] = new InfraredSensor();
		sensors[0].attach(this);

		sensors[1] = new UltraSensor();
		sensors[1].attach(this);

		_roommap = room;
		roboplanner = planner;
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public void runSensors(Position pos) {
		sensors[0].readSignal(_roommap.getValueAtPosition(pos));
		sensors[1].readSignal(_roommap.getValueAtPosition(pos));
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public void updateCollision() {
		if (sensors[0].isCollision || sensors[1].isCollision) {
			this.isCollision = true;
		} else {
			this.isCollision = false;
		}
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public boolean navigate(Position A, Position B) {
		_roommap.updateMap(A);
		Position curr_pos = getNextPosition(A);
		if (curr_pos == null)
			return false;
		while (!curr_pos.isEqual(B)) {
			curr_pos = getNextPosition(curr_pos);
			if (curr_pos == null)
				return false;
		}
		return true;
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public boolean navigateBack(Position A, Position B) {
		_roommap.zeroMap();
		if (steps.size() == 0)
			return false;
		int i = steps.size() - 1;
		Position curr_pos = B;
		_roommap.updateMap(curr_pos);
		while (!curr_pos.isEqual(A)) {
			curr_pos = steps.get(i).moveBack();
			i--;
			if (curr_pos == null)
				return false;
			_roommap.updateMap(curr_pos);
		}
		return true;
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	public Position getNextPosition(Position curr) {

		Position pos = roboplanner.getNextPosition(curr);
		steps.add(roboplanner.getStep());
		return pos;
	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>getNextPositionInter class</p>
	 */
	public Position getNextPositionInter(Position curr) {
		_roommap.showMap();

		Position nextPosition = null;
		Step tempStep = null;

		if (curr.getY() + 1 < _roommap.getColumns()) {
			tempStep = new ForwardStep(curr);
			Position tempPos = tempStep.move();
			if (_roommap.getValueAtPosition(tempPos) >= 3)
				return null;
			runSensors(tempPos);
			nextPosition = collisionChecker(tempPos);
		}
		if (nextPosition == null && curr.getX() + 1 < _roommap.getRows()) {
			tempStep = new RightStep(curr);
			Position tempPos = tempStep.move();
			if (_roommap.getValueAtPosition(tempPos) >= 3)
				return null;
			runSensors(tempPos);
			nextPosition = collisionChecker(tempPos);
		}
		if (nextPosition == null && curr.getX() - 1 >= 0) {

			tempStep = new LeftStep(curr);
			Position tempPos = tempStep.move();
			if (_roommap.getValueAtPosition(tempPos) >= 3)
				return null;
			runSensors(tempPos);
			nextPosition = collisionChecker(tempPos);
		}
		return nextPosition;

	}

	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * @return void
	 * <p>collisionChecker class</p>
	 */
	private Position collisionChecker(Position tempPos) {
		Position nextPosition = null;
		if (!isCollision) {
			nextPosition = tempPos;
			_roommap.updateMap(nextPosition);
		} else {
			// Fill Here
			char r = getHResponse(hummanPos, tempPos);
			//for rendering face I make rFF 
			RobotFaceFrame rFF=new RobotFaceFrame();
			if (r == '1') {// Happy
				// Fill Here
				/* produce sound say I am Happy Thank you with happy rythm */
				sp.produceSound("I am Happy Thank you", "happy");
				/*make a happy face*/
				feb.getHappyFace();
			} else if (r == '0') {//Sad
				// Fill Here
				/* produce sound say I am Sad with sad rythm*/
				Sound temp=sp.produceSound("I am Sad", "sad");
				temp.play();
				/*make a sad face*/
				feb.getSadFace();
			} else if (r == '#') {// Wondering
				// Fill Here
				/* produce sound say I am wondering with wondering rythm*/
				sp.produceSound("I am wondering", "wondering");
				/*make a wondering face*/
				feb.getWonderingFace();
			}
			//suppose here we render a face to the object
			rFF.RenderFace();
			waitSeconds();//wait a seconds for showing the result
			rFF.KillFace();//kill the face
		}

		return nextPosition;
	}

	/*
	 * 
	 * Test the interactive parts of Robot Robot task is to navigate through
	 * room with human as obstacles Sample input give the robot the response to
	 * its interactive behavior sample input is given in imap file
	 */
	private FacialExpressionsBuilder feb;
	private SoundProducer sp;
	private ArrayList<Position> hummanPos = new ArrayList<Position>();

	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>navigateInteractively class</p>
	 */
	public boolean navigateInteractively() {
		// (1) to read first the imap file
		_roommap = new RoomMap(4, 4);
		_roommap.generateRoomMapFromFile("imap");

		// (2) get the human responses
		Scanner fmapr = null;
		try {
			fmapr = new Scanner(new FileReader("imapr"));
			int n = fmapr.nextInt();
			for (int i = 0; i < n; i++) {
				int x = fmapr.nextInt();
				int y = fmapr.nextInt();
				int r = fmapr.nextInt();
				if (r == 1)
					hummanPos.add(new Position(x, y, '1'));
				else
					hummanPos.add(new Position(x, y, '0'));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// (3) initiate FacialExpression Builder and SoundProducer
		feb = new FacialExpressionsBuilder();
		feb.initFace();
		sp = new SoundProducer();

		// (4) Start to navigate when face human, robot response wondering
		// expression
		// if human response is 1 means he will move, robot response by happy
		// expression
		// if human response is 0 means he won't move, robot response by sad
		// expression
		Position A = new Position(0, 0, ' ');
		Position B = new Position(3, 3, ' ');
		_roommap.updateMap(A);
		Position curr_pos = getNextPositionInter(A);
		if (curr_pos == null)
			return false;
		while (!curr_pos.isEqual(B)) {
			curr_pos = getNextPositionInter(curr_pos);
			if (curr_pos == null)
				return false;
		}
		return true;

	}
	/**
	 * @author Anas Alsbeinti
	 * @version 1.0
	 * @since 18-5-2015
	 * <p>getHResponse class</p>
	 */
	private char getHResponse(ArrayList<Position> hpos, Position ps) {
		for (int i = 0; i < hpos.size(); i++)
			if (hpos.get(i).isEqual(ps))
				return hpos.get(i).getDir();
		return '#';
	}

	private void waitSeconds() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
