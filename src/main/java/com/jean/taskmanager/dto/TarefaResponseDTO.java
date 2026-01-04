package com.jean.taskmanager.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jean.taskmanager.model.Prioridade;
import com.jean.taskmanager.model.StatusTarefa;
import com.jean.taskmanager.model.Tarefa;

public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;
    private StatusTarefa status;
    private LocalDate prazo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    // Construtor padrão
    public TarefaResponseDTO() {
    }

    // Construtor que recebe a entidade
    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.prioridade = tarefa.getPrioridade();
        this.concluida = tarefa.getStatus() == StatusTarefa.CONCLUIDA;
        this.status = tarefa.getStatus();
        this.prazo = tarefa.getPrazo();
        this.dataCriacao = tarefa.getDataCriacao();
        this.dataConclusao = tarefa.getDataConclusao();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }
    public StatusTarefa getStatus() {
    return status;
}

public LocalDate getPrazo() {
    return prazo;
}

public LocalDateTime getDataCriacao() {
    return dataCriacao;
}

public LocalDateTime getDataConclusao() {
    return dataConclusao;
}

}
