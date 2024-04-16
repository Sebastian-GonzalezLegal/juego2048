package TpV00;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ClaseSonido {
    private Clip clip;

    public ClaseSonido(String ruta) {
        try {
            File soundFile = new File(ruta);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }
}