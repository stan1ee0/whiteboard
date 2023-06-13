package com.puer.whiteboard.scribble;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Scribble {
    private long id;
    private String content;
    private LocalDateTime time;
    private boolean erased;

    public Scribble(ScribbleDto scribbleDto) {
        this.content = scribbleDto.getContent();
    }
}
