package com.osckorea.oscboardjdbcoriginal.dao;

import com.osckorea.oscboardjdbcoriginal.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    Optional<Board> findById(Long id);
    Optional<Board> findByName(String name);
    List<Board> findAll();

}
