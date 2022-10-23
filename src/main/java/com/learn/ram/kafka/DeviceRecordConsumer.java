package com.learn.ram.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.learn.ram.model.DeviceDto;

@Component
public class DeviceRecordConsumer {
    
    
    @KafkaListener(topics = "device_record", groupId = "device", containerFactory = "deviceListener")

    public void consume(DeviceDto message) {
        // Print statement
        System.out.println("message = " + message);
    }
}
