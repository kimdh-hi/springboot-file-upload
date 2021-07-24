package com.dhk.fileupload.controller;

import com.dhk.fileupload.dto.FileDto;
import com.dhk.fileupload.dto.ItemDto;
import com.dhk.fileupload.request.ItemRequest;
import com.dhk.fileupload.service.FileService;
import com.dhk.fileupload.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ItemService itemService;
    private final FileService fileService;

    @Value("${image.path}")
    private String uploadDir;

    @GetMapping("/form")
    public String homeView(Model model) {
        model.addAttribute("item", new ItemRequest());
        return "home";
    }

    @PostMapping("/form")
    public String saveFormRequests(@ModelAttribute("item") ItemRequest itemRequest) throws IOException {
        String itemName = itemRequest.getItemName();
        Integer qty = itemRequest.getQty();
        ItemDto itemDto = ItemDto.builder().itemName(itemName).qty(qty).build();

        if (itemRequest.getFile() != null) {
            MultipartFile file = itemRequest.getFile();
            String fullPath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
            log.info("file.getOriginalFilename = {}", file.getOriginalFilename());
            log.info("fullPath = {}", fullPath);

            FileDto fileDto = FileDto.builder()
                    .originFileName(file.getOriginalFilename())
                    .fullPath(uploadDir + file.getOriginalFilename())
                    .build();
            Long savedFileId = fileService.save(fileDto);
            itemDto.setFileId(savedFileId);
        }
        itemService.save(itemDto);

        return "redirect:/form";
    }

//    @PostMapping("/form-log")
//    public String saveFormRequestsLog(
//            @ModelAttribute("item") ItemRequest itemRequest,
//            @ModelAttribute("file") FileRequest fileRequest) {
//        log.info("itemRequest.getItemName = {}", itemRequest.getItemName());
//        if (!fileRequest.getFile().isEmpty()) {
//            log.info("fileRequest.getFile = {}", fileRequest.getFile().getOriginalFilename());
//        }
//
//        return "home";
//    }
}