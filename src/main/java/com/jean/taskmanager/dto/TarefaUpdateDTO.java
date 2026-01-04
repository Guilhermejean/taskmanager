package com.jean.taskmanager.dto;

import com.jean.taskmanager.model.Prioridade;

public class TarefaUpdateDTO {

    private String titulo;
    private String descricao;
    private Prioridade prioridade;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }
}

