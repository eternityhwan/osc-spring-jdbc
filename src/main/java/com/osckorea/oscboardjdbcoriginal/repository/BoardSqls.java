package com.osckorea.oscboardjdbcoriginal.repository;

public class BoardSqls {

    public static final String SELECT_BY_ID = """
        SELECT id, title, contents
        FROM board
            WHERE id = :id
        """;

}
