package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    private List<Feature> features = new ArrayList<>();
    private int price;
    private String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.price = price;
        this.registrationNumber = registrationNumber;
        for (Feature feature: features) {
            this.features.add(feature);
        }
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int fullLengthAtOneItem(){
        int result = 0;
        for (Feature feature: features) {
            if(feature instanceof AudioFeatures){
                result += ((AudioFeatures) feature).getLength();
            }
        }
        return result;
    }

    public int numberOfPagesAtOneItem(){
        int result = 0;
        for (Feature feature: features) {
            if(feature instanceof PrintedFeatures){
                result += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return result;
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        for (Feature feature: features) {
//            result.add(feature.getContributors().toString());
            for (String string: feature.getContributors()) {
                result.add(string);
            }
        }
        return result;
    }

    public List<String> getTitles(){
        List<String> result = new ArrayList<>();
        for (Feature feature: features) {
            result.add(feature.getTitle());
        }
        return result;
    }

    public boolean hasAudioFeature(){
        boolean result = false;
        for (Feature feature: features) {
            if(feature instanceof AudioFeatures){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean hasPrintedFeature(){
        boolean result = false;
        for (Feature feature: features) {
            if(feature instanceof PrintedFeatures){
                result = true;
                break;
            }
        }
        return result;
    }
}