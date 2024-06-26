package org.example.commands.task;

import lombok.RequiredArgsConstructor;
import org.example.dtos.TaskDto;
import org.example.entities.task.Task;
import org.example.dispacher.RequestHandler;
import org.example.dispacher.response.DataResult;
import org.example.dispacher.response.SuccessDataResult;
import org.example.repository.task.TaskCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskCommandHandler implements RequestHandler<CreateTaskCommand, DataResult<TaskDto>> {

    private final TaskCommandRepository taskCommandRepository;
    @Override
    public DataResult<TaskDto> handle(CreateTaskCommand command) {

        Task task = taskCommandRepository.save(mapToCreateTask(command));
        return new SuccessDataResult<>(maptoTaskDto(task), "Task has been created!!!");
    }

    private TaskDto maptoTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .name(task.getName())
                .priority(task.getPriority())
                .progress(task.getProgress())
                .project(task.getProject())
                .users(task.getUsers())
                .users(task.getUsers())
                .build();
    }

    private Task mapToCreateTask(CreateTaskCommand command) {
        return Task.builder()
                .id(command.id())
                .description(command.description())
                .name(command.name())
                .priority(command.priority())
                .users(command.users())
                .progress(command.progress())
                .project(command.project())
                .build();
    }
}
