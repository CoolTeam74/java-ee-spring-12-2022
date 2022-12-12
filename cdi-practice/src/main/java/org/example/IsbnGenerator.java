package org.example;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@FifteennDigits
@Alternative
public class IsbnGenerator implements NumberGenerator{
    @Override
    public String generateId() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        return isbn;
    }
}
