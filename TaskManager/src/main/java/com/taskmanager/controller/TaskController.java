package com.taskmanager.controller;

import com.taskmanager.model.entitiy.Task;
import com.taskmanager.service.ITaskService;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.*;
import org.primefaces.PrimeFaces;

@Getter
@Setter
@Named(value = "taskMB")
@ViewScoped
public class TaskController implements Serializable {

    @EJB
    private ITaskService taskService;

    private Task task;
    private List<Task> tasks;

    public void novo() {
        task = new Task();
    }

    public List<Task> getTasks() {
        return tasks = taskService.findAllTasksName();
        
    }

    public void guardar() {
        taskService.guardar(task);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task registrada"));
        novo();
        PrimeFaces.current().executeScript("PF('dlgTaskRegistro').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-tasks");
    }

    public void editar() {
        taskService.editar(task);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task editada"));
        novo();
        PrimeFaces.current().executeScript("PF('dlgTaskRegistro').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-tasks");
    }

    public void eliminar() {
        taskService.eliminar(task);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task excluída"));
        PrimeFaces.current().executeScript("PF('dlgEliminarTask').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-tasks");
    }
}
