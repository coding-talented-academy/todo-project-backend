package todo.project;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {

  private final TodoRepository todoRepository;

  public void saveTodo(TodoDto todoDto) {
    Todo todo = new Todo(todoDto.getContents(), new Date(), todoDto.getUserName(), false);

    System.out.println("todo contents : " + todo.getContents());
    System.out.println("todo date : " + todo.getCreatedDate());
    System.out.println("todo userName : " + todo.getUserName());
    System.out.println("todo is done : " + todo.getIsDone());

    todoRepository.save(todo);
  }
}
