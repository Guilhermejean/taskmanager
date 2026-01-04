package com.jean.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jean.taskmanager.dto.TarefaRequestDTO;
import com.jean.taskmanager.dto.TarefaResponseDTO;
import com.jean.taskmanager.dto.TarefaUpdateDTO;
import com.jean.taskmanager.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public TarefaResponseDTO criarTarefa(@RequestBody TarefaRequestDTO dto) {
        return new TarefaResponseDTO(
            service.criarTarefa(
                dto.getTitulo(),
                
                dto.getDescricao(),
                dto.getPrioridade()
            )
        );
    }



    @GetMapping
    public List<TarefaResponseDTO> listarTarefas() {
        return service.listarTarefas()
                .stream()
                .map(TarefaResponseDTO::new)
                .toList();
    }
    @PutMapping("/{id}")
    public TarefaResponseDTO editarTarefa(
            @PathVariable Long id,
            @RequestBody TarefaUpdateDTO dto) {
    
        return new TarefaResponseDTO(service.editar(id, dto));
    }
    
    @PutMapping("/{id}/cancelar")
    public TarefaResponseDTO cancelarTarefa(@PathVariable Long id) {
        return new TarefaResponseDTO(service.cancelar(id));
    }
    

    @PutMapping("/{id}/concluir")
    public TarefaResponseDTO concluirTarefa(@PathVariable Long id) {
        return new TarefaResponseDTO(service.concluir(id));
    }
}
