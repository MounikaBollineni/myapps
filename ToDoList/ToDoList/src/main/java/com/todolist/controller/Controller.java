package com.todolist.controller;

import com.todolist.Modal.ToDoList;
import com.todolist.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todolist")
@CrossOrigin
@Validated
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/viewtasks")
    public List<ToDoList> viewTasks(){
        return  service.viewTasks();
    }

    @PostMapping("/addtask")
    public ResponseEntity<ToDoList> saveTask(@Valid  @RequestBody ToDoList toDoList){

        return  new ResponseEntity<>(service.saveList(toDoList), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/removetask/{id}")
    public String saveTask(@PathVariable int id){
        return  service.removeTasks(id);
    }
}
