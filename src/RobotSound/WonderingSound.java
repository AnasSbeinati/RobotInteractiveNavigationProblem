package RobotSound;

public class WonderingSound implements Sound{

	private String _text;
	@Override
	public void init(String text) {
		_text = text;
		
	}

	@Override
	public void play() {
		System.out.println("Wondering :" + _text + "!!!");
		
	}
	
}
