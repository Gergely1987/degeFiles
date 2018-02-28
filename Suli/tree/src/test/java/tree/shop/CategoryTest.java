//package tree.shop;
//
//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.*;
//
//
//public class CategoryTest {
//
//    Category category = new Category(0, "IT");
//
//    @Test
//    public void createCategory() {
//        assertThat(category.getName(), equalTo("IT"));
//        assertThat(category.getId(), equalTo(0L));
//        assertThat(category.getParent(), equalTo(null));
//        assertThat(category.getProducts().size(), equalTo(0));
//    }
//
//    @Test
//    public void createHierarchy() {
//        Category childCategory1 = new Category(1, "Phone", category);
//        Category childCategory2 = new Category(2, "Notebook", category);
//
//        assertThat(childCategory2.getName(), equalTo("Notebook"));
//        assertThat(childCategory1.getParent().getId(), equalTo(0L));
//        assertThat(category.getChildren().size(), equalTo(2));
//        assertThat(category.getChildren().get(1).getName(), equalTo("Notebook"));
//        assertThat(childCategory1.getChildren().size(), equalTo(0));
//
//    }
//
//
//}