package com.jean.taskmanager.strategy;

import org.springframework.stereotype.Component;
import com.jean.taskmanager.model.Tarefa;

@Component("BAIXA")
public class PrioridadeBaixaStrategy implements PrioridadeStrategy {

    @Override
    public void aplicar(Tarefa tarefa) {
        System.out.println("🔥 Strategy BAIXA executada");
        tarefa.definirPrazoEmDias(7);
    }
}
