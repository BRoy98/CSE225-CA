package sh.broy.androidca225.Model;

public class ThemeModel {

    public ThemeModel(final String title, final String color) {
        this.title = title;
        this.color = color;
    }

    private String color;
    private String title;

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
