package com.example.supero.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supero.config.SessionUtil;
import com.example.supero.entity.Task;
import com.example.supero.entity.Usuario;
import com.example.supero.enums.EnumStatus;
import com.example.supero.repository.TaskRepository;

@Service
public class TaskBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;

	TaskRepository taskRepository;
	
	@Autowired
	SessionUtil sessionUtil;
	
	@Autowired
	public TaskBusiness(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	
	public Task saveUpdate(Task task) {
	    Usuario usuario = new Usuario();
	    usuario.setId(sessionUtil.idUsuario());
		task.setStatus(EnumStatus.EM_ANDAMENTO.getDescricao());
		task.setDataCriacao(new Date());
	    task.setUsuario(usuario);
		return taskRepository.save(task);
	}
	
	public void excluiTask(Long idTask) {
		taskRepository.deleteById(idTask);
	}
	
	public List<Task> listarTasks(){
		return this.taskRepository.findAll();
	}
}
