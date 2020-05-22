package com.qingda.dao;

import com.qingda.domain.Participation;
import com.qingda.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class ParticipationDao {
    public List<Participation> findparticipationByName(String username) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM t_participation WHERE p_nameid = ? ";
        List<Participation> list = template.query(sql,new BeanPropertyRowMapper<>(Participation.class),username);
        return list;
    }

    public void join(String l_theme, String u_name) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into t_participation values(?,?,?) ";
        template.update(sql,UUID.randomUUID().toString(),u_name,l_theme);
    }

    public void canceParticipation(String l_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "DELETE FROM t_participation WHERE p_hoildayid = ?";
        template.update(sql,l_id);
    }
}
