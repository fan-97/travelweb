package com.qingda.dao;

import com.qingda.domain.News;
import com.qingda.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    public int findTotalCount() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from n_newlist where 1=1 ";
        return template.queryForObject(sql,int.class);
    }

    public List<News> findAllNewsPage(int startIndex, int pageSize) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from n_newlist where 1=1 ";
        List list = new ArrayList();
        sql += "limit ?,? ";
        list.add(startIndex);
        list.add(pageSize);
        Object[] params = list.toArray();
        return template.query(sql,new BeanPropertyRowMapper<>(News.class),params);
    }

    public News findnewsById(String n_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM n_newlist WHERE n_ID = ? ";
        News news = template.queryForObject(sql, new BeanPropertyRowMapper<>(News.class), n_id);
        return news;
    }
}
