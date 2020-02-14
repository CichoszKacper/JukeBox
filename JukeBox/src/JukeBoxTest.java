import junit.framework.TestCase;

import java.util.LinkedList;

public class JukeBoxTest extends TestCase {
    JukeBox jk = new JukeBox();
    public void testRemoveSoppySongs() {
        Song s1 = new Song("Toto - Africa");
        Song s2 = new Song("Nickelback - Love Love");
        Song s3 = new Song("Something - Love");

        LinkedList <Song> expected = new LinkedList<Song>();
        expected.add(s1);


        JukeBox jukeBox = new JukeBox();
        jukeBox.add(s1);
        jukeBox.add(s2);
        jukeBox.add(s3);
        jukeBox.removeSoppySongs();

        assert(expected.size() == jukeBox.getJukeBox().size());


    }
}