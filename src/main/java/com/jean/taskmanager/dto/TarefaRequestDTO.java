package com.jean.taskmanager.dto;

import java.time.LocalDate;
import com.jean.taskmanager.model.Prioridade;

public class TarefaRequestDTO {

    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalDate prazo; 

    public TarefaRequestDTO() {}

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDate getPrazo() { 
        return prazo;
    }
}
