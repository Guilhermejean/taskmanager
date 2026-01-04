package com.jean.taskmanager.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.jean.taskmanager.factory.TarefaFactory;
import com.jean.taskmanager.model.Tarefa;
import com.jean.taskmanager.model.Prioridade;
import com.jean.taskmanager.repository.TarefaRepository;
import com.jean.taskmanager.dto.TarefaUpdateDTO;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final TarefaFactory factory;

    public TarefaService(
        TarefaRepository repository,
        TarefaFactory factory
    ) {
        this.repository = repository;
        this.factory = factory;
    }

    public Tarefa criarTarefa(String titulo, String descricao, Prioridade prioridade) {
        Tarefa tarefa = factory.criar(titulo, descricao, prioridade);
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa concluir(Long id) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.concluir();
        return repository.save(tarefa);
    }
    public Tarefa editar(Long id, TarefaUpdateDTO dto) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    
        tarefa.editar(
            dto.getTitulo(),
            dto.getDescricao(),
            dto.getPrioridade()
        );
    
        return repository.save(tarefa);
    }
    public Tarefa cancelar(Long id) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    
        tarefa.cancelar();
    
        return repository.save(tarefa);
    }
    
}
