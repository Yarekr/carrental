package com.jarek.carrental;

import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.UserType;
import com.jarek.carrental.dao.UserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The type User tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTests {

    /**
     * Test if admin is in user factory.
     */
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

    }

    /**
     * Test if not existing user is fine.
     */
    @Test
    public void testIfNotExistingUserIsFine() {
        //given:
        UserFactory userFactory = new UserFactory();
        //when:
        User result = userFactory.getUserByType(UserType.SECRET_CUSTOMER);
        //then:
        Assert.assertNull(result);
    }

    /**
     * Test if user is in user factory.
     */
    @Test
    public void testIfUserIsInUserFactory() {
        //given:
        UserFactory userFacory = new UserFactory();
        String expectedUserName = "Tomasz";
        // when
        User result = userFacory.getUserByType(UserType.CUSTOMER);
        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(expectedUserName, result.getUsername());

    }


}

