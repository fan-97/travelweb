package com.qingda.dao;

import com.qingda.domain.Holiday;
import com.qingda.domain.Participation;
import com.qingda.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class HolidayDao {
    public int findTotalCount() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from t_holiday where 1=1 ";
        return template.queryForObject(sql,int.class);
    }

    public List<Holiday> findAllHolidayPage(int startIndex, int pageSize) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from t_holiday where 1=1 ";
        List list = new ArrayList();
        sql += "limit ?,? ";
        list.add(startIndex);
        list.add(pageSize);
        Object[] params = list.toArray();
        return template.query(sql,new BeanPropertyRowMapper<>(Holiday.class),params);
    }

    public Holiday findDetailholiday(String l_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //根据用户名和密码查询数据库
        String sql = "select * from t_holiday where l_id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Holiday.class),l_id);
    }

    public List<Holiday> findSomeHoliday(List<Participation> participationList) {
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < participationList.size(); i++) {
            ids.add(participationList.get(i).getP_hoildayid());
        }
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ids",ids);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        NamedParameterJdbcTemplate template =
          new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "select * from t_holiday where l_ID IN (:ids)";
        return template.query(sql,parameters,new BeanPropertyRowMapper<>(Holiday.class));
    }
}
