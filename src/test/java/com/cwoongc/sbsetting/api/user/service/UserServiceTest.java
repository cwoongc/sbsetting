package com.cwoongc.sbsetting.api.user.service;

import com.cwoongc.sbsetting.api.user.mapper.UserServiceTestMapper;
import com.cwoongc.sbsetting.api.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("local")
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserServiceTestMapper userServiceTestMapper;

    @Before
    public void before() {

    }

    @Test
    public void t010_getUser() {

        long id = 1234L;

        UserVO userVO = userService.getUser(id);

        assertNotNull(userVO);
        assertEquals("cwoongc", userVO.getName());
        assertEquals("01", userVO.getUserExampleCd());

    }

    @Test
    public void t020_insertUser() {

    }

    @Test
    public void t030_updateUser() {

    }

    @Test
    public void t040_deleteUser() {

    }

    @After
    public void after() {

    }


}
