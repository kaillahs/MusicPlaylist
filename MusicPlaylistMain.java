// Kaillah Selvaretnam
// Music Playlist Main
// This program allows the user to create a playlist and manipulate it in various ways.
// The user can add and play songs, as well as print, clear, and delete from the begnning
// or end of their listening history.
import java.util.*;
import java.io.*;

public class MusicPlaylistMain {
    public static void main(String[] args) {
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        Scanner console = new Scanner(System.in);
        String action = "";
        System.out.println("Welcome to the CSE 122 Music Playlist!");
        musicPlaylist.mainMenu();
        action = console.nextLine();

        while (!action.equalsIgnoreCase("Q")) {
            if (action.equalsIgnoreCase("A")) {
                addSong(console, musicPlaylist);
            } else if (action.equalsIgnoreCase("P")) {
                playSong(musicPlaylist);
            } else if (action.equalsIgnoreCase("Pr")) {
                printHistory(musicPlaylist);
            } else if (action.equalsIgnoreCase("C")) {
                musicPlaylist.clearHistory();
            } else if (action.equalsIgnoreCase("D")) {
                deleteFromHistory(console, musicPlaylist);
            }
            musicPlaylist.mainMenu();                                         
            action = console.nextLine();                        
        }
    }

    //Behavior: Prompts the user for the name of the song they would like to add and 
    //          adds it to the top of the playlist.
    //Parameter: Scanner console which allows the user to input the name of the song. 
    //           The current playlist in the form of a Queue<String>. 
    public static void addSong(Scanner console, MusicPlaylist musicPlaylist) {
        System.out.print("Enter song name: ");
        String song = console.nextLine();
        musicPlaylist.addSong(song);
        System.out.println("Successfully added " + song);
        System.out.println();
        System.out.println();
        
    }

    //Behavior: Plays the song at the top (least recently added) of the playlist and then
    //          removes it from the Playlist and adds it to the listening history.          
    //Parameter: The current listening history in the form of a Stack<String>. 
    //           The current playlist in the form of a Queue<String>. 
    //Exception: Throws an IllegalStateException if the playlist has no songs in it. 
    public static void playSong(MusicPlaylist musicPlaylist) {
        String song = musicPlaylist.playSong();
        System.out.println("Playing song: " + song);
        System.out.println();
        System.out.println();
    }
    
    //Behavior: Prints the users listing history starting with the most recently played song.       
    //Parameter: The current listening history in the form of a Stack<String>.  
    //Exception: Throws an IllegalStateException if the listing history has no songs in it.
    public static void printHistory(MusicPlaylist musicPlaylist) {
        musicPlaylist.printHistory();
        System.out.println();
        System.out.println();
    }

    //Behavior: Prompts the user for the number of songs they would like to delete from
    //          their listeing history. The method deletes from recent history if the user
    //          enters a positive number and deletes from the beginning of the listening history
    //          if the user enters a negative number. If the user inputs 0, nothing will
    //          happen and no songs will be removed from the history. 
    //Parameter: The current listening history in the form of a Stack<String>. 
    //           Scanner console to allow the user to input the number of songs they would
    //           like to delete. 
    //Exception: Throws an IllegalArgumentException if the abolute value of the number provided
    //           by the user is larger than the length of the listening history.
    public static void deleteFromHistory(Scanner console, MusicPlaylist musicPlaylist) {
        System.out.println("A positive number will delete from recent history.");
        System.out.println("A negative number will delete from the beginning of history.");
        System.out.print("Enter number of songs to delete: ");
        System.out.println();
        String numberString = console.nextLine();
        int number = Integer.parseInt(numberString);
        musicPlaylist.deleteFromHistory(number);
    }
}

