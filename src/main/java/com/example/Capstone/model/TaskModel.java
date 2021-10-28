package com.example.Capstone.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todolist")
public class TaskModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String task;
	private  Date date;
	private String description;
	private String status;
	
	public TaskModel() {
		
	}
	
	public TaskModel(int id, String task, Date date, String description, String status) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

