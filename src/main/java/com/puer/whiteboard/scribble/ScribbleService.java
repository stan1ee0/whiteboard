package com.puer.whiteboard.scribble;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScribbleService {
    private static final Map<Long, Scribble> repository = new HashMap<>();
    private static long sequence = 0;

    Scribble writeScribble(Scribble scribble) {
        long id = ++sequence;
        scribble.setId(id);
        scribble.setTime(LocalDateTime.now());
        repository.put(id, scribble);

        return scribble;
    }

    List<Scribble> findAllScribbles() {
        return new ArrayList<>(repository.values());
    }

    Scribble findScribble(long id) {
        if (repository.containsKey(id))
            return repository.get(id);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    void eraseScribble(long id) {
        if (repository.containsKey(id))
            repository.get(id).setErased(true);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    void recoverScribble(long id) {
        if (repository.containsKey(id))
            repository.get(id).setErased(false);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
