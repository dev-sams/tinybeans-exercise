package com.tinybeans.backend.evaluation.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.tinybeans.backend.evaluation.dto.OrderRequestDTO;
import com.tinybeans.backend.evaluation.dto.PaymentResponseDTO;
import com.tinybeans.backend.evaluation.exceptions.GenericException;
import com.tinybeans.backend.evaluation.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    @Override
    public PaymentResponseDTO createPayment(OrderRequestDTO orderRequestDTO) {
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

        Stripe.apiKey = stripeSecretKey;
        try{
            SessionCreateParams params = SessionCreateParams.builder()
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("http://localhost:3000/payment/success")
                    .setCancelUrl("http://localhost:3000/payment/cancel")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("usd")
                                                    .setUnitAmount((long)orderRequestDTO.getTotalAmount() * 100)
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName("Tinybeans Shop")
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();

            Session session = Session.create(params);
            paymentResponseDTO.setPaymentUrl(session.getUrl());
            paymentResponseDTO.setPaymentId(session.getId());
            paymentResponseDTO.setPaymentStatus(session.getPaymentStatus());
        } catch (StripeException exception){
            throw new GenericException("Payment Failed!");
        }

        return paymentResponseDTO;
    }
}
