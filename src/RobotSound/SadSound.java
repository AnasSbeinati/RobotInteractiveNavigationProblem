package RobotSound;

public class SadSound implements Sound{

	private String _text;
	@Override
	public void init(String text) {
		_text = text;
		
	}

	@Override
	public void play() {
		System.out.println("SAD :" + _text);
		
	}

}
