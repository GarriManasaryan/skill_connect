package com.freelance.skc.application.rabbit;

import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationCreationRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private String exchangeName = "exchangeName";

    private String routingKey = "routingKey";

    private final RabbitTemplate rabbitTemplate;

    // запрос кокнретноого бина
//    public RabbitMQProducer(@Qualifier("primary") RabbitTemplate rabbitTemplate) {
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderApplication(OrderApplicationCreationRequest orderApplicationCreationRequest) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderApplicationCreationRequest);
    }


}
