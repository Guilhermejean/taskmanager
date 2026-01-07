package com.jean.taskmanager.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jean.taskmanager.model.Prioridade;
import com.jean.taskmanager.strategy.PrioridadeAltaStrategy;
import com.jean.taskmanager.strategy.PrioridadeBaixaStrategy;
import com.jean.taskmanager.strategy.PrioridadeMediaStrategy;
import com.jean.taskmanager.strategy.PrioridadeStrategy;

@Configuration
public class PrioridadeStrategyConfig {

    @Bean
    public Map<Prioridade, PrioridadeStrategy> prioridadeStrategies(
            PrioridadeAltaStrategy alta,
            PrioridadeMediaStrategy media,
            PrioridadeBaixaStrategy baixa) {

        return Map.of(
            Prioridade.ALTA, alta,
            Prioridade.MEDIA, media,
            Prioridade.BAIXA, baixa
        );
    }
}
