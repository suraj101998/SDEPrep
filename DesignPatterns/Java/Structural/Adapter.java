package DesignPatterns.Java.Structural;
/*
 * Adapter Pattern
Definition: Converts one interface into another expected by the client.
Use Case: Connecting incompatible interfaces, like a mobile charger adapter.
 */
interface MediaPlayer { void play(String audioType, String fileName); }
class VLCPlayer { void playVLC(String fileName) { System.out.println("Playing VLC: " + fileName); } }

class MediaAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer = new VLCPlayer();
    public void play(String audioType, String fileName) { vlcPlayer.playVLC(fileName); }
}

class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;
    
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            adapter = new MediaAdapter();
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Playing MP3: " + fileName);
        }
    }
}

public class Adapter {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("vlc", "song.vlc");
    }
}

