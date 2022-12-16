package com.osckorea.oscboardjdbcoriginal.controller;


import com.osckorea.oscboardjdbcoriginal.dao.BoardDao;
import com.osckorea.oscboardjdbcoriginal.domain.Board;
import com.osckorea.oscboardjdbcoriginal.service.BoardService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
@NoArgsConstructor
@Slf4j
public class BoardController {

    private BoardService boardService;



}
    // CREATE
//    @PostMapping("/posts")
//    public ResponseEntity<Board> addArticle(@RequestBody Board dto) {
//        Board newArticle = BoardService.createArticle(dto);
//        return (newArticle != null) ?
//            ResponseEntity.status(HttpStatus.OK).body(newArticle) :
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }

    // READ All
//    @GetMapping("")
//    public List<Board> findAllArticle() {
//        return boardService.listAllArticle();
//    }

    // READ BY ID


    // UPDATE


    // DELETE


