package main.project.classes;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioController {
    private static MediaPlayer mediaPlayer;

    public static void playAudio(Audio audio) {

        String audioFilePath = audio.getFilePath();

        Media media = new Media(audioFilePath);

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