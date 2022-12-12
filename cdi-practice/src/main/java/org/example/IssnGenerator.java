package org.example;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@ThirteenDigits
@Alternative
public class IssnGenerator implements NumberGenerator{
    @Override
    public String generateId() {
        String issn = "B-" + Math.abs(new Random().nextInt());
        return issn;
    }
}
