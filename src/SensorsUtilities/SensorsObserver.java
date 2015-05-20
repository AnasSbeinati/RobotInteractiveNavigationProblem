package SensorsUtilities;


public abstract class SensorsObserver {

	public boolean isCollision = false;
	public Sensor [] sensors = new Sensor[2];
	
	public abstract void updateCollision () ;

}
