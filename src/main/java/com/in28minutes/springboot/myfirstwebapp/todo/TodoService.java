package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo(1, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(1, "in28minutes", "Learn Devops", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(1, "in28minutes", "Learn Full stack development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todoList;
    }
}
