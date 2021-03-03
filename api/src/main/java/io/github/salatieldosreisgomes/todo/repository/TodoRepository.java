package io.github.salatieldosreisgomes.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.salatieldosreisgomes.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
