package RobotControllers;
/* This class for identify the position if robot on a grid of m*n */
/**
 * @author Anas Alsbeinti
 * @version 1.0
 * @since 18-5-2015
 * <p>Position class</p>
 */
public class Position {
 
	private int _x;
	private int _y;
	private char _dir;

	public Position(int x,int y,char dir){
			_x=x;
			_y=y;
			_dir=dir;
	}
	char getDir(){
		return _dir;
	}
	
	public int getX() {
		return _x;
	}
	
	public void setX(int _x) {
		this._x = _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void setY(int _y) {
		this._y = _y;
	}
 
	public boolean isEqual(Position pos){
		return (this._x == pos.getX() && this._y==pos.getY());
	}
 
	@Override
	public String toString() {
	    return "Pos ("+_x +","+ _y+")";
	}
}
