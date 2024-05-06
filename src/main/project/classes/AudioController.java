package main.project.classes;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class AudioController {
    private static MediaPlayer mediaPlayer;

    public static void playAudio(Audio audio) {

        String audioFilePath = audio.getFilePath();
        URL resource = AudioController.class.getClassLoader().getResource(audioFilePath);
        if (resource == null) {
            System.out.println("Cannot find resource: " + audioFilePath);
            return;
        }
        Media media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }
    //Method to check if the audio is playing
    public static boolean isAudioPlaying() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
    }

    public static void stopAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}