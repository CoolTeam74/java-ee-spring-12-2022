package org.example;

import javax.enterprise.inject.Alternative;

@Alternative
public class FileStringProvider implements StringProvider{
    @Override
    public String load() {
        return "Load string from file";
    }
}
