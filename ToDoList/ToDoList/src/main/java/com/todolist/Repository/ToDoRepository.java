package com.todolist.Repository;

import com.todolist.Modal.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoList,Integer> {
    ToDoList findByTask(String task);

}
