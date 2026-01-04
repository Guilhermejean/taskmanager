package com.jean.taskmanager.model; import java.time.LocalDate; import java.time.LocalDateTime;
 import com.jean.taskmanager.strategy.PrioridadeStrategy; import jakarta.persistence.Column; 
 import jakarta.persistence.Entity; 
 import jakarta.persistence.Enumerated; 
 import jakarta.persistence.EnumType; 
 import jakarta.persistence.GeneratedValue; 
 import jakarta.persistence.GenerationType; 
 import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  

   @Entity
    @Table(name = "tarefas")
    public class Tarefa { 
        @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
          @Column(nullable = false, length = 255)
          private String titulo;
           @Column(length = 1000) 
          private String descricao;
           @Column(name = "data_criacao", nullable = false) 
          private LocalDateTime dataCriacao;

           @Column(name = "data_conclusao")
           private LocalDateTime dataConclusao;

            @Column(name = "prazo") 
           private LocalDate prazo;
           
           @Enumerated(EnumType.STRING)
            @Column(nullable = false)
            private StatusTarefa status;
             @Enumerated(EnumType.STRING)
              @Column(nullable = false) 
              private Prioridade prioridade;

               public Tarefa(String titulo, String descricao, Prioridade prioridade)
                { 
                    this.titulo = titulo; 
                    this.descricao = descricao;
                     this.prioridade = prioridade;
                      this.status = StatusTarefa.PENDENTE;
                       this.dataCriacao = LocalDateTime.now(); 
                       this.dataConclusao = null; }
                        protected Tarefa() {

                         } 

                  
public void aplicarPrioridade(PrioridadeStrategy strategy) {
    strategy.aplicar(this);
}
public void editar(String titulo, String descricao, Prioridade prioridade) {
    if (titulo != null && !titulo.isBlank()) {
        this.titulo = titulo;
    }

    if (descricao != null) {
        this.descricao = descricao;
    }

    if (prioridade != null) {
        this.prioridade = prioridade;
    }
}
public void cancelar() {
    if (this.status == StatusTarefa.CONCLUIDA) {
        throw new IllegalStateException("Tarefa já concluída não pode ser cancelada");
    }

    this.status = StatusTarefa.CANCELADA;
}

                         
                         public void definirPrazoEmDias(int dias) { 

                            this.prazo = LocalDate.now().plusDays(dias); 
                        } 
                            
                            public void concluir() { 
                                this.status= StatusTarefa.CONCLUIDA;
                                 this.dataConclusao= LocalDateTime.now();
                                 } 

                                 
                                 public Long getId() { return this.id; }
                                  public String getTitulo() { return this.titulo; } 
                                  public String getDescricao() { return this.descricao; }
                                   public Prioridade getPrioridade() { return this.prioridade; } 
                                   public StatusTarefa getStatus() { return this.status; }
                                    public LocalDateTime getDataCriacao() { return this.dataCriacao; }
                                     public LocalDateTime getDataConclusao() { return this.dataConclusao; } 
public LocalDate getPrazo() 
{ 
    return this.prazo; 
} }

    
