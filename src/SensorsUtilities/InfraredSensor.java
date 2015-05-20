package SensorsUtilities;



public class InfraredSensor extends Sensor {

	
	float value = -99999;
	public void readSignal(int posV){
		if(posV == 2 ) // human/animal detected
			value =20;
		else 
			value=0;
		
		if(value > 10)
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
