package com.example.supero.config;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.example.supero.controller.TaskController;
import com.example.supero.controller.UsuarioController;
import com.example.supero.entity.Task;
import com.example.supero.entity.Usuario;

@Component
public class SuperoLink {

	public Link salvaUsuario(Usuario usuario, String rel) {
		return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(UsuarioController.class).salvaUsuario(usuario)).withRel(rel);
	}
	public Link pesquisaUsuario(Long idUsuario,String rel) {
		return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(UsuarioController.class).pesquisarUsuarioId(idUsuario)).withRel(rel);
	}
	
	public Link listarUsuarios(String rel) {
		return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(UsuarioController.class).listaUsuarios()).withRel(rel);
	}
	
	public Link salvarTask(Task task, String rel) {
		return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(TaskController.class).salvaTask(task)).withRel(rel);
	}
	
	public Link listarTask(String rel) {
		return WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
						.listarTodasTasks()).withRel(rel);

	}
	
	public Link updateTask(Task task, String rel) {
		return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(TaskController.class).salvaTask(task)).withRel(rel);
	}

	
}
