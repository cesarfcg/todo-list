package br.com.fernandocesar.todo_list.Service;

import br.com.fernandocesar.todo_list.Entity.TodoModel;
import br.com.fernandocesar.todo_list.Repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoModel> create(TodoModel todo){
        todoRepository.save(todo);
        return list();
    }
    public List<TodoModel> update(TodoModel todo){
        todoRepository.save(todo);
        return list();
    }
    public List<TodoModel> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
    public List<TodoModel> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome")).ascending();
        return todoRepository.findAll(sort);
    }
}
