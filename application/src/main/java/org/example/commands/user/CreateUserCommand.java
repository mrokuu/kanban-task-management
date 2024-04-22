package org.example.commands.user;

import org.example.commands.task.CreateTaskCommandHandler;
import org.example.entities.project.Project;
import org.example.entities.task.Task;
import org.example.mediator.Handler;
import org.example.mediator.Request;
import org.example.valueobjects.Email;
import org.example.valueobjects.Name;
import org.example.valueobjects.Password;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


@Handler(handler = CreateUserCommandHandler.class)
public record CreateUserCommand(
        UUID id,
        Email email,
        Name name,
        Password password,
        LocalDate registrationDate,
        Set<Project> projects,
        Set<Task> tasks
) implements Request {
}
