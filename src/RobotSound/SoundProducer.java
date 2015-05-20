package RobotSound;

public class SoundProducer {
	
	public Sound produceSound(String text, String rythT){
		
		if(rythT.compareTo("happy")==0){
			HappySound hs= new HappySound();
			hs.init(text);
		    return hs;
			
		}else if (rythT.compareTo("sad") == 0){
			SadSound ss= new SadSound();
			ss.init(text);
		    return ss;
			
		}else if( rythT.compareTo("wondering") ==0 ){
			WonderingSound ws= new WonderingSound();
			ws.init(text);
		    return ws;
			
		}else
			return null;
		
	}

}
