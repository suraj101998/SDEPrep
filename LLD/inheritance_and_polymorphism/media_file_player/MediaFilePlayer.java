package LLD.inheritance_and_polymorphism.media_file_player;

public class MediaFilePlayer {

    // Corrected playMedia method
    public static void playMedia(MediaFile mediaFile) {
        // Print media details
        System.out.println(mediaFile.getDetails());
        // Demonstrate runtime polymorphism
        mediaFile.play();
    }

    public static void main(String[] args) {
        MediaFile audioFile = new AudioFile("Song Title", "Sonu Nigam", "audio.mp3");
        MediaFile videoFile = new VideoFile("Video Title", "video.mp4", "30 minutes");

        // Call playMedia method with different media types
        playMedia(audioFile);
        playMedia(videoFile);
    }
}
