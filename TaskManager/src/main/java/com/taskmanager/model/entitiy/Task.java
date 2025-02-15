/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taskmanager.model.entitiy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.*;

/**
 *
 * @author Marcos
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tasks")
public class Task implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="titulo")
    private String titulo;
    
    @Column(name="descricao")
    private String descricao;
    
    @Column(name="responsavel")
    private String responsavel;
    
    @Column(name="prioridade")
    private String prioridade;
    
    @Column(name="deadline")
    private Date deadline;
    
    @Column(name="concluida")
    private boolean concluida;

    public Integer getIdTask() {
        return this.id;
    }

}
