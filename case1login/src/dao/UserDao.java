package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

//class to maniuplate database user table
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    public User login(User loginUser){
        String sql = "select * from user where username = ? and password = ?";

        try {
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
