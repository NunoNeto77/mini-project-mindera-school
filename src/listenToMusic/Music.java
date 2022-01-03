package listenToMusic;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

// clip é um tubo fechado

public class Music {

    public void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();  // Clip interface represents a special kind of data line whose audio data can be loaded prior to playback, instead of being streamed in real time
                clip.open(audioInput); // Opens the clip with the format and audio data present in the provided audio input stream.
                clip.start();

                clip.loop(Clip.LOOP_CONTINUOUSLY); // Java Clip LOOP_CONTINUOUSLY A value indicating that looping should continue indefinitely rather than complete after a specific number of loops.

                JOptionPane.showMessageDialog(null, "hit ok to pause"); // when you supply a null argument like that, the JOptionPane dialog will be centered on the user’s screen.
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();

                JOptionPane.showMessageDialog(null, "hit ok to resume");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();

                JOptionPane.showMessageDialog(null, "press ok to stop playing"); // impedir q a thread clip se mate
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
