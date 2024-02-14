package methodInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class LyricSinger implements Singer {
    private String lyric = "I ~~~~~~ ^-^b";

    @Override
    public void sing() {
        System.out.println("Sing a Lyric by LyricSinger.");
    }
}
