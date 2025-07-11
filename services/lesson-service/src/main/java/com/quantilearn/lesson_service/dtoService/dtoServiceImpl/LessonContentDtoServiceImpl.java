package com.quantilearn.lesson_service.dtoService.dtoServiceImpl;

import com.quantilearn.lesson_service.dto.LessonContentDto;
import com.quantilearn.lesson_service.dtoService.LessonContentDtoService;
import com.quantilearn.lesson_service.mapper.LessonContentMapper;
import com.quantilearn.lesson_service.service.LessonContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonContentDtoServiceImpl implements LessonContentDtoService {

    private final LessonContentService service;
    private final LessonContentMapper mapper;

    public LessonContentDtoServiceImpl(
            LessonContentService service,
            LessonContentMapper mapper
    ){
        this.service=service;
        this.mapper=mapper;
    }

    @Override
    public LessonContentDto createLessonContent(LessonContentDto lessonContent) {
        lessonContent.setId(null);
        return mapper.toDto(service.createLessonContent(mapper.fromDto(lessonContent)));
    }

    @Override
    public LessonContentDto getLessonContentById(Long id) {
        return mapper.toDto(service.getLessonContentById(id));
    }

    @Override
    public List<LessonContentDto> getLessonContentsByLessonId(Long id) {
        return service.getLessonContentsByLessonId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LessonContentDto updateLessonContent(LessonContentDto lessonContent) {
        return mapper.toDto(service.updateLessonContent(mapper.fromDto(lessonContent)));
    }

    @Override
    public void deleteLessonContent(Long id) {
        service.deleteLessonContent(id);
    }
}
