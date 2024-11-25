package org.study.design.patterns.structural.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class PartnerStoreCarFetcher {

    public static List<String> fetchCar(List<String> partnerStores, String car){
        log.info("Fetching partner stores ...");
        return Collections.singletonList(car);
    }
}
