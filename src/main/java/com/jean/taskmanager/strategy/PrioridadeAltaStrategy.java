package com.jean.taskmanager.strategy;

import org.springframework.stereotype.Component;
import com.jean.taskmanager.model.Tarefa;
@Component("ALTA")
public class PrioridadeAltaStrategy implements PrioridadeStrategy {

    @Override
    public void aplicar(Tarefa tarefa) {
        System.out.println("🔥 Strategy ALTA executada");
        tarefa.definirPrazoEmDias(1);
    }
}
