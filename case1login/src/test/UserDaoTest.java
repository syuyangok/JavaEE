package test;

import dao.User;
import dao.UserDao;

import org.junit.Test;




public class UserDaoTest {

    @Test
    public void testLogin(){

        User loginuser = new User();
        loginuser.setUsername("tom");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
