package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.dto.AnalyticsBuilderServiceTaskDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {


    @RabbitListener(queues = {"${rabbitmq.queue}"})
    public void consume(AnalyticsBuilderServiceTaskDto analyticsBuilderServiceTaskDto) {
        System.err.println("Consumer:consume dto = " + analyticsBuilderServiceTaskDto);


    }
}