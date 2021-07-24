package com.dhk.fileupload.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id @GeneratedValue
    private Long id;

    private String itemName;

    private Integer quantity;

    @Column(nullable = true)
    private Long fileId;

    @Builder
    public Item(String itemName, Integer quantity, Long fileId) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.fileId = fileId;
    }
}
