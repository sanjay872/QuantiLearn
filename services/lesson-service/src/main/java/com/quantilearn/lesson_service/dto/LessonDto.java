package com.quantilearn.lesson_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    private Long id;
    private String title;
    private String authorId;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isPublic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<LessonContentDto> contents;
}
