package com.dhk.fileupload.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class ItemRequest {

    private String itemName;
    private Integer qty;
    private MultipartFile file;
}
