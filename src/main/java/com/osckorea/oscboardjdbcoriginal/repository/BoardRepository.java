package com.osckorea.oscboardjdbcoriginal.repository;


import com.osckorea.oscboardjdbcoriginal.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    private SimpleJdbcInsertOperations simpleJdbcInsertOperations;

    private RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    @Autowired
    public BoardRepository(DataSource dataSource) {
        this.namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsertOperations = new SimpleJdbcInsert(dataSource)
            .withTableName("board")
            .usingGeneratedKeyColumns("id");
    }

    // Create
    public Long create(Board board) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return simpleJdbcInsertOperations.executeAndReturnKey(params).longValue();
    }

    public Board findById(Long id) {
        Map<String, Long> params = Collections.singletonMap("id",id);
        return namedParameterJdbcOperations.queryForObject(BoardSqls.SELECT_BY_ID,params,boardRowMapper);
    }

    public List<Board> findByIdList(List<Long> idList) {

    }


}
