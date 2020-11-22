package com.example.supero.config;

import org.springframework.stereotype.Component;

import com.example.supero.mixin.PermissaoMixin;
import com.example.supero.mixin.TaskMixin;
import com.example.supero.mixin.UsuarioMixin;
import com.example.supero.model.PermissaoModel;
import com.example.supero.model.TaskModel;
import com.example.supero.model.UsuarioModel;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonModule extends SimpleModule{

	
	private static final long serialVersionUID = 1L;

	public JacksonModule() {
		setMixInAnnotation(UsuarioModel.class, UsuarioMixin.class);
		setMixInAnnotation(PermissaoModel.class, PermissaoMixin.class);
		setMixInAnnotation(TaskModel.class, TaskMixin.class);
	}
}
