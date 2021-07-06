package com.example.TODOList_Thymeleaf.controller;

import com.example.TODOList_Thymeleaf.entity.ToDo;
import com.example.TODOList_Thymeleaf.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public String todo(Principal principal, Model model){
        model.addAttribute("toDo", new ToDo());
        model.addAttribute("toDoList", toDoService.getAll());
        return "todo";
    }

    @PostMapping
    public String addTodo(@Validated ToDo toDo, Errors errors, Model model){
        model.addAttribute("toDoList", toDoService.getAll());

        if (errors.hasErrors()){
            return "todo";
        }

        this.toDoService.add(toDo);
        return "redirect:/todo";
    }

    @GetMapping("/update")
    public String updateToDo(@PathVariable(value = "id") long id, Model model){
        ToDo toDo = toDoService.updateToDoById(id);
        model.addAttribute("toDo", toDo);
        return "redirect:/todo";
    }

    @PostMapping("/delete")
    public String deleteToDo(@RequestParam Long id, Model model){
        this.toDoService.deleteById(id);
        return "redirect:/todo";
    }


}
