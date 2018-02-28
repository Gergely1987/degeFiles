package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{

    private String title;
    private List<String> authList;
    private int numberOfPages;



    PrintedFeatures(String title,int numberOfPages, List<String> authList){
        if (title==null||title.isEmpty()){
            throw new IllegalArgumentException("Empty title");
        }
        this.title=title;
        if (numberOfPages<0){
            throw new IllegalArgumentException();
        }
        this.numberOfPages=numberOfPages;
        if (authList==null||authList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.authList=authList;


    }


    @Override
    public List<String> getContributors() {
        return authList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}