package com.sans;

import com.sans.utils.IdGenerator;
import org.junit.jupiter.api.Test;

import java.util.UUID;

//@SpringBootTest
class ChengdaCommunityApplicationTests {

    @Test
    void contextLoads() {


    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long l = IdGenerator.nextId();
            System.out.println("userId => " + l);
        }
    }

}
