package org.example;

import org.example.OurService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainIT {
    @Autowired
    private OurService ourService;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testOurService() {
        Assertions.assertNotNull(ourService.getOurService());
    }

    @Test
    public void testEmployeeDao(){
        Assertions.assertEquals("mock employee fired", employeeDao.fireEmployee());
    }

}
