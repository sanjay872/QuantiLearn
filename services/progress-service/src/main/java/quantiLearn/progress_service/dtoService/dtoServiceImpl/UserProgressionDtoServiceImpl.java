package quantiLearn.progress_service.dtoService.dtoServiceImpl;

import org.springframework.stereotype.Service;
import quantiLearn.progress_service.dto.UserProgressionDto;
import quantiLearn.progress_service.dtoService.UserProgressionDtoService;
import quantiLearn.progress_service.mapper.UserProgressionMapper;
import quantiLearn.progress_service.service.UserProgressionService;

import java.util.List;

@Service
public class UserProgressionDtoServiceImpl implements UserProgressionDtoService {

    private final UserProgressionMapper mapper;
    private final UserProgressionService service;

    public UserProgressionDtoServiceImpl(
            UserProgressionMapper mapper,
            UserProgressionService service
    )
    {
        this.mapper=mapper;
        this.service=service;
    }

    @Override
    public Long createUserProgression(UserProgressionDto userProgression) {
        return this.service.createUserProgression(mapper.fromDto(userProgression)).getId();
    }

    @Override
    public UserProgressionDto getById(Long id) {
        return mapper.toDto(service.getById(id));
    }

    @Override
    public List<UserProgressionDto> getByUserId(String id) {
        return service.getByUserId(id).stream().map(mapper::toDto).toList();
    }

    @Override
    public UserProgressionDto updateUserProgression(UserProgressionDto userProgression) {
        return mapper.toDto(service.updateUserProgression(mapper.fromDto(userProgression)));
    }

    @Override
    public void deleteUserProgressionById(Long id) {
        service.deleteUserProgressionById(id);
    }

    @Override
    public void deleteUserProgressionByUserId(String id) {
        service.deleteUserProgressionByUserId(id);
    }
}
