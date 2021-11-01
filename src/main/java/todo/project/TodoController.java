package todo.project;

import io.swagger.annotations.Api;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "todo controller")
@RequiredArgsConstructor
@RestController
public class TodoController {

  private final TodoService todoService;

  @PostMapping(value = "/todos")
  public void saveTodo(@RequestBody TodoDto todoDto){
    todoService.saveTodo(todoDto);
  }

  @GetMapping(value = "/todos/users")
  public List<Todo> getUserTodoList(@RequestParam(value = "userName") String userName){
    return todoService.getUserTodoList(userName);
  }

  @GetMapping(value = "/todos")
  public List<TodoResDto> getTodoList(){
    return todoService.getTodoList();
  }

  //Update : /todos/{id} => 해당 id 의 todo수정
  //Delete : /todos => 모든 todo테이블의 데이터를 지우기
  //       : /todos/{id} => 해당 id의 todo삭제

  @PutMapping("/todos/{id}")
  public Todo updateTodo(@PathVariable("id") Long id, @RequestBody TodoUpdateReqDto todoUpdateReqDto){
    return todoService.updateTodo(id, todoUpdateReqDto);
  }

  //TODO : DELETE 전체 투두 데이터 삭제
  @DeleteMapping(value = "/todos")
  public void deleteAllTodo(){
    todoService.deleteAllTodo();
  }

  //TODO : DELETE 특정 id 값을 가진 투두 하나씩 삭제
  @DeleteMapping(value = "/todos/{id}")
  public void deleteSingleTodo(@PathVariable("id") Long id){
    todoService.deleteSingleTodo(id);
  }

}
