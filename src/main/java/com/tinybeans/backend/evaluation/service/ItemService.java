package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.dto.ItemDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;

import java.util.List;

public interface ItemService {
    ResponseDTO<ItemDTO> addItem(ItemDTO itemDTO);
    ResponseDTO<List<ItemDTO>> getAllItems();
}
