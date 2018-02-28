package exam.photo;

public class Photo implements Qualified{
   private String name;
   private Quality quality;

    public Photo(String name) {
        quality=Quality.NO_STAR;
        this.name = name;
    }

    public Photo(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality q) {
        quality=q;
    }
}
