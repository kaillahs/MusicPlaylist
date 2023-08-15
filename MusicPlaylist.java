// Kaillah Selvaretnam
// Music Playlist
// This program creates a playlist that can be manipulate it in various ways.
// You can add and play songs, as well as print, clear, and delete from the begnning
// or end of the listening history.

import java.util.*;
import java.io.*;
public class MusicPlaylist {
    //fields
    private Queue<String> playlist;
    private Stack<String> history;

    //This creates a new MusicPlaylist with an empty playlist and history. No parameters
    //are necessary to create this object.
    public MusicPlaylist() {
        this.playlist = new LinkedList<>();
        this.history = new Stack<>();
    }

    //This creates a new MusicPlaylist. The parameters are a Queue<String> representing an existing
    //playlist as well as a Stack<String> representing an existing history. 
    public MusicPlaylist(Queue<String> playlist, Stack<String> history) {
        this.playlist = playlist;
        this.history = history;
    }

    //This method allows the user to get the current playlist. There are no parameters
    //passed into this method and the return type is a Queue<String> representing the playlist.
    public Queue<String> getPlaylist() {
        return this.playlist;
    }

    //This method allows the user to get the current history. There are no parameters
    //passed into this method and the return type is a Stack<String> representing the history.
    public Stack<String> getHistory() {
        return this.history;
    }

    //Behavior: Moves items from one stack to another.
    //Parameter: The first Stack<String> from which the elements are taken out of as well
    //           as the second Stack<String> to which the element are being added too.
    private void SToS(Stack<String> history, Stack<String> aux){
        String song = history.pop();
        aux.push(song);
    }

    //Behavior: Prints out the the various ways in which the user can manipulate the playlist.
    //Parameter: no parameters are passed into this method. 
    public void mainMenu() {
        System.out.println("(A) Add song");
        System.out.println("(P) Play song");
        System.out.println("(Pr) Print history");
        System.out.println("(C) Clear history");
        System.out.println("(D) Delete from history");
        System.out.println("(Q) Quit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    //Behavior: Adds a given song to the top of the playlist.      
    //Parameter: String representing the song the user wants to add to the playlist. 
    public void addSong(String song) {
        this.playlist.add(song);
    }

    //Behavior: Plays the song at the top (least recently added) of the playlist and then
    //          removes it from the Playlist and adds it to the listening history.          
    //Parameter: no parameters are passed into this method.
    //Return: String representing the song being played. 
    //Exception: Throws an IllegalStateException if the playlist has no songs in it. 
    public String playSong() {
        if (this.playlist.size() == 0) {
            throw new IllegalStateException();
        }
        String song = this.playlist.remove();
        this.history.push(song);
        return song;
    }
    
    public void printHistory() {
        if (this.history.size() == 0) {
            System.out.println("The print history is empty");
        }
        
        Stack<String> aux = new Stack<>();
        int size = this.history.size();
        
        for (int i = 0; i < size; i++) {
            String song = this.history.pop();
            aux.push(song);
            System.out.println("    " + song);
        }           
        
        for (int i = 0; i < size; i++) {
            SToS(aux, this.history);
        }
    }

    //This method clears the user's listening history. There are no parameters. 
    public void clearHistory() {
        this.history.clear();
    }

    //Behavior: The method deletes from a given number of songs from recent history if given
    //          a positive number and from the beginning of the listening history
    //          if given a negative number. When given 0, nothing will
    //          happen and no songs will be removed from the history. 
    //Parameter: The number of songs being deleted in the form of an interger. 
    //Exception: Throws an IllegalArgumentException if the abolute value of the number provided
    //           is larger than the length of the listening history.
    public void deleteFromHistory(int number) {
        if (Math.abs(number) > history.size()) { 
            throw new IllegalArgumentException();
        }

        if (number > 0) {
            for (int i = 0; i < number; i++) {
                history.pop();
            }
        }

        if (number < 0) {
            Stack<String> aux = new Stack<>();
            int size = history.size();       
            
            for (int i = 0; i < size + number; i++) {
                SToS(history, aux);
            }
            
            history.clear();

            while (!aux.isEmpty()) {
                SToS(aux, history);
            }
        } 
    }


    
}