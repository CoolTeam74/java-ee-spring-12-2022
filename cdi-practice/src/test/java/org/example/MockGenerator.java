package org.example;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Override
    public String generateId() {
        return  "MOCK-" + Math.abs(new Random().nextInt());
    }
}
