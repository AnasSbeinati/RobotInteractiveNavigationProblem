package RobotSound;

public class HappySound implements Sound{

	private String _text;
	@Override
	public void init(String text) {
		_text = text;
		
	}

	@Override
	public void play() {
		System.out.println("HAPPY :" + _text);
		
	}

}
