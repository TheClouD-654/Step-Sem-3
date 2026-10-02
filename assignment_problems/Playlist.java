import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    // Constructor: initializes internal array with fixed capacity
    public Playlist(int capacity) {
        if (capacity <= 0) {
            capacity = 10; // safe default capacity
        }
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    // Adds a song if space remains
    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            return;
        }
        if (songCount < songs.length) {
            songs[songCount++] = song;
        } else {
            System.out.println("Playlist is full. Cannot add: " + song);
        }
    }

    // Returns a safe copy of all songs added so far, protecting internal state
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    // Read-only getter for the count of songs added
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("p.getSongCount() -> " + p.getSongCount());
        System.out.println("Before modification: copy[0] = \"" + copy[0] + "\", p.getSongs()[0] = \"" + p.getSongs()[0] + "\"");

        // Attempting to modify the returned array from outside
        copy[0] = "Hacked";
        System.out.println("After modifying copy[0] to \"Hacked\":");
        System.out.println("copy[0] = \"" + copy[0] + "\"");
        System.out.println("p.getSongs()[0] is still \"" + p.getSongs()[0] + "\"");
    }
}
