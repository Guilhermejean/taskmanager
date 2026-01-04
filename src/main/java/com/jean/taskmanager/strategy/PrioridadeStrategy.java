package com.jean.taskmanager.strategy;

import com.jean.taskmanager.model.Tarefa;

public interface PrioridadeStrategy {
    void aplicar(Tarefa tarefa);
}
