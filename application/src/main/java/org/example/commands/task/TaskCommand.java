package org.example.commands.task;

import lombok.RequiredArgsConstructor;
import org.example.repository.task.TaskCommandRepository;
import org.example.entities.task.Task;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskCommand {
    private final TaskCommandRepository taskCommandRepository;
    public Task createTask(Task task) {
        return taskCommandRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskCommandRepository.save(task);
    }
}
