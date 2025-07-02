package com.quanti_learn.user_service.service;

import com.quanti_learn.user_service.dto.EmailContentDto;

public interface KafkaPublisher {
    void publishMessage(EmailContentDto dto);
}
