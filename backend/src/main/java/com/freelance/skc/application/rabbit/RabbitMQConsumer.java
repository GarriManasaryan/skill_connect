//package com.freelance.skc.application;
//
//import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationCreationRequest;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitMQConsumer {
//
//    @RabbitListener(queues = {"queueName"})
//    public void consumeOrderApplication(OrderApplicationCreationRequest orderApplicationCreationRequest){
//        System.out.println("\n\n\n\nAAAAA\n\n\n\n");
//        System.out.println(orderApplicationCreationRequest);
//        System.out.println("\n\n\n\nAAAAA\n\n\n\n");
//    }
//
//}
