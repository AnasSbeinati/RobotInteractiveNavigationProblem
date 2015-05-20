/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>RoomMap Class</p>
 */
package RobotControllers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;


public class RoomMap {

	private int [][] _map ;
	private int _m;
	private int _n;
	private int uCounter;
	
	public RoomMap(int m, int n){
		_m =m;
		_n =n;
		_map = new int[m][n];
		uCounter=3;
	}
	
	public void generateRoomMap(){
		for(int i=0; i<_m ; i++){
			for(int j=0; j<_n ; j++){
			   if ( j-i == 1  ) 
				   _map[i][j] = new Random().nextInt(3); // 0:open 1:object 2:human/animal	
			   else
				   _map[i][j] =0;
				  
			}
		}
	}
	
	public void generateRoomMapFromFile(String fileName){
		uCounter=3;
		Scanner fmap = null;
		try {
			fmap = new Scanner(new FileReader(fileName));	
			_m = fmap.nextInt();
			_n = fmap.nextInt();
			_map = new int[_m][_n];
	 		for(int i=0; i<_m ; i++)
				for(int j=0; j<_n ; j++)
					_map[i][j] = fmap.nextInt();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	
		}
	}
	
	public void showMap(){
		
		for(int i=0; i<_m ; i++){
			for(int j=0; j<_n ; j++){
			    if(_map[i][j] >= 3 )
			    	System.out.print("R"+(_map[i][j]-3) +"\t");
			    else if(_map[i][j] == 2)
			    	System.out.print("H\t");
			    else if(_map[i][j] == 1)
			    	System.out.print("J\t");
			    else
			    	System.out.print(_map[i][j] + "\t");
			    
			}
			System.out.println();
		}
	}

	
	
	
	public int getValueAtPosition(Position p){
		return _map[p.getX()][p.getY()];
	}
	
	public int getColumns(){
		return _n;
	}
	public int getRows(){
		return _m;
	}

	public void updateMap(Position pos) {
		_map[pos.getX()][pos.getY()]= uCounter++;
		
	}
	public void zeroMap() {
	 uCounter = 3;
	}
	
}
