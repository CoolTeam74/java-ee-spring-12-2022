package org.example;

import javax.inject.Inject;

public class StringService {
    @Inject
    @Html
    private StringProvider stringProvider;

    public void loadString() {
        System.out.println(stringProvider.load());
    }
}
