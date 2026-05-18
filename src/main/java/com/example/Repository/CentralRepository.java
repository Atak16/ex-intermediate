package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Central;
/**
 * 情報を処理するRepositoryクラス
 * 
 * @author Akihide Takakahashi
 */
@Repository
public class CentralRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Central> CENTRAL_ROW_MAPPER = (rs, i) -> {
        Central central = new Central();
        central.setId(rs.getInt("id"));
        central.setLeagueName(rs.getString("league_name"));
        central.setTeamName(rs.getString("team_name"));
        central.setHeadquarters(rs.getString("headquarters"));
        central.setInauguration(rs.getString("inauguration"));
        central.setHistory(rs.getString("history"));
        return central;
    };

    /**
     * 主キー検索
     * @param id
     */
    public Central load(Integer id) {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Central central = template.queryForObject(sql, param, CENTRAL_ROW_MAPPER);
        return central;
    }

    /**
     * 全件検索
     */
    public List<Central> findAll() {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration ASC";
        return template.query(sql, CENTRAL_ROW_MAPPER);
    }
}
