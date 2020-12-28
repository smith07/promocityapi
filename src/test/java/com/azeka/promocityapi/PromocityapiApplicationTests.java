package com.azeka.promocityapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class PromocityapiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        String s1 = "1.10";
        String s2 = "99.35";
        System.out.println( Double.parseDouble(s2));
    }

}
