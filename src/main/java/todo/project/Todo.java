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
@Table(name = "todo_table")
public class Todo {

  public Todo(String contents, Date createdDate, String userName, Boolean isDone){
    this.contents = contents;
    this.createdDate = createdDate;
    this.userName = userName;
    this.isDone = isDone;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String contents;

  private Date createdDate;

  private String userName;

  private Boolean isDone;
}
