package RobotPlanner;

import RobotControllers.ForwardStep;
import RobotControllers.LeftStep;
import RobotControllers.Position;
import RobotControllers.RightStep;
import RobotControllers.RoomMap;
import RobotControllers.Step;
import SensorsUtilities.InfraredSensor;
import SensorsUtilities.SensorsObserver;
import SensorsUtilities.UltraSensor;

public class FRLPlanner extends SensorsObserver implements RobotPlanner {

	private RoomMap _roommap;
	private Step tempStep;
    public FRLPlanner(RoomMap room) {
    	sensors[0] = new InfraredSensor();
    	sensors[0].attach(this);
    	sensors[1] = new UltraSensor();
    	sensors[0].dettach(this);;
    	_roommap = room;    	
    }
	
    public void runSensors (Position pos) {
    	sensors[0].readSignal(_roommap.getValueAtPosition(pos));
    	sensors[1].readSignal(_roommap.getValueAtPosition(pos));
    }
    
	@Override
    public void updateCollision () {
		if( sensors[0].isCollision || sensors[1].isCollision){
			this.isCollision = true;
		}else{
			this.isCollision = false;
		}		
	}

	
	@Override
	public Position getNextPosition(Position curr) {
		Position nextPosition = null;
		//Step tempStep = null;
		if( curr.getY()+1 < _roommap.getColumns() )
		{	
			tempStep = new ForwardStep(curr);
			Position tempPos = tempStep.move();
			runSensors(tempPos);
			if(!isCollision){
				nextPosition = tempPos;
				_roommap.updateMap(nextPosition);
			    //steps.add(tempStep);
			}
		}
		if( nextPosition == null && curr.getX()+1 < _roommap.getRows())
		{	
			tempStep = new RightStep(curr);
			Position tempPos = tempStep.move();
			runSensors(tempPos);
			if(!isCollision){
				nextPosition = tempPos;
				_roommap.updateMap(nextPosition);
			//	steps.add(tempStep);
			}
		}
		if( nextPosition == null && curr.getX()-1 >= 0){
			tempStep = new LeftStep(curr);	
			Position tempPos = tempStep.move();
			runSensors(tempPos);
		    if(!isCollision){
		    	nextPosition = tempPos;
		    	_roommap.updateMap(nextPosition);
		    //	steps.add(tempStep);
		    }
		}
		
		 return nextPosition;	
	}
	

	public Step getStep(){
		return tempStep;
		
	}
}
