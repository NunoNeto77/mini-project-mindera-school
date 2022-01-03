package listenToMusic;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;


public class Music {

    public void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();  
                clip.open(audioInput); 
                clip.start();

                clip.loop(Clip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null, "hit ok to pause"); // when you supply a null argument like that, the JOptionPane dialog will be centered on the user’s screen.
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();

                JOptionPane.showMessageDialog(null, "hit ok to resume");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();

                JOptionPane.showMessageDialog(null, "press ok to stop playing");
            }

            else {
                System.out.println("Can't find file");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
