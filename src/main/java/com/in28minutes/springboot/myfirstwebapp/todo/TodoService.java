package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todoList.add(new Todo(++todosCount, "in28minutes", "Get AWS Certified", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn Devops", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn Full stack development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todoList;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        todoList.add(new Todo(++todosCount, username, description, targetDate, isDone));
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todoList.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todoList.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todoList.add(todo);
    }
}
