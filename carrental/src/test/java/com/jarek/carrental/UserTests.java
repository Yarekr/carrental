package com.jarek.carrental;

import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.UserType;
import com.jarek.carrental.dao.UserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTests {

    @Test
    public void testIfAdminIsInUserFactory() {
        //given:
        UserFactory userFacory = new UserFactory();
        String expectedUserName = "admin";
        // when
        User result = userFacory.getUserByType(UserType.ADMIN);
        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(expectedUserName, result.getUsername());

//		todo: test uprawnien -> sprawdzic czy admin ma uprawnienie "diagnose" i zadnych innych
    }

    @Test
    public void testIfNotExistingUserIsFine() {
        //given:
        UserFactory userFacory = new UserFactory();
        //when:
        User result = userFacory.getUserByType(UserType.SECRET_CUSTOMER);
        //then:
        Assert.assertNull(result);
    }

}

