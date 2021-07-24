package com.dhk.fileupload.repository;

import com.dhk.fileupload.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
