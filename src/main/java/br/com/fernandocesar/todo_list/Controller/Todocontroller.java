package br.com.fernandocesar.todo_list.Controller;

import br.com.fernandocesar.todo_list.Entity.TodoModel;
import br.com.fernandocesar.todo_list.Service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class Todocontroller {
    private TodoService todoService;

    public Todocontroller(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    public List<TodoModel> create(TodoModel todo){
        return todoService.create(todo);
    }
    @PutMapping
    public List<TodoModel> update(TodoModel todo){
        return todoService.update(todo);
    }
    @DeleteMapping("{id}")
    public List<TodoModel> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
    @GetMapping
    public List<TodoModel> list(){
        return todoService.list();
    }
}
