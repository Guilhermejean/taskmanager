package com.jean.taskmanager.strategy;

import org.springframework.stereotype.Component;
import com.jean.taskmanager.model.Tarefa;

@Component("MEDIA")
public class PrioridadeMediaStrategy implements PrioridadeStrategy {

    @Override
    public void aplicar(Tarefa tarefa) {
        tarefa.definirPrazoEmDias(3);
    }
}
