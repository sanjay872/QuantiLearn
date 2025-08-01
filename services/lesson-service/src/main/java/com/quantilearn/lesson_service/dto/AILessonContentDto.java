package com.quantilearn.lesson_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AILessonContentDto {
    private String title;
    private int orderNumber;
    private String description;
}
