package todo.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.transaction.Transactional;
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

    todoRepository.save(todo); //DB 저장
  }

  public List<TodoResDto> getTodoList() {
    List<Todo> todoList = todoRepository.findAll(); //DB 에서 투두 테이블에 있는 데이터 모두 조회
    List<TodoResDto> resultList = new ArrayList<>();

    System.out.println("db todo entity size : " + todoList.size());

    for(Todo todo : todoList){
      TodoResDto todoResDto = new TodoResDto(todo.getId(), todo.getContents(), todo.getIsDone());
      resultList.add(todoResDto);
    }

    return resultList;
  }

  public List<Todo> getUserTodoList(String userName){
    List<Todo> userTodoList = todoRepository.findByUserName(userName);

    return userTodoList;
  }

  @Transactional
  public Todo updateTodo(Long id, TodoUpdateReqDto todoUpdateReqDto) {
    Todo todo = todoRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);

    return todo.update(todoUpdateReqDto);
  }

  @Transactional
  public void deleteAllTodo() {
    todoRepository.deleteAll();
  }

  @Transactional
  public void deleteSingleTodo(Long id) {
    //TODO : id 값에 해당되는 투두 하나 삭제
    //todoRepository.deleteById(id);
    todoRepository.deleteSingleTodo(id);
  }
}
