/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanager.service.impl;

import com.taskmanager.model.entitiy.Task;
import com.taskmanager.repository.TaskRepository;
import com.taskmanager.service.ITaskService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Marcos
 */
@Stateless
public class TaskServiceImpl implements ITaskService {
    
    @EJB
    private TaskRepository taskRepository;

    @Override
    public Task guardar(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task editar(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public void eliminar(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> listar() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllTasksName() {
        return taskRepository.findAllTasksName();
    }

    @Override
    public List<Task> loadTasks(int first, int pageSize, String sortField, SortOrder sortOrder) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
