package com.tinybeans.backend.evaluation.service.impl;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.dto.ItemDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;
import com.tinybeans.backend.evaluation.exceptions.GenericException;
import com.tinybeans.backend.evaluation.exceptions.InvalidArgumentsException;
import com.tinybeans.backend.evaluation.repository.ItemRepository;
import com.tinybeans.backend.evaluation.service.ItemService;
import com.tinybeans.backend.evaluation.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public ResponseDTO<ItemDTO> addItem(ItemDTO itemDTO) {
        ResponseDTO<ItemDTO> responseDTO = new ResponseDTO<>();

        if(itemDTO == null) {
            throw new InvalidArgumentsException("itemDTO is null");
        }

        Item item = new Item();
        BeanUtils.copyProperties(itemDTO, item);

        Item savedItem = itemRepository.save(item);

        itemDTO.setId(savedItem.getId());
        responseDTO.setData(itemDTO);
        responseDTO.setStatusCode(Constants.STATUS_CREATED);
        return responseDTO;
    }

    @Override
    public ResponseDTO<List<ItemDTO>> getAllItems() {
        ResponseDTO<List<ItemDTO>> responseDTO = new ResponseDTO<>();
        try {
            List<Item> items = itemRepository.findAll();

            List<ItemDTO> itemDTOList = items.stream().map(item -> {
                ItemDTO itemDTO = new ItemDTO();
                BeanUtils.copyProperties(item, itemDTO);
                return itemDTO;
            }).collect(Collectors.toList());

            responseDTO.setData(itemDTOList);
            responseDTO.setStatusCode(Constants.STATUS_SUCCESS);
        } catch (Exception e) {
            throw new GenericException("Failed to get all items");
        }

        return responseDTO;
    }
}
