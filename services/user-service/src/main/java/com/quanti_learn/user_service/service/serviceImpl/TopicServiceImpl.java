package com.quanti_learn.user_service.service.serviceImpl;

import com.quanti_learn.user_service.entity.Topic;
import com.quanti_learn.user_service.exception.exceptions.CustomNotFoundException;
import com.quanti_learn.user_service.repository.TopicRepository;
import com.quanti_learn.user_service.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;

    public TopicServiceImpl(
        TopicRepository repository
    ){
        this.repository=repository;
    }

    @Override
    public Topic createTopic(Topic topic) {
        return repository.save(topic);
    }

    @Override
    public Topic getTopic(Long id) {
        Optional<Topic> topicOptional=repository.findById(id);
        if(topicOptional.isPresent()){
            return topicOptional.get();
        }
        throw new CustomNotFoundException("Topic not found!");
    }

    @Override
    public List<Topic> getAllTopic() {
        return repository.findAll();
    }

    @Override
    public void updateTopic(Topic topic) {
        Optional<Topic> topicOptional=repository.findById(topic.getId());
        if(topicOptional.isPresent()){
            Topic existTopic=topicOptional.get();
            existTopic.setName(topic.getName());
            repository.save(existTopic);
        }
        else{
            throw new CustomNotFoundException("Topic not found!");
        }
    }

    @Override
    public void deleteTopic(Long id) {
        Optional<Topic> topicOptional=repository.findById(id);
        if(topicOptional.isPresent()){
            repository.delete(topicOptional.get());
        }
        else{
            throw new CustomNotFoundException("Topic not found!");
        }
    }
}
