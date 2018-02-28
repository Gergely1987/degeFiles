package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();


    void addItem(CatalogItem cti) {
        catalogItems.add(cti);
    }

    double averagePageNumberOver(int number) {
        int result = 0;
        int counter = 0;
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                if (feature instanceof PrintedFeatures) {
                    if (((PrintedFeatures) feature).getNumberOfPages() > number) {
                        counter++;
                        result += ((PrintedFeatures) feature).getNumberOfPages();
                    }

                }
            }
        }

        return result / counter;


    }

    void deleteItemByRegistrationNumber(String regNum) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber() == regNum) {
                catalogItems.remove(catalogItems.get(i));
            }
        }
    }

    List<CatalogItem> findByCriteria(SearchCriteria sc) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                String s = sc.getTitle();
                if (sc.getContributor()!=null&&feature.getContributors().toString().contains(sc.getContributor())) {
                    result.add(catalogItem);
                } else if (sc.getTitle()!=null&&feature.getTitle().equals(sc.getTitle())) {
                    result.add(catalogItem);
                }


            }

        }

        return result;

    }

    int getAllPageNumber() {

        int result = 0;
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                if (feature instanceof PrintedFeatures) {
                    result += ((PrintedFeatures) feature).getNumberOfPages();

                }
            }
        }

        return result;
    }

    List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                if (feature instanceof AudioFeatures) {
                    result.add(catalogItem);
                    break;
                }
            }
        }

        return result;


    }

    int getFullLength() {
        int result = 0;
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                if (feature instanceof AudioFeatures) {
                    result += ((AudioFeatures) feature).getLength();

                }
            }
        }

        return result;

    }

    List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            List<Feature> features = catalogItem.getFeatures();
            for (Feature feature : features) {
                if (feature instanceof PrintedFeatures) {
                    result.add(catalogItem);
                }
            }
        }

        return result;

    }

}