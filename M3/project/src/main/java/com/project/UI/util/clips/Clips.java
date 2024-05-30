package com.project.UI.util.clips;

import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Clips {

    public static final String BUTTONCLICKED = "button";
    public static final String BUTTONHOVERED = "hover";
    public static final String MAINVIEW = "main";
    public static final String START = "initial";
    public static final String FAILEDCONSTRUCTION = "metalpipe";
    public static final String CONTRUCTIONDONE = "constr";
    public static final String ELF = "elf";

    public static final String SWORDSMAN = "swordsman";
    public static final String SPEARMAN = "spearman";
    public static final String CROSSBOW = "crossbow";
    public static final String CANNON = "cannon";
    public static final String ARROWTOWER = "arrowtower";
    public static final String CATAPULT = "catapult";
    public static final String ROCKETLAUNCHER = "rocket";
    public static final String MAGICIAN = "magician";
    public static final String PRIEST = "priest";

    public static Clip buttonClicked;
    public static Clip initialTheme;
    public static Clip buttonHovered;
    public static Clip constrFailed;
    public static Clip constr;
    public static Clip elfTalking;

    public static Clip swordsman;
    public static Clip spearman;
    public static Clip crossbow;
    public static Clip cannon;
    public static Clip arrowTower;
    public static Clip catapult;
    public static Clip rocketLauncher;
    public static Clip magician;
    public static Clip priest;

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
        if(theme == "metalpipe"){
            try {
                constrFailed = AudioSystem.getClip();
                constrFailed.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/construction_failed.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            constrFailed.stop();
            constrFailed.setFramePosition(0);
            constrFailed.start();
        }
        if(theme == "constr"){
            try {
                constr = AudioSystem.getClip();
                constr.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/construction_done.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            constr.stop();
            constr.setFramePosition(0);
            constr.start();
        }
        if(theme == "elf"){
            try {
                int num = (int) (Math.random() * 2) + 1;
                elfTalking = AudioSystem.getClip();
                elfTalking.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/elf_talking"+num+".wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            elfTalking.stop();
            elfTalking.setFramePosition(0);
            elfTalking.start();
        }
        if(theme == SWORDSMAN){
            try {
                swordsman = AudioSystem.getClip();
                swordsman.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/swordsman.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            swordsman.stop();
            swordsman.setFramePosition(0);
            swordsman.start();
        }
        if(theme == SPEARMAN){
            try {
                spearman = AudioSystem.getClip();
                spearman.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/spearman.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            spearman.stop();
            spearman.setFramePosition(0);
            spearman.start();
        }
        if(theme == CANNON){
            try {
                cannon = AudioSystem.getClip();
                cannon.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/cannon.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            cannon.stop();
            cannon.setFramePosition(0);
            cannon.start();
        }
        if(theme == CROSSBOW){
            try {
                crossbow = AudioSystem.getClip();
                crossbow.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/crossbow.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            crossbow.stop();
            crossbow.setFramePosition(0);
            crossbow.start();
        }
        if(theme == ARROWTOWER){
            try {
                arrowTower = AudioSystem.getClip();
                arrowTower.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/arrow_tower.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            arrowTower.stop();
            arrowTower.setFramePosition(0);
            arrowTower.start();
        }
        if(theme == CATAPULT){
            try {
                catapult = AudioSystem.getClip();
                catapult.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/catapult.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            catapult.stop();
            catapult.setFramePosition(0);
            catapult.start();
        }
        if(theme == ROCKETLAUNCHER){
            try {
                rocketLauncher = AudioSystem.getClip();
                rocketLauncher.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/rocket.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            rocketLauncher.stop();
            rocketLauncher.setFramePosition(0);
            rocketLauncher.start();
        }
        if(theme == MAGICIAN){
            try {
                magician = AudioSystem.getClip();
                magician.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/magician.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            magician.stop();
            magician.setFramePosition(0);
            magician.start();
        }
        if(theme == PRIEST){
            try {
                priest = AudioSystem.getClip();
                priest.open(AudioSystem.getAudioInputStream(Clips.class.getResource("/com/project/UI/src/audio/priest.wav")));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            priest.stop();
            priest.setFramePosition(0);
            priest.start();
        }
    }

    public static void stopPlaying(String theme){
        if(theme == "initial"){
            initialTheme.stop();
        }
    }
}
