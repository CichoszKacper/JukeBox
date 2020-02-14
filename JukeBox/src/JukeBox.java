import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class JukeBox {
    private LinkedList <Song> listOfSongs = new LinkedList <Song> ();
    
    

    public void add(Song song){
        this.listOfSongs.add(song);
    }

    public void playFirstSong(){
        System.out.println(this.listOfSongs.removeFirst().getSong());
    }
    
    public void playSong(Song song){
    	this.listOfSongs.remove(song);
    }

    public String printPlayList(){
        String playlist = "";
    	for(Song tempTitle : listOfSongs){
            playlist += tempTitle.getSong() + "\n";
        }
    	return playlist;
    }

    public void size(){
        System.out.println(this.listOfSongs.size());
    }

    public void addSongs(Collection <Song> songs){
        this.listOfSongs.addAll(songs);
    }

    public void sortList (){
        TreeSet <Song> songsSorted = new TreeSet<Song>();
        for (Song tempSong : listOfSongs){
            songsSorted.add(tempSong);
        }
        listOfSongs.clear();
        for (Song tempSong : songsSorted){
            listOfSongs.add(tempSong);
        }
    }
    public void reverseSort (){
        TreeSet <Song> songsSorted = new TreeSet<Song>();
        for (Song tempSong : listOfSongs){
            songsSorted.add(tempSong);
        }
        listOfSongs.clear();
        for (Song tempSong : songsSorted){
            listOfSongs.addFirst(tempSong);
        }
    }

    public int numberPopular(){
        int counter = 0;
        for (Song tempSong : listOfSongs){
            for (PopularSongTitleWords tempWord : PopularSongTitleWords.values()){
                if (tempSong.getSong().toLowerCase().contains(tempWord.toString())){
                    counter++;
                }
            }
        }
        return counter;
    }

    public int numberUnusual() {
        int counterOfUnusualSongs = listOfSongs.size() - numberPopular();
        return counterOfUnusualSongs;
    }

    public void removeSoppySongs (){
        String soppyWord = "love";
        ArrayList <Song> songsToRemove = new ArrayList<Song>();

        for (Song tempSong : this.listOfSongs) {
             try {
                 if (tempSong.getSong().toLowerCase().contains(soppyWord)) {
                     songsToRemove.add(tempSong);
                     throw new NoSoppyLoveSongs();
                 }
             }catch (NoSoppyLoveSongs e){
                 System.out.println(e.toString());
             }
        }

       for (Song tempSong : songsToRemove){
           this.listOfSongs.remove(tempSong);
       }
    }

    public LinkedList<Song> getJukeBox() {
        return this.listOfSongs;
    }
}
