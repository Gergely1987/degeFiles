package exam.photo;

import exam.photo.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhotoCollectionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreatePhoto() {
        Photo photo = new Photo("a.jpg");
        assertThat(photo.getName(), equalTo("a.jpg"));
        assertThat((photo).getQuality(), equalTo(Quality.NO_STAR));
    }

    @Test
    public void testIsStarable() {
        Qualified qualified = new Photo("a.jpg");
        assertThat((qualified).getQuality(), equalTo(Quality.NO_STAR));
    }

    @Test
    public void testCreatePhotoWithStar() {
        Photo photo = new Photo("a.jpg", Quality.ONE_STAR);
        assertThat(photo.getName(), equalTo("a.jpg"));
        assertThat(photo.getQuality(), equalTo(Quality.ONE_STAR));

    }

    @Test
    public void testStarPhoto() {
        Photo photo = new Photo("a.jpg");
        assertThat(photo.getName(), equalTo("a.jpg"));
        assertThat(photo.getQuality(), equalTo(Quality.NO_STAR));

        photo.setQuality(Quality.ONE_STAR);
        assertThat(photo.getQuality(), equalTo(Quality.ONE_STAR));
    }

    @Test
    public void testCreatePhotoCollection() {
        PhotoCollection photoCollection = new PhotoCollection();
        assertThat(photoCollection.getPhotos().size(), is(0));
    }

    @Test
    public void testStarsEmpty() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        assertThat(photoCollection.numberOfStars(), equalTo(0));
    }

    @Test
    public void testNotFound() {
        expectedException.expect(PhotoNotFoundException.class);
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        photoCollection.starPhoto("d.jpg", Quality.ONE_STAR);
    }

    @Test
    public void testStars() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        photoCollection.starPhoto("a.jpg", Quality.TWO_STAR);
        photoCollection.starPhoto("a.jpg", Quality.ONE_STAR);
        assertThat(photoCollection.numberOfStars(), equalTo(1));
    }

    @Test
    public void testStarsThree() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg", "d.jpg", "e.jpg");
        photoCollection.starPhoto("a.jpg", Quality.ONE_STAR);
        photoCollection.starPhoto("b.jpg", Quality.TWO_STAR);
        assertThat(photoCollection.numberOfStars(), equalTo(3));
    }
}
