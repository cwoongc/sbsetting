package com.cwoongc.sbsetting.api.user.controller;

//import com.cwoongc.sbsetting.SbsettingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@Slf4j
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("local")
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    private boolean refreshApplicationContext = true;

    private MediaType contentType = MediaType.APPLICATION_JSON_UTF8;

    private MediaType accept = MediaType.APPLICATION_JSON_UTF8;


    @Before
    public void before() throws Exception {
        if(mockMvc == null || refreshApplicationContext)
            this.mockMvc = webAppContextSetup(applicationContext).build();
    }

    @Test
    public void t010_getUser() throws Exception {
        Long id = 1234L;
        String expectResponseJson = "{\"id\":1234, \"name\":\"cwoongc\"}";

        mockMvc.perform(
                get("/user/" + id)
                .contentType(contentType)
                .accept(accept)
        ).andExpect(status().isOk()).andDo(print())
         .andExpect(content().json(expectResponseJson)).andDo(print())
         .andExpect(content().contentType(contentType)).andDo(print());
    }

    @Test
    public void t020_registerUser() throws Exception{

        String contentJson = "{\"id\":1234, \"name\":\"cwoongc\", \"userExampleCd\":\"01\"}";

        this.mockMvc.perform(
                post("/user")
                .contentType(contentType)
                .accept(accept)
                .content(contentJson)
        ).andExpect(status().isOk()).andDo(print())
         .andExpect(content().contentType(contentType));
    }

    @Test
    public void t030_updateUser() throws  Exception {

        String contentJson = "{\"id\":1234, \"name\":\"wcchoi\", \"userExampleCd\":\"02\"}";

        this.mockMvc.perform(
                put("/user")
                .contentType(contentType)
                .accept(accept)
                .content(contentJson)
        ).andExpect(status().isOk()).andDo(print())
         .andExpect(content().contentType(contentType));

    }

    @Test
    public void t040_deleteUser() throws  Exception {

        Long id = 1234L;

        this.mockMvc.perform(
                delete("/user/" + id)
                .contentType(contentType)
                .accept(accept)
        ).andExpect(status().isOk()).andDo(print())
        .andExpect(content().contentType(contentType)).andDo(print());
    }

    @After
    public void after() {

    }


}
