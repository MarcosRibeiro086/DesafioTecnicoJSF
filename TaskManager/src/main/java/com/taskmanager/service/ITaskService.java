/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.taskmanager.service;

import com.taskmanager.model.entitiy.Task;
import jakarta.ejb.Local;
import java.util.List;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Marcos
 */

@Local
public interface ITaskService {
    
    Task guardar( Task task);

    Task editar( Task task);

    void eliminar( Task task);

    List< Task> listar();
    
    List< Task> findAllTasksName();

    public List<Task> loadTasks(int first, int pageSize, String sortField, SortOrder sortOrder);
}
