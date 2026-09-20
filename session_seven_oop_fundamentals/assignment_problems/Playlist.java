package session_seven_oop_fundamentals.assignment_problems;

import java.util.Arrays;

public class Playlist {

    private final String[] songs; // fixed max size, never exposed directly
    private int count = 0;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
    }

    public void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }
        songs[count] = title;
        count++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count); // a NEW array — hacking it changes nothing inside
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // try to break in from outside

        System.out.println(p.getSongs()[0]);   // Song A — unchanged
        System.out.println(p.getSongCount());  // 2
    }
}