package com.example.Capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Capstone.exception.TaskException;
import com.example.Capstone.model.TaskModel;
import com.example.Capstone.repository.TaskRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/restfulApi")

public class TaskController {
	@Autowired
	private TaskRepository taskRepo;
	
	@GetMapping("/allTasks")
	public List<TaskModel> getAllTasks()
	{
		
		return taskRepo.findAll();
	}
	
	@PostMapping("/addTask")
    public TaskModel newTask(@RequestBody TaskModel t)
    {
		
		return taskRepo.save(t);
    }
	
	
	@GetMapping("/Task/{id}")
	public ResponseEntity<TaskModel> getTaskById(@PathVariable int id)
	{
		TaskModel s= taskRepo.findById(id).orElseThrow(() ->  new TaskException("Task not found"));
		return ResponseEntity.ok(s);                 
	}
	
//	@GetMapping("/Tasks/{task}")
//	public List<TaskModel> getTaskByTask(@PathVariable String task)
//	{
////		return taskRepo.findByName(name);
//		
//		List <TaskModel> Tasks=taskRepo.findByTask(task);
//		if(Tasks.isEmpty())
//		{
//			System.out.println(new TaskException("Note(s) with the name "+ task +" not found"));
//		}
//		
//		return taskRepo.findByTask(task);
//	}
	
	
	
	@PutMapping("/Task/{id}")
	public ResponseEntity<TaskModel> updateTask(@PathVariable int id, @RequestBody TaskModel Task)
	{
		TaskModel s= taskRepo.findById(id).orElseThrow(() ->  new TaskException("Task not found"));
		s.setDate(Task.getDate());
		s.setStatus(Task.getStatus());
	    s.setTask(Task.getTask());
	    s.setDescription(Task.getDescription());
	    TaskModel updatedTask=taskRepo.save(s);
	    return ResponseEntity.ok(updatedTask);
	}
	
	
	@DeleteMapping("/Task/{id}")
	public String deleteTask(@PathVariable int id)
	{
		taskRepo.findById(id).orElseThrow(() ->  new TaskException("Task not found"));
	    taskRepo.deleteById(id);
	    return "The Task with id: "+ id +" is removed from the database.";
	}
}
