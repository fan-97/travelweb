package com.qingda.dao;

import com.qingda.domain.Favorite;
import com.qingda.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author
 * @date 2020/5/22 22:03
 */
public class FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Favorite> getList(String u_id) {
        String sql = "select * from tb_favorite where u_id = ? ";
        try {
            List<Favorite> list = template.query(sql, new BeanPropertyRowMapper<>(Favorite.class), u_id);
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public int insert(Favorite favorite) {
        String sql = "insert into tb_favorite values(?,?,?)";
        return template.update(sql, UUID.randomUUID().toString(), favorite.getU_id(), favorite.getL_id());
    }

    public int delete(String l_id,String u_id) {
        String sql = "delete from tb_favorite where l_id = ? and u_id=?";
        return template.update(sql, l_id,u_id);
    }

    public Favorite select(String l_id,String u_id) {
        String sql = "select * from tb_favorite where l_id = ? and u_id = ?";
        try {
            Favorite favorite = template.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), l_id,u_id);
            return favorite;
        } catch (Exception e) {
            return null;
        }
    }
}
