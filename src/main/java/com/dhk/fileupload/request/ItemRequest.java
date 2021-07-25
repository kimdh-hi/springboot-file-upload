package com.dhk.fileupload.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter @Setter
public class ItemRequest {

    @NotEmpty
    private String itemName;
    @NotNull
    @Range(min = 10, max=9999)
    private Integer qty;

//    @Null
    private MultipartFile file;
}
