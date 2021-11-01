package todo.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter // 멤버변수들에 접근할 수 있는 getter 를 만들어준다
public class TodoUpdateReqDto {

  private String contents;
  private Boolean isDone;
  private String userName;

  public TodoUpdateReqDto(String contents, Boolean isDone, String userName){
    this.contents = contents;
    this.isDone = isDone;
    this.userName = userName;
  }
}
