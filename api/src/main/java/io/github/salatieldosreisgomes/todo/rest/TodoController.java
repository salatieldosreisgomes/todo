package io.github.salatieldosreisgomes.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.salatieldosreisgomes.todo.model.Todo;
import io.github.salatieldosreisgomes.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping
	public List<Todo> getAll(){
		return todoRepository.findAll();
	}
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}
	
	@GetMapping("{id}")
	public Todo findById(@PathVariable Long id) {
		return todoRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		todoRepository.deleteById(id);
	}

}
