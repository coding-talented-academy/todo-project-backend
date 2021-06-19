package todo.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TodoController {

  private final TodoService todoService;

  @PostMapping(value = "/todos")
  public void saveTodo(@RequestBody TodoDto todoDto){
    todoService.saveTodo(todoDto);
  }
}
