package com.jean.taskmanager.factory;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.jean.taskmanager.model.Prioridade;
import com.jean.taskmanager.model.Tarefa;
import com.jean.taskmanager.strategy.PrioridadeStrategy;

@Component
public class TarefaFactory {

    private final Map<String, PrioridadeStrategy> strategies;

    public TarefaFactory(Map<String, PrioridadeStrategy> strategies) {
        this.strategies = strategies;
    }

    public void debugStrategies() {
        System.out.println("Strategies carregadas: " + strategies.keySet());
    }
    
    public Tarefa criar(String titulo, String descricao, Prioridade prioridade) {
        Tarefa tarefa = new Tarefa(titulo, descricao, prioridade);

        PrioridadeStrategy strategy =
            strategies.getOrDefault(
                prioridade.name(),
                strategies.get("PADRAO")
            );

        tarefa.aplicarPrioridade(strategy);

        return tarefa;
    }
}
