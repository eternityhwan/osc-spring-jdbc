package com.osckorea.oscboardjdbcoriginal.dao;

import com.osckorea.oscboardjdbcoriginal.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateRepository implements BoardRepository {

    // 결과가 나오는 것을 rowMapper라는 것으로 매핑을 해줘야한다.
    static RowMapper<Board> boardRowMapper = ((rs, rowNum) ->
        Board.builder()
            .id(rs.getLong("id"))
            .title(rs.getString("title"))
            .contents(rs.getString("contents"))
            .build());

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // 생성자 하나면 오토와이어드 생략가능
    public JdbcTemplateRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Create
    @Override
    public Board save(Board board) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("board").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", board.getTitle());
        parameters.put("contents", board.getContents());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        board.setId(key.longValue());

        return board;
    }
    // READ ID
    @Override
    public Optional<Board> findById(Long id) {
        List<Board> result = jdbcTemplate.query("SELECT * FROM board WHERE id= ?", boardRowMapper);
        return result.stream().findAny();
    }
    // READ TITLE
    @Override
    public Optional<Board> findByName(String name) {
        List<Board> result = jdbcTemplate.query("SELECT * FROM board WHERE title =?", boardRowMapper);
        return result.stream().findAny();
    }

    @Override
    public List<Board> findAll() {
        return jdbcTemplate.query("SELECT * FROM board", boardRowMapper);
    }




}
