package com.qingda.dao;

import com.qingda.domain.Participation;
import com.qingda.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class ParticipationDao {
    public List<Participation> findparticipationByName(String username) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM t_participation WHERE p_nameid = ? ";
        List<Participation> list = template.query(sql, new BeanPropertyRowMapper<>(Participation.class), username);
        return list;
    }

    public Participation insert(Participation participation) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into t_participation values(?,?,?,?,?) ";
        String id = UUID.randomUUID().toString();
        template.update(sql, id, participation.getP_nameid(), participation.getP_hoildayid(), participation.getFlag(), participation.getPrice());
        participation.setP_id(id);
        return participation;
    }

    public void delete(String p_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "DELETE FROM t_participation WHERE p_id = ?";
        template.update(sql, p_id);
    }

    public Participation findById(String id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM t_participation WHERE p_id = ? ";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Participation.class), id);
    }

    public void update(Participation participation) {
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "UPDATE t_participation set p_nameid=?,p_hoildayid=?,flag =?,price=? where p_id=?";
            template.update(sql, participation.getP_nameid(), participation.getP_hoildayid(), participation.getFlag(), participation.getPrice(), participation.getP_id());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
