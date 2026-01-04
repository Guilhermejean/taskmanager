package com.jean.taskmanager.dto;

import com.jean.taskmanager.model.Prioridade;

public class TarefaRequestDTO {

    private String titulo;
    private String descricao;
    private Prioridade prioridade;

    // Construtor padrão
    public TarefaRequestDTO() {
    }

    // Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
