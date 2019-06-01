package com.server.controller;

import com.server.model.File;
import com.server.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileRepository repository;

    @PostMapping()
    public ResponseEntity<File> addFile(@Valid @RequestBody File file) {
        return ResponseEntity.ok(repository.save(file));
    }

    @GetMapping("/{filename}")
    public ResponseEntity<List<File>> getAllFilesByName(@PathVariable(value = "filename") String filename) {
        return ResponseEntity.ok(repository.findByNameOrderByAddedDesc(filename));
    }

    @GetMapping()
    public ResponseEntity<List<File>> getAllFiles() {
        return ResponseEntity.ok(repository.findAll());
    }


}
