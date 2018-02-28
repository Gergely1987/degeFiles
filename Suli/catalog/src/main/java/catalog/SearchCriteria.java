package catalog;

public final class SearchCriteria {

    public String contributor;
    public String title;

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (contributor == null || contributor.isEmpty()) {
            throw new IllegalArgumentException("");
        } else if  (title == null || title.isEmpty()){
            throw new IllegalArgumentException("");
        }
        return new SearchCriteria(title,contributor);

    }



    public static SearchCriteria createByContributor(String contributor) {
        if (contributor == null || contributor.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        return new SearchCriteria(title, null);

    }

    public boolean hasContributor() {
        if (contributor == null || contributor.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean hasTitle() {
        if (title == null || title.isEmpty()) {
            return false;
        }
        return true;
    }

    private SearchCriteria( String title,String contributor) {
        this.title = title;
        this.contributor = contributor;
    }
}
