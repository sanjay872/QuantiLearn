package quantiLearn.progress_service.service.serviceImpl;

import org.springframework.stereotype.Service;
import quantiLearn.progress_service.entity.UserProgression;
import quantiLearn.progress_service.exception.exceptions.CustomException;
import quantiLearn.progress_service.exception.exceptions.CustomNotFoundException;
import quantiLearn.progress_service.repository.UserProgressionRepository;
import quantiLearn.progress_service.service.UserProgressionService;

import java.util.List;
import java.util.Optional;

@Service
public class UserProgressionServiceImpl implements UserProgressionService {

    private final UserProgressionRepository repository;

    public UserProgressionServiceImpl(
            UserProgressionRepository repository
    ){
        this.repository=repository;
    }

    @Override
    public UserProgression createUserProgression(UserProgression userProgression) {
       return repository.save(userProgression);
    }

    @Override
    public UserProgression getById(Long id) {
        Optional<UserProgression> optionalUserProgression=repository.findById(id);
        if(optionalUserProgression.isPresent()){
            return optionalUserProgression.get();
        }
        throw new CustomNotFoundException("User Progression not found!");
    }

    @Override
    public List<UserProgression> getByUserId(String id) {
        return repository.findAllByUserId(id);
    }

    @Override
    public UserProgression updateUserProgression(UserProgression userProgression) {
        Optional<UserProgression> optionalUserProgression=repository.findById(userProgression.getId());
        if(optionalUserProgression.isPresent()){
            return repository.save(userProgression);
        }
        throw new CustomException("UserProgression update failed!");
    }

    @Override
    public void deleteUserProgressionById(Long id) {
        Optional<UserProgression> optionalUserProgression=repository.findById(id);
        if(optionalUserProgression.isPresent()){
            repository.delete(optionalUserProgression.get());
        }
        else{
            throw new CustomException("UserProgression delete failed!");
        }
    }

    @Override
    public void deleteUserProgressionByUserId(String id) {
        Optional<UserProgression> optionalUserProgression = repository.findByUserId(id);
        if (optionalUserProgression.isPresent()) {
            repository.deleteAllByUserId(id);
        } else {
            throw new CustomException("UserProgression delete failed!");
        }
    }
}
