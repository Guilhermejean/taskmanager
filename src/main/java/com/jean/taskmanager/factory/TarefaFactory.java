package com.jean.taskmanager.factory;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jean.taskmanager.model.Prioridade;
import com.jean.taskmanager.model.Tarefa;
import com.jean.taskmanager.strategy.PrioridadeStrategy;

@Component
public class TarefaFactory {

    private final Map<Prioridade, PrioridadeStrategy> strategies;

    public TarefaFactory(Map<Prioridade, PrioridadeStrategy> strategies) {
        this.strategies = strategies;
    }

    public void debugStrategies() {
        System.out.println("Strategies carregadas: " + strategies.keySet());
    }

    public Tarefa criar(
        String titulo,
        String descricao,
        Prioridade prioridade,
        LocalDate prazo
    ) {
        debugStrategies();

        Tarefa tarefa = new Tarefa(titulo, descricao, prioridade);

        if (prazo != null) {
            // ✅ usuário definiu prazo manualmente
            tarefa.definirPrazo(prazo);
        } else {
            // ✅ sistema define via Strategy
            PrioridadeStrategy strategy = strategies.get(prioridade);
            if (strategy != null) {
                strategy.aplicar(tarefa);
            }
        }

        return tarefa;
    }
}
