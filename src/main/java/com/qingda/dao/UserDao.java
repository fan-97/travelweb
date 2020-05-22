package com.qingda.dao;

import com.qingda.domain.User;
import com.qingda.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class UserDao {

    public void addprice(String id, double price) {
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "UPDATE t_user set u_price=? where u_ID=?";
            template.update(sql, price, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public User login(String name, String passWord) {
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "select * from t_user where u_Name = ? and u_Password = ? ";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name, passWord);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void edituser(User user) {
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "UPDATE t_user set  u_Name = ?,u_Sex=?,u_Birth=?,u_Location_prov=?,u_Location_city=?,u_Location_coun=?,u_DocumentType=?,u_IDNumber=?  where  u_ID = ?";
            template.update(sql, user.getU_Name(), user.getU_Sex(), user.getU_Birth(), user.getU_Location_prov(), user.getU_Location_city(), user.getU_Location_coun(), user.getU_DocumentType(), user.getU_IDNumber(), user.getU_ID());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public User getuserinfo(String userid) {
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            //根据用户名和密码查询数据库
            String sql = "select * from t_user where u_ID = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userid);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void register(User user) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object params[] = {
                UUID.randomUUID().toString(), user.getU_Name(), user.getU_Password(),
                user.getU_Sex(), user.getU_Birth(), user.getU_Location_prov(),
                user.getU_Location_city(), user.getU_Location_coun(), user.getU_DocumentType(),
                user.getU_IDNumber(), "会员",user.getU_price()
        };
        template.update(sql, params);
    }


}
