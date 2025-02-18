package LLD.inheritance_and_polymorphism.media_file_player;

public abstract class MediaFile {
    protected static String title;
    protected static String fileName;

    public MediaFile(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    public String getDetails() {
        return "Title: " + title + ", File: " + fileName;
    }
}

