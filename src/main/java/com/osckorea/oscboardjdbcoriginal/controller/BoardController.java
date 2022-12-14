package com.osckorea.oscboardjdbcoriginal.controller;


import com.osckorea.oscboardjdbcoriginal.domain.Board;
import com.osckorea.oscboardjdbcoriginal.service.BoardService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
@NoArgsConstructor
public class BoardController {

    private BoardService boardService;

    // CREATE
    @PostMapping("/posts")
    public ResponseEntity<Board> addArticle(@RequestBody Board dto) {
        Board newArticle = boardService.CreateArticle(dto);
        return (newArticle != null) ?
            ResponseEntity.status(HttpStatus.OK).body(newArticle) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // READ All
    @GetMapping("")
    public List<Board> findAllArticle() {
        return boardService.listAllArticle();
    }

}
