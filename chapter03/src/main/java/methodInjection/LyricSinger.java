package methodInjection;

public class LyricSinger implements Singer {
    private String lyric = "I ~~~~~~ ^-^b";

    @Override
    public void sing() {
        System.out.println("Sing a Lyric by LyricSinger.");
    }
}
