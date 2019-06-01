package com.server.repository;

import com.server.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Long> {
    List<File> findByNameOrderByAddedDesc(String filename);

}
