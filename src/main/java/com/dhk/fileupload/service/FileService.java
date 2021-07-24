package com.dhk.fileupload.service;

import com.dhk.fileupload.domain.File;
import com.dhk.fileupload.dto.FileDto;
import com.dhk.fileupload.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public Long save(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

}
