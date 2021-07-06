package com.example.TODOList_Thymeleaf.service;

import com.example.TODOList_Thymeleaf.entity.ToDo;
import com.example.TODOList_Thymeleaf.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public void add(ToDo toDo){
        toDoRepository.save(toDo);
    }

    public List<ToDo> getAll(){
        return this.toDoRepository.findAll();
    }

    public ToDo updateToDoById(long id){
        Optional<ToDo> optional = toDoRepository.findById(id);
        ToDo toDo = null;

        if (optional.isPresent()){
            toDo = optional.get();
        } else {
            throw new RuntimeException("Task with id: " + id + " not found");
        }
        return toDo;
    }
    public void deleteById(Long id){
        this.toDoRepository.deleteById(id);
    }

}
