package com.dhk.fileupload.dto;

import com.dhk.fileupload.domain.Item;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemDto {

    private String itemName;
    private Integer qty;
    private Long fileId;

    public Item toEntity() {
        return Item.builder()
                .itemName(this.itemName)
                .quantity(this.qty)
                .fileId(this.fileId)
                .build();
    }

    @Builder
    public ItemDto(String itemName, Integer qty, Long fileId) {
        this.itemName = itemName;
        this.qty = qty;
        this.fileId = fileId;
    }
}
