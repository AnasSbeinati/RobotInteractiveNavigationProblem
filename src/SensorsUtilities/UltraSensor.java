package SensorsUtilities;


public class UltraSensor extends Sensor {

	
	float value = -99999;
	
	public void readSignal(int posV){
		if(posV == 1 ) // object detected
			value = 3;
		else 
			value=0;
		
		if(value > 2)
			isCollision =true;
		else
			isCollision =false;
		
		notifyObservers();
	}
	
	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++)
			observers.get(i).updateCollision();
		
	}


}
