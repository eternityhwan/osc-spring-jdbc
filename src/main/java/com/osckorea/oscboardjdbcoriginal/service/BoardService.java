package com.osckorea.oscboardjdbcoriginal.service;

import com.osckorea.oscboardjdbcoriginal.dao.JdbcTemplateRepository;
import com.osckorea.oscboardjdbcoriginal.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final JdbcTemplateRepository jdbcTemplateRepository;

    public BoardService(JdbcTemplateRepository jdbcTemplateRepository) {
        this.jdbcTemplateRepository = jdbcTemplateRepository;
    }



    public Board CreateArticle(Board dto) {
        return null;
    }

    // FindAll Method
    public List<Board> listAllArticle() {
        return jdbcTemplateRepository.findAll();
    }
}
