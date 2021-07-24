package com.dhk.fileupload.repository;

import com.dhk.fileupload.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
