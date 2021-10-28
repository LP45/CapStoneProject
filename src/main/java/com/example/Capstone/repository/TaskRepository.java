package com.example.Capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Capstone.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository <TaskModel,Integer> {
//	List<TaskModel> findBy(String task);
}
