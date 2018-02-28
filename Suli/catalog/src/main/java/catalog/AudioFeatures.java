package catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AudioFeatures implements Feature{
    private List<String> composer = new ArrayList<>();
    private int length;
    private List<String> performers = new ArrayList<>();
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if(length < 0){
            throw new IllegalArgumentException("Empty title");
        }
        if(performers.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(title == null || "".equals(title)){
            throw new IllegalArgumentException("Empty title");
        }
        this.performers = performers;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if(length < 0){
            throw new IllegalArgumentException("Empty title");
        }
        if(performers.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(title == null || "".equals(title)){
            throw new IllegalArgumentException("Empty title");
        }
        this.composer = composer;
        this.performers = performers;
        this.length = length;
        this.title = title;
    }

    public List<String> getComposer() {
        List<String> result = new ArrayList<>(composer.size());
        Collections.copy(result, composer);
        return result;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPerformers() {
        List<String> result = new ArrayList<>(performers.size());
        Collections.copy(result, performers);
        return result;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        if(!composer.isEmpty()){
            for (String string: composer) {
                result.add(string);
            }
        }
        if(!performers.isEmpty()){
            for (String string: performers) {
                result.add(string);
            }
        }
        return result;
    }
}