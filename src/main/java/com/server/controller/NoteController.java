package com.server.controller;

import com.server.exception.ResourceNotFoundException;
import com.server.model.Note;
import com.server.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @PostMapping()
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        return ResponseEntity.ok(repository.save(note));
    }

    @GetMapping()
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(repository.findAllByOrderByCreatedDesc());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable(value = "id") Long noteId) throws ResourceNotFoundException {
        Note note = repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found for this id :: " + noteId));
        repository.delete(note);
        return ResponseEntity.ok().build();
    }

}
