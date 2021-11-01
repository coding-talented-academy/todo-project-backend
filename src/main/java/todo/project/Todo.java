package todo.project;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

  public Todo(String contents, Date createdDate, String userName, Boolean isDone){
    this.contents = contents;
    this.createdDate = createdDate;
    this.userName = userName;
    this.isDone = isDone;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; //primary key

  private String contents;

  private Date createdDate;

  private String userName;

  private Boolean isDone;

  public Todo update(TodoUpdateReqDto todoUpdateReqDto) {
    this.contents = todoUpdateReqDto.getContents();
    this.isDone = todoUpdateReqDto.getIsDone();
    this.userName = todoUpdateReqDto.getUserName();

    return this;
  }
}
