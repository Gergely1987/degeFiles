package debug;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatchFiveTest {
    @Test
    public void testEmpty() {
        int[][] table = new int[5][5];
        Result result = new MatchFive().findFive(table, 3);
        assertThat(result.getResultType(), equalTo(ResultType.NOT_FOUND));
    }
    
    @Test
    public void testTableFullOfZeros() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        Result result = new MatchFive().findFive(table, 5);
        assertThat(result.getResultType(), equalTo(ResultType.NOT_FOUND));
    }
    
    @Test
    public void testLessThanNumberOfX() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        Result result = new MatchFive().findFive(table, 3);
        assertThat(result.getResultType(), equalTo(ResultType.NOT_FOUND));
    }
    
    @Test
    public void testNumberOfXisFour() {
        int[][] table = {   {0, 0, 0, 0, 1},
                            {0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        Result result = new MatchFive().findFive(table, 4);
        assertThat(result.getResultType(), equalTo(ResultType.FOUND));        
    }
    
    @Test
    public void xCoordinatesAreNotOnOneLine() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 1, 0, 1, 0},
                            {0, 0, 1, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        Result result = new MatchFive().findFive(table, 4);
        assertThat(result.getResultType(), equalTo(ResultType.NOT_FOUND));           
    }
    
    @Test
    public void wrongWinner() {
        int[][] table = {   {0, 0, 0, 1, 0},
                            {0, 2, 0, 1, 0},
                            {0, 0, 2, 1, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 0, 1, 2}};
        Result result = new MatchFive().findFive(table, 4);
        assertThat(result.getResultType(), equalTo(ResultType.FOUND)); 
        assertThat(result.getWinner(), equalTo(2)); 
    }
    
    @Test
    public void testFindRightUpLeftDown() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 1, 0, 0, 0},
                            {1, 0, 0, 0, 0}};
        
        Result result1 = new MatchFive().findFive(table, 3);       
        assertThat(result1.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result1.getWinner(), equalTo(1));
        
        int[][] table2 = {  {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1},
                            {0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0}};
        
        Result result2 = new MatchFive().findFive(table2, 3);       
        assertThat(result2.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result2.getWinner(), equalTo(1));
        
        
        int[][] table3 = {  {0, 0, 0, 0, 1},
                            {0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result3 = new MatchFive().findFive(table3, 3);       
        assertThat(result3.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result3.getWinner(), equalTo(1));
    }  
    
      @Test
    public void testRightUpLeftDownGoodPosition() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result = new MatchFive().findFive(table, 3); 
        
        assertThat(result.getX1(), equalTo(1));
        assertThat(result.getY1(), equalTo(3));
        assertThat(result.getX2(), equalTo(3));
        assertThat(result.getY2(), equalTo(1));
    }

    @Test
    public void testFindUpDown() {
        int[][] table1 = {  {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0}};
        
        Result result1 = new MatchFive().findFive(table1, 3);
        
        assertThat(result1.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result1.getWinner(), equalTo(1));
        
        
        int[][] table2 = {  {0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result2 = new MatchFive().findFive(table2, 3);
        
        assertThat(result2.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result2.getWinner(), equalTo(1));
        
    }
    
    @Test
    public void testUpDownGoodPosition() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result = new MatchFive().findFive(table, 3);
    
        assertThat(result.getX1(), equalTo(1));
        assertThat(result.getY1(), equalTo(0));
        assertThat(result.getX2(), equalTo(3));
        assertThat(result.getY2(), equalTo(0));
    }
    
    @Test
    public void testFindLeftUpRightDown() {
        int[][] table1 = {  {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 1}};
        
        Result result1 = new MatchFive().findFive(table1, 3);
        
        assertThat(result1.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result1.getWinner(), equalTo(1));
        
        int[][] table2 = {  {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 1, 0, 0}};
        
        Result result2 = new MatchFive().findFive(table2, 3);
        
        assertThat(result2.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result2.getWinner(), equalTo(1));
        
    }      
    
    @Test
    public void testLeftUpRightDownGoodPosition() {
        int[][] table = {   {1, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result = new MatchFive().findFive(table, 3);    
  
        assertThat(result.getX1(), equalTo(0));
        assertThat(result.getY1(), equalTo(0));
        assertThat(result.getX2(), equalTo(2));
        assertThat(result.getY2(), equalTo(2));
    }
    
    @Test
    public void testFindRightLeft() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 1, 1, 1}};
        
        Result result = new MatchFive().findFive(table, 3);
        
        assertThat(result.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result.getWinner(), equalTo(1));
        
        
         int[][] table2 = { {1, 1, 1, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result2 = new MatchFive().findFive(table2, 3);
        
        assertThat(result2.getResultType(), equalTo(ResultType.FOUND));
        assertThat(result2.getWinner(), equalTo(1));
        
    }
    
    @Test
    public void testRightLeftGoodPosition() {
        int[][] table = {   {0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}};
        
        Result result = new MatchFive().findFive(table, 3);
        assertThat(result.getX1(), equalTo(1));
        assertThat(result.getY1(), equalTo(1));
        assertThat(result.getX2(), equalTo(1));
        assertThat(result.getY2(), equalTo(3));
    }   
}
