
public class Song implements Comparable{
    private String title;
    

	public Song (String song) {
        setSong(song);
    }

    public Song() {
		// TODO Auto-generated constructor stub
	}

	public String getSong(){
        return this.title;
    }

    public void setSong(String song) {
        this.title = song;
    }

    public int compareTo(Object o) {
        Song tempSong = (Song) o;
        return this.getSong().compareTo(tempSong.getSong());
    }
}