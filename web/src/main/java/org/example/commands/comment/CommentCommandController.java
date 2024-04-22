package org.example.commands.comment;

import org.example.BaseController;
import org.example.commands.project.CreateProjectCommand;
import org.example.dtos.CommentDto;
import org.example.dtos.ProjectDto;
import org.example.mediator.Mediator;
import org.example.mediator.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentCommandController extends BaseController {
    public CommentCommandController(Mediator mediator) {
        super(mediator);
    }

    @PostMapping("/create")
    public ResponseEntity<DataResult<CommentDto>> createComment(@RequestBody CreateCommentCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<CommentDto>> updateComment(@RequestBody CreateCommentCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

}
