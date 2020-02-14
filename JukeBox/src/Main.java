
public class Main {

    public static void main(String[] args) {
        JukeBox jk = new JukeBox();
        JukeBoxGUI jkgui = new JukeBoxGUI();

        Song title1 = new Song("Toto - Africa Love");
        Song title2 = new Song("Rolling Stones - You Can't Always Got What You Love Want");
        Song title3 = new Song("Nick Cave and Bad Seeds - Jubile Street");

        jk.add(title1);
        jk.add(title2);
        jk.add(title3);
        jk.sortList();
        
    }
}