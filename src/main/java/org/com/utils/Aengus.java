package org.com.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Aengus {
    private static final Mercury mercury = new Mercury();
    private static Clip clip;
    private static FloatControl volumeControl;
    private static boolean isPaused = false;
    private static boolean isPlaying = false;

    /**
     * Plays music from a specified location with optional loop count.
     * @param location The path to the music file.
     * @param loopCount The number of times to repeat the music (-1 for infinite loop).
     */
   public static void playMusic(String location, int loopCount) {
    try {
        File musicFile = new File(location);
        if (musicFile.exists()) {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Configura o controle de volume
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Define o volume inicial como baixo (-20.0f é um exemplo de volume baixo)
            float initialVolume = -20.0f; // Ajuste este valor conforme necessário
            volumeControl.setValue(initialVolume);

            // Reproduz a música
            clip.loop(loopCount);  // Loop the audio (-1 for infinite)
            clip.start();
            isPlaying = true;

            // Espera até que a música termine
            clip.isActive();
        } else {
            mercury.showError("Música não encontrada.");
        }
    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        System.out.println(e.getMessage());
    }
}


    /**
     * Pauses the currently playing music.
     */
    public static void pauseMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPaused = true;
            isPlaying = false;
        }
    }

    /**
     * Resumes the currently paused music.
     */
    public static void resumeMusic() {
        if (clip != null && isPaused) {
            clip.start();
            isPaused = false;
            isPlaying = true;
        }
    }

    /**
     * Stops the music and resets it to the beginning.
     */
    public static void stopMusic() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);  // Reset to the beginning of the song
            isPlaying = false;
        }
    }

    /**
     * Adjusts the volume of the music.
     * @param volume The volume level to set (0.0f to 1.0f).
     */
    public static void adjustVolume(float volume) {
        if (volumeControl != null) {
            // Clip volume is represented between -80.0f (silent) and 6.0206f (maximum volume)
            float newVolume = volume;
            volumeControl.setValue(newVolume);
        }
    }

    /**
     * Returns whether the music is currently playing.
     * @return True if the music is playing, false otherwise.
     */
    public static boolean isMusicPlaying() {
        return isPlaying;
    }

    /**
     * Returns whether the music is currently paused.
     * @return True if the music is paused, false otherwise.
     */
    public static boolean isMusicPaused() {
        return isPaused;
    }

    /**
     * Resets the audio player (stops and closes the clip).
     */
    public static void resetPlayer() {
        if (clip != null) {
            clip.close();
        }
    }
}
