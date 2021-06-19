package todo.project;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class TodoDto {

  public TodoDto(String contents, String userName){
    this.contents = contents;
    this.userName = userName;
  }

  private String contents;
  private String userName;
}
