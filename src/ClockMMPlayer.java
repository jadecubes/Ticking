/*
 * author: Yu-Fang Juan
 * date:Feb 20th, 2017
 * title: Ticking Circus
 * All rights reserved.
 */
import java.io.File;
import javax.media.*;



public class ClockMMPlayer{	
	private Player player;
	private boolean isLooping=false;
    public ClockMMPlayer(String filePath) {
    	assert filePath.length()>0;	

        try{
            player = Manager.createPlayer(new MediaLocator(new File(filePath).toURI().toURL()));
            player.addControllerListener(new ControllerListener() { 
                public void controllerUpdate(ControllerEvent e) 
                {   
                  if (e instanceof EndOfMediaEvent) {
                      player.setMediaTime(new Time(0));
                      if(isLooping)
                    	  player.start();
                  }
                } 

            });            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
    public void play(){          	
    	player.start();
      
    }
    public void stop(){
    	player.stop();
    }
    public void setLooping(boolean loopingFlag){
    	isLooping = loopingFlag;
    }


}