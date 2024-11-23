package org.study.design.patterns.structural.composite.products;

import lombok.Data;
import org.study.design.patterns.structural.composite.Box;

@Data
public abstract class Product implements Box {

    protected final String title;
    protected final double price;

}
