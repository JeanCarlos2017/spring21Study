package org.study.design.patterns.structural.facade;

import java.util.List;

public class CarRentalService {
    private PartnerStoreCarFetcher partnerStoreCarFetcher;

    public String carRental(String region, String car){
        List<String> carStores= LocalPartnerStoreSearch.localPartnerStoreSearch(region);
        List<String> fetchedCar= PartnerStoreCarFetcher.fetchCar(carStores, car);
        return fetchedCar.getFirst();
    }
}
