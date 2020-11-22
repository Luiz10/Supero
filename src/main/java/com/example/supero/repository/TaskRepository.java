package com.example.supero.repository;

import org.springframework.stereotype.Repository;

import com.example.supero.entity.Task;

@Repository
public interface TaskRepository extends GenericRepository<Task, Long>, TaskRepositoryCustom {

}
