package Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    long t;
    Clip clip;

    /**
     * Initialises the Sound
     *
     * @param pathname The pathname of the sound clip to be played, if the clip is in the same directory as your class you just need to enter the name of clip. The clip can't be an mp3-file.
     */
    public Sound(String pathname) throws Exception {
        File file = new File(pathname);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    /**
     * Play the Sound for the whole duration. It will stop your programm, until it has finished.
     */
    public void playSound() {
        clip.setMicrosecondPosition(0);
        t = clip.getMicrosecondLength() / 1000;
        clip.start();
        waitFor(t);
        clip.stop();
    }
    
    public void startSound(){
        clip.setMicrosecondPosition(0);
        clip.start();
    }
    
    public void startSoundAt(long ms){
        long microseconds = ms * 1000;
        clip.setMicrosecondPosition(microseconds);
        clip.start();
    }

    /**
     * Plays the Sound for the given duration.
     *
     * @param ms duration in milliseconds
     * @param b  If true it will stop and reset the sound, if false it won't.
     */
    public void playSoundFor(long ms, boolean b) {
        clip.setMicrosecondPosition(0);
        t = ms;
        clip.start();
        waitFor(t);
        if (b) {
            clip.stop();
            clip.setMicrosecondPosition(0);
        }
    }

    /**
     * Continues Sound from the point it stopped last.
     */
    public void continueSound() {
        t = (clip.getMicrosecondLength() - clip.getMicrosecondPosition()) / 1000;
        clip.start();
        waitFor(t);
        clip.stop();
        clip.setMicrosecondPosition(0);
    }

    /**
     * Continues Sound from the point it stopped last.
     * @param b If true stops and resets the
     */
    public void continueSoundFor(boolean b, long ms) {
        t = ms;
        clip.start();
        waitFor(t);
        if (b) {
            clip.stop();
            clip.setMicrosecondPosition(0);
        }
    }

    /**
     * Stops the sound.
     */
    public void stopSound() {
        clip.stop();
    }

    /**
     * Resets the sound.
     */
    public void resetSound() {
        clip.setMicrosecondPosition(0);
    }

    /**
     * Gives the length of the Sound in ms.
     *
     * @return length of clip in ms.
     */
    public long getmsLength() {
        return clip.getMicrosecondLength() / 1000;
    }

    /**
     * Gives the position of the Sound in ms.
     *
     * @return position of clip in ms.
     */
    public long getmsPosition() {
        return clip.getMicrosecondPosition() / 1000;
    }

    private void waitFor(long l) {
        try {
            Thread.sleep(l);
        } catch (Exception e) {
        }
    }

    /**
     * Returns the clip-object used for the sound
     *
     * @return clip-object
     */
    public Clip getClip() {
        return clip;
    }
}
