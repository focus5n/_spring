package hierarchical;

public class SongImpl implements Song {
    private String title;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
