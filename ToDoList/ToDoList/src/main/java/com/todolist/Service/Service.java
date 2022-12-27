package com.todolist.Service;

import com.todolist.Modal.ToDoList;
import com.todolist.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public ToDoList saveList(ToDoList toDoList) {
        ToDoList toDoList1=toDoRepository.findByTask(toDoList.getTask());
        if(toDoList1==null){
            return toDoRepository.save(toDoList);
        }
       throw new IllegalArgumentException("This task is already added to list.");
    }

    @Override
    public List<ToDoList> viewTasks() {
       return toDoRepository.findAll();
    }

    @Override
    public String removeTasks(int id) {
        if(!toDoRepository.existsById(id)){
            throw new IllegalArgumentException("item with id "+id+" is either already deleted or not added");
        }
        toDoRepository.deleteById(id);
        return "succesfully deleted";
    }
}
