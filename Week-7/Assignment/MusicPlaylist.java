import java.util.Arrays;

public class MusicPlaylist {

    // Playlist returning defensive copies to preserve encapsulation
    public static class Playlist {
        private final String[] songs;
        private int songCount;

        public Playlist(int capacity) {
            this.songs = new String[capacity];
            this.songCount = 0;
        }

        public void addSong(String song) {
            if (song != null && songCount < songs.length) {
                songs[songCount++] = song;
            }
        }

        // Returns a safe defensive copy rather than exposing internal array
        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("copy[0] = \"Hacked\"");
        System.out.println("p.getSongs()[0] is still: " + p.getSongs()[0]);
        System.out.println("Total songs: " + p.getSongCount());
    }
}
