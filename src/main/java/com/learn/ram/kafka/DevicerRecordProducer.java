package com.learn.ram.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.learn.ram.model.DeviceDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DevicerRecordProducer {

    @Value("${device.topic}")
    private String deviceTopic;
     
    @Autowired
    KafkaTemplate<Integer, DeviceDto> kafkaTemplate;
    
    public void send(DeviceDto device){
        log.info("Payload : {}", device.toString());
        this.kafkaTemplate.send(deviceTopic, device.getDeviceId(), device);
    }

}