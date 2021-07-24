package com.dhk.fileupload.service;

import com.dhk.fileupload.dto.ItemDto;
import com.dhk.fileupload.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemDto itemDto) {
        return itemRepository.save(itemDto.toEntity()).getId();
    }
}
