package com.example.TODOList_Thymeleaf.repository;

import com.example.TODOList_Thymeleaf.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
