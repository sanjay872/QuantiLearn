package com.quanti_learn.user_service.dtoService.dtoServiceImpl;

import com.quanti_learn.user_service.dto.TopicDto;
import com.quanti_learn.user_service.mapper.TopicMapper;
import com.quanti_learn.user_service.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicDtoServiceImpl implements com.quanti_learn.user_service.dtoService.TopicDtoService {
    private final TopicMapper mapper;
    private final TopicService service;

    public TopicDtoServiceImpl(
        TopicMapper mapper,
        TopicService service
    ){
        this.mapper=mapper;
        this.service=service;
    }


    @Override
    public TopicDto createTopic(TopicDto topicDto) {
        return mapper.toDto(service.createTopic(mapper.fromDto(topicDto)));
    }

    @Override
    public TopicDto getTopic(Long id) {
        return mapper.toDto(service.getTopic(id));
    }

    @Override
    public List<TopicDto> getAllTopic() {
        return service.getAllTopic().stream().map(mapper::toDto).toList();
    }

    @Override
    public void updateTopic(TopicDto topicDto) {
        service.updateTopic(mapper.fromDto(topicDto));
    }

    @Override
    public void deleteTopic(Long id) {
        service.deleteTopic(id);
    }
}
