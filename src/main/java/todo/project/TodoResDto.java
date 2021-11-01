package todo.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoResDto {
  private Long id;
  private String contents;
  private Boolean isDone;

  public TodoResDto(Long id, String contents, Boolean isDone){
    this.id = id;
    this.contents = contents;
    this.isDone = isDone;
  }
}
