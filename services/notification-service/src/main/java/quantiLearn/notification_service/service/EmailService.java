package quantiLearn.notification_service.service;

import quantiLearn.notification_service.dto.EmailContentDto;

public interface EmailService {
    void sentEmail(EmailContentDto emailContentDto);
}
