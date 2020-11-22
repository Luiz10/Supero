package com.example.supero.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.supero.assembler.TaskAssembler;
import com.example.supero.business.TaskBusiness;
import com.example.supero.entity.Task;
import com.example.supero.model.TaskModel;

@RestController
@RequestMapping(value = "/task")
public class TaskController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public TaskBusiness taskBusiness;
	
	@Autowired
	TaskAssembler taskAssembler;
	
	@Autowired
	public TaskController(TaskBusiness taskBusiness) {
		this.taskBusiness = taskBusiness;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<TaskModel> salvaTask(@RequestBody Task task){
		Task taskSalva = taskBusiness.saveUpdate(task);
		TaskModel taskModel = taskAssembler.toModel(taskSalva);
		return ResponseEntity.ok().body(taskModel);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public ResponseEntity<CollectionModel<TaskModel>> listarTodasTasks(){
	  List<Task> tasks = taskBusiness.listarTasks();
	  return ResponseEntity.ok(taskAssembler.toCollectionModel(tasks));
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{idTask}")
	public ResponseEntity<TaskModel> deletarTask(@PathVariable Long idTask){
	  taskBusiness.excluiTask(idTask);;
	  return ResponseEntity.ok().build();
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/{idTask}")
	public ResponseEntity<TaskModel> updateTask(@PathVariable Long idTask, @RequestBody Task task){
	  Task taskUpdate  = taskBusiness.saveUpdate(task);
	  return ResponseEntity.ok().body(taskAssembler.toModel(taskUpdate));
	}
	
}
