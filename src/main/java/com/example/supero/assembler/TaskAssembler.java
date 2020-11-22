package com.example.supero.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.example.supero.config.SuperoLink;
import com.example.supero.controller.TaskController;
import com.example.supero.entity.Task;
import com.example.supero.model.TaskModel;

@Component
public class TaskAssembler extends RepresentationModelAssemblerSupport<Task, TaskModel> {

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	SuperoLink link;

	public TaskAssembler() {
		super(TaskController.class, TaskModel.class);
	}

	@Override
	public TaskModel toModel(Task task) {
		TaskModel taskModel = modelMapper.map(task, TaskModel.class);
		taskModel.add(link.salvarTask(task, "salvar-task"));
		taskModel.add(link.updateTask(task, "update-task"));
		return taskModel;
	}

	@Override
	public CollectionModel<TaskModel> toCollectionModel(Iterable<? extends Task> entities) {
		return super.toCollectionModel(entities).add(link.listarTask("tasks"));
	}

}
