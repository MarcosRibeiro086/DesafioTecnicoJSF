/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanager.repository;

import com.taskmanager.model.entitiy.Task;
import com.taskmanager.repository.persistence.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TaskRepository extends CrudRepository<Task> {

    @PersistenceContext(unitName = "TASK_MAN")
    private EntityManager em;

    public TaskRepository() {
       super(Task.class);
   }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Task> findAllTasksName() {
        try {
            return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        } catch (Exception e) {
            // Log da exceção
            System.err.println("Erro ao buscar tarefas: " + e.getMessage());
            // Imprime o stack trace para depuração
            return new ArrayList<>();  // Retorna uma lista vazia
        }
    }


}
