package org.study.design.patterns.structural.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LocalPartnerStoreSearch {

    public static List<String> localPartnerStoreSearch(String region) {
        log.info("Local partner store search");
        return new ArrayList<>();
    }
}
