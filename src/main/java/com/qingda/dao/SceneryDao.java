package com.qingda.dao;

import com.qingda.domain.Scenery;
import com.qingda.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class SceneryDao {
    public int findTotalCount() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from t_scenery where 1=1 ";
        return template.queryForObject(sql,int.class);
    }

    public List<Scenery> findAllNewsPage(int startIndex, int pageSize) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from t_scenery where 1=1 ";
        List list = new ArrayList();
        sql += "limit ?,? ";
        list.add(startIndex);
        list.add(pageSize);
        Object[] params = list.toArray();
        return template.query(sql,new BeanPropertyRowMapper<>(Scenery.class),params);
    }

    public Scenery findSceneryById(String c_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM t_scenery WHERE c_ID = ? ";
        Scenery scenery = template.queryForObject(sql, new BeanPropertyRowMapper<>(Scenery.class), c_id);
        return scenery;
    }

    public int findTotalCountByName(String rname) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from t_scenery where c_Name LIKE ? ";
        return template.queryForObject(sql,int.class,"%"+rname+"%");
    }


    public List<Scenery> findByNamePage(int startIndex, int pageSize, String rname) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from t_scenery where c_Name LIKE ? ";
        List list = new ArrayList();
        sql += "limit ?,? ";
        list.add("%"+rname+"%");
        list.add(startIndex);
        list.add(pageSize);
        Object[] params = list.toArray();
        return template.query(sql,new BeanPropertyRowMapper<>(Scenery.class),params);
    }
}
