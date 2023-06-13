package com.puer.whiteboard.scribble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scribbles")
public class ScribbleController {
    private final ScribbleService service;

    @Autowired
    public ScribbleController(ScribbleService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Scribble postScribble(@RequestBody ScribbleDto scribbleDto) {
        return service.writeScribble(new Scribble(scribbleDto));
    }

    @GetMapping
    public List<Scribble> getScribbles() {
        return service.findAllScribbles();
    }

    @GetMapping("/{id}")
    public Scribble getScribble(@PathVariable long id) {
        return service.findScribble(id);
    }

    @DeleteMapping("/{id}")
    public void deleteScribble(@PathVariable long id) {
        service.eraseScribble(id);
    }

    @PutMapping("/{id}")
    public void putScribble(@PathVariable long id) {
        service.recoverScribble(id);
    }
}
