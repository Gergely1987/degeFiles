//package tree.shop;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//
//import java.util.Arrays;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.*;
//
//public class ShopTest {
//
//    private Shop shop=new Shop();
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//
//    @Test
//    public void addCategoryWithWrongParentIdTest(){
//        expectedException.expect(IllegalArgumentException.class);
//
//        shop.addCategory(1,"Phone",1);
//
//
//    }
//
//    @Test
//    public void addCategoryTest(){
//        shop.addCategory(1,"Phone",0);
//        shop.addCategory(2,"Notebook",0);
//
//        assertThat(shop.subCategoriesNames(0).get(0), equalTo("Phone"));
//        assertThat(shop.subCategoriesNames(0).get(1), equalTo("Notebook"));
//    }
//
//    @Test
//    public void addProductWithWrongCategoryId(){
//        expectedException.expect(IllegalArgumentException.class);
//
//        shop.addProduct(0,"IPhone",1);
//    }
//
//    @Test
//    public void addProduct(){
//
//        shop.addCategory(1,"Phone",0);
//        shop.addProduct(0,"iPhone",1);
//
//        assertThat(shop.productsOfCategory(1).get(0).getName(), equalTo("iPhone"));
//
//    }
//
//    @Test
//    public void itemsInSameCategoryTest(){
//
//        shop.addCategory(1,"Phone",0);
//        shop.addProduct(0,"IPhone6",1);
//        shop.addProduct(1,"Samsung",1);
//
//        assertThat(shop.itemsInSameCategory(0), equalTo(Arrays.asList("Samsung")));
//
//    }
//
//    @Test
//    public void findProductByIdTest(){
//
//        shop.addCategory(1,"Phone",0);
//        shop.addCategory(2,"iPhone",1);
//        shop.addProduct(0,"iPhone6",2);
//        shop.addProduct(1,"Samsung",1);
//
//        assertThat(shop.findProductById(shop.getRoot(),1).getName(), equalTo("Samsung"));
//        assertThat(shop.findProductById(shop.getRoot(),0).getName(), equalTo("iPhone6"));
//    }
//
//    @Test
//    public void pathToCategoryTest(){
//
//        shop.addCategory(1,"Phone",0);
//        shop.addCategory(2,"iPhone",1);
//        shop.addCategory(3,"Notebook",0);
//
//        assertThat(shop.pathToCategory(1L), equalTo(Arrays.asList("Shop")));
//        assertThat(shop.pathToCategory(2L), equalTo(Arrays.asList("Shop", "Phone")));
//
//    }
//
//
//    @Test
//    public void pathToProductTest(){
//
//        shop.addCategory(1,"Phone",0);
//        shop.addCategory(2,"iPhone",1);
//        shop.addProduct(0,"Samsung",1);
//        shop.addProduct(1,"iPhone6",2);
//
//       assertThat(shop.pathToProduct(0L), equalTo(Arrays.asList("Shop", "Phone")));
//       assertThat(shop.pathToProduct(1L), equalTo(Arrays.asList("Shop", "Phone", "iPhone")));
//
//    }
//
//
//
//
//}