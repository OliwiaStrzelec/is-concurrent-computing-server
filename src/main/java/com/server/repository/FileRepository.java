package com.server.repository;

import com.server.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<Files,Long> {
    List<Files> findDistinctByFil(String filename);

}
