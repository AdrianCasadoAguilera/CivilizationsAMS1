package com.project.UI.util.clips;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Clips {

    public static final String BUTTONCLICKED = "button";
    public static final String BUTTONHOVERED = "hover";
    public static final String MAINVIEW = "main";
    public static final String START = "initial";

    public static Clip buttonClicked;
    public static Clip initialTheme;
    public static Clip buttonHovered;

    public static void playAudio(String theme){
        if(theme == "button"){
            try {
                buttonClicked = AudioSystem.getClip();
                buttonClicked.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/clicked.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            buttonClicked.stop();
            buttonClicked.setFramePosition(0);
            buttonClicked.start();
        }
        if(theme == "initial"){
            try {
                initialTheme = AudioSystem.getClip();
                initialTheme.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/initial_theme.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            initialTheme.stop();
            initialTheme.setFramePosition(0);
            initialTheme.loop(Clip.LOOP_CONTINUOUSLY);
            initialTheme.start();
        }
        if(theme == "hover"){
            try {
                buttonHovered = AudioSystem.getClip();
                buttonHovered.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/button_hover.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            buttonHovered.stop();
            buttonHovered.setFramePosition(0);
            buttonHovered.start();
        }
    }

    public static void stopPlaying(String theme){
        if(theme == "initial"){
            initialTheme.stop();
        }
    }
}