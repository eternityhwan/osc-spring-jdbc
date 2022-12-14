package com.osckorea.oscboardjdbcoriginal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Builder
@Getter // 접근자
@Setter // 설정자
@ToString // 변수값을 리턴해주는 메소드
public class Board {
    private Long id;
    private String title;
    private String contents;
}
