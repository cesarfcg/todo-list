package br.com.fernandocesar.todo_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.fernandocesar.todo_list.Entity.TodoModel;

@SpringBootTest
class TodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;
	@Test
	void TestCreateTodosucess() {
		var todo = new TodoModel(null, null, false, 0);
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.lenght()").isEqualTo(1)
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade())
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado());

			
			
	}

}
