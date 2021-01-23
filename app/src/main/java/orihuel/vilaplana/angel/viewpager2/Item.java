package orihuel.vilaplana.angel.viewpager2;

public class Item {

    private int idImage;

    private String title;

    private String subtitle;

    private String description;

    public Item(int idImage, String title, String subtitle, String description) {
        this.idImage = idImage;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

}
