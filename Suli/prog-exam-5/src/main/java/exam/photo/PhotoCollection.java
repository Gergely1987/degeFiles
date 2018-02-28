package exam.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    private List<Photo>photos=new ArrayList<>();

    public List<Photo> getPhotos(){
       return photos;
    }

    public void addPhoto(String... photos){
        for (String s:photos) {
            Photo a=new Photo(s);
            this.photos.add(a);
        }
    }

    public int numberOfStars(){
        int num=0;
        for (Photo p:photos) {
            num+=p.getQuality().value;
        }
        return num;
    }

    public void starPhoto(String name, Quality q){
        for (Photo p:photos) {
            if(p.getName().equals(name)){
                p.setQuality(q);
                return;
            }
        }
        throw new PhotoNotFoundException();
    }
}
