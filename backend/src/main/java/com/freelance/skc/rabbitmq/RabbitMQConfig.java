package com.freelance.skc.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {

//    @Value("${rabbitmq-config.queue.name}")
    private String queueName = "queueName";

//    @Value("${rabbitmq-config.exchange.name}")
    private String exchangeName = "exchangeName";

//    @Value("${rabbitmq-config.routing-key.name}")
    private String routingKey = "routingKey";

    // с какими сервисами взаимод - бизнес схема - кто произв и кто потребляет
    // если 4 разных евента для одного сервиса, то одна очередь
    // если для разных - то разные очереди
    // карточка клиента - менять пароли и прочее - все события вычитыв секурити сервисом -
    // очередь для важных событий (типо поменял пароль) и для прочего (типо галочки снял)
    // приортетные очереди.

    @Bean
//    @Qualifier("primary")
//    @Primary // если не указан qualifier, то этот по дефолту
    public Queue queueFirst(){
        return new Queue(queueName);
    }

//    @Bean
////    @Qualifier("second")
//    public Queue queueSecond(){
//        return new Queue(queueName);
//    }

    @Bean
//    @Qualifier("primary")
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queueFirst())
                .to(exchange())
                .with(routingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
//    @Qualifier("primary") // или Primary
    // это основной, также можно откопировать и вызвать другой queue
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }


}
