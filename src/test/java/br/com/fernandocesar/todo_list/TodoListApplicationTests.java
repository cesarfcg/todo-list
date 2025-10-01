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
	void contextLoads() {
		var todo = new TodoModel(null, null, false, 0);
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.json("$").isArray()
			
	}

}
