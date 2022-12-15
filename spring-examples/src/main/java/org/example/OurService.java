package org.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class OurService {
    @SelfInject
    private OurService ourService;

    public void doSomething() {
        ourService.doSomething2();
    }

    public void doSomething2() {
    }
}
