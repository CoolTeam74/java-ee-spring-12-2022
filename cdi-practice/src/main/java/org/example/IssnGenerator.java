package org.example;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@ThirteenDigits
public class IssnGenerator implements NumberGenerator{
    @Override
    public String generateId() {
        return "B-" + Math.abs(new Random().nextInt());
    }
}
