package com.example.chapter1;

import com.example.chapter1.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTests {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {

        userService.create("a", 11);
        userService.create("b", 12);
        userService.create("c", 13);
        userService.create("d", 14);

        Assert.assertEquals(4, userService.getAllUsers().intValue());


        userService.deleteByName("a");
        userService.deleteByName("b");

        Assert.assertEquals(2, userService.getAllUsers().intValue());
    }
}
