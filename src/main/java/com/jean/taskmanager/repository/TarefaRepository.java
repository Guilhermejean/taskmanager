package com.jean.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jean.taskmanager.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
