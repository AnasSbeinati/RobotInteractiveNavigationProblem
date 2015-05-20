package SensorsUtilities;
import java.util.ArrayList;


public abstract class Sensor {

	protected ArrayList<SensorsObserver> observers = new ArrayList<SensorsObserver>();
	public boolean isCollision = false;
	
	public void attach(SensorsObserver obs) {
		observers.add(obs);
	} 
	
	public void dettach(SensorsObserver obs){
		observers.remove(obs);
	}
	public abstract void readSignal(int posV);
	public abstract void notifyObservers();
	
	
	
}
