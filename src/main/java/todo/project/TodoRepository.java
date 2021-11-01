package todo.project;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  /*SQL 문 : 데이터베이스에 질의를 할 수 있는 언어
      - select : 조회 시에 테이블에서 뽑아올 컬럼이름
                ex) Todo테이블의 where 절에 해당하는 데이터의 모든 컬럼을 뽑아와라
      - from : 조회할 테이블 이름(ex Todo테이블)
      - where : 조회할 데이터 중 제한을 걸어준다.
                 ex) Todo테이블의 userName 컬럼이 "user1"인 데이터만 뽑아와라
  * */
  @Query("select t from Todo t where t.userName= :name") // select * from TodoTable where userName=""
  List<Todo> findByUserName(@Param("name") String userName);

  @Query("select t from Todo t where t.id=:id") //select * from TodoTable where id=""
  Optional<Todo> findById(@Param("id") Long id); //null point exception

  @Modifying // Query 로 날릴때는 수정/삭제 시 필수
  @Query("delete from Todo t where t.id=:id") //delete from TodoTable where id=""
  void deleteSingleTodo(@Param("id") Long id);
}
