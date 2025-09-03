package br.com.fernandocesar.todo_list.Repository;

import br.com.fernandocesar.todo_list.Entity.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel,Long>  {

}
