package com.todolist.Service;

import com.todolist.Modal.ToDoList;

import java.util.List;

public interface ToDoService {
    public ToDoList saveList(ToDoList toDoList);

   List<ToDoList>  viewTasks();

   String removeTasks(int id);
}
