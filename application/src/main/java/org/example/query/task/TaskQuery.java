package org.example.query.task;

import lombok.RequiredArgsConstructor;
import org.example.repository.task.TaskQueryReposiroty;
import org.example.entities.task.Task;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskQuery {
    private final TaskQueryReposiroty taskQueryReposiroty;

    public List<Task> getAllTasks() {
        return taskQueryReposiroty.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Task getTask(UUID id) {
        return taskQueryReposiroty.findById(id).orElse(null);
    }

    public List<Task> findAllByUsersId(UUID id){
        return taskQueryReposiroty.findAllByUsersId(id);
    }

    public List<Task> findAllByProjectId(UUID id) {
        return taskQueryReposiroty.findAllByProjectId(id);
    }

    public List<Task> findAllByProjectIdAndUsersId(UUID projectId, UUID userId) {
        return taskQueryReposiroty.findAllByProjectIdAndUsersId(projectId,userId);
    }



}
