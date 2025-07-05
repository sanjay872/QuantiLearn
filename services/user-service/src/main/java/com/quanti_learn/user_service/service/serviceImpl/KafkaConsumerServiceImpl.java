package com.quanti_learn.user_service.service.serviceImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl {

    @KafkaListener(topics = "progress-update",groupId = "progress-group")
    public void updateUserProfile(){

    }
}
