package com.example.chapter1;

import com.example.chapter1.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import javax.print.attribute.standard.Media;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {

        RequestBuilder request = null;

        //get
        request = MockMvcRequestBuilders.get("/users/");

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //post
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "lijie")
                .param("age", "20")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        //get
        request = MockMvcRequestBuilders.get("/users/").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"lijie\",\"age\":20}]")));

        //put
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "aaa")
                .param("age", "22")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        //get
        request = MockMvcRequestBuilders.get("/users/1")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"aaa\",\"age\":22}")));

        //delete
        request = MockMvcRequestBuilders.delete("/users/1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));


        //get
        request = MockMvcRequestBuilders.get("/users/")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
