package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.dto.ItemDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;
import com.tinybeans.backend.evaluation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseDTO<List<ItemDTO>> getAllItems() {
        return itemService.getAllItems();
    }
}
