package org.example;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@FifteennDigits
public class IsbnGenerator implements NumberGenerator{
    @Override
    public String generateId() {
        return "13-84356-" + Math.abs(new Random().nextInt());
    }
}
