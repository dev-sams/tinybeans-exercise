package com.tinybeans.backend.evaluation.service.impl;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.data.entity.Orders;
import com.tinybeans.backend.evaluation.dto.OrderRequestDTO;
import com.tinybeans.backend.evaluation.dto.OrderResponseDTO;
import com.tinybeans.backend.evaluation.dto.PaymentResponseDTO;
import com.tinybeans.backend.evaluation.dto.ResponseDTO;
import com.tinybeans.backend.evaluation.exceptions.BadRequestException;
import com.tinybeans.backend.evaluation.exceptions.ResourceNotFoundException;
import com.tinybeans.backend.evaluation.repository.ItemRepository;
import com.tinybeans.backend.evaluation.repository.OrdersRepository;
import com.tinybeans.backend.evaluation.service.OrderService;
import com.tinybeans.backend.evaluation.service.PaymentService;
import com.tinybeans.backend.evaluation.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final PaymentService paymentService;
    private final ItemRepository itemRepository;
    private final OrdersRepository ordersRepository;

    @Override
    @Transactional
    public ResponseDTO<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO) {
        if(orderRequestDTO.getItems() == null ||
                orderRequestDTO.getItems().isEmpty() ||
                orderRequestDTO.getTotalAmount() == 0){
            throw new BadRequestException("Invalid order request");
        }

        PaymentResponseDTO paymentResponseDTO = paymentService.createPayment(orderRequestDTO);

        Orders orders = new Orders();
        List<Item> itemList = new ArrayList<>();

        orderRequestDTO.getItems().forEach(itemDTO -> {
            Item item = itemRepository.findById(itemDTO.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item Does not Exist!"));
            for (int i = 0; i < itemDTO.getQuantity(); i++) {
                itemList.add(item);
            }
        });

        orders.setItems(itemList);
        // Considering 0 discount
        orders.setDiscount(BigDecimal.ZERO);
        orders.setSubTotal(BigDecimal.valueOf(orderRequestDTO.getTotalAmount()));
        orders.setFinalPrice(BigDecimal.valueOf(orderRequestDTO.getTotalAmount()));
        orders.setPaymentId(paymentResponseDTO.getPaymentId());

        Orders savedOrder = ordersRepository.save(orders);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderId(savedOrder.getId());
        orderResponseDTO.setOrderPayment(paymentResponseDTO);

        ResponseDTO<OrderResponseDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setStatusCode(Constants.STATUS_SUCCESS);
        responseDTO.setData(orderResponseDTO);
        return responseDTO;
    }
}
