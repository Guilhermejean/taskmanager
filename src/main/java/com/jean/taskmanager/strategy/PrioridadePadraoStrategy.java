package com.jean.taskmanager.strategy;

import org.springframework.stereotype.Component;
import com.jean.taskmanager.model.Tarefa;
@Component("PADRAO")
public class PrioridadePadraoStrategy implements PrioridadeStrategy {

    @Override
    public void aplicar(Tarefa tarefa) {
        tarefa.definirPrazoEmDias(7);
    }
}
