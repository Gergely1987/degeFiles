package genericinterface;

public interface SearchCriteria <T extends Item > {
    boolean pass(T target);
}
