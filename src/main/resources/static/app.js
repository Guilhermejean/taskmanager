const API = "http://localhost:8080/tarefas";

function criarTarefa() {
    fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            titulo: document.getElementById("titulo").value,
            descricao: document.getElementById("descricao").value,
            prioridade: document.getElementById("prioridade").value
        })
    })
    .then(res => res.json())
    .then(data => alert("Tarefa criada com ID " + data.id));
}

function listarTarefas() {
    fetch("http://localhost:8080/tarefas")
        .then(res => res.json())
        .then(tarefas => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";

            tarefas.forEach(tarefa => {
                const li = document.createElement("li");
                li.innerHTML = `
                <div class="cabecalho-tarefa">
                    <strong class="titulo">${tarefa.titulo}</strong>
                    <span class="prioridade">${tarefa.prioridade}</span>
                </div>
            
                <div class="info">
                    Status: ${tarefa.status}
                </div>
            
             
                    <button class="btn concluir" onclick="concluirTarefa(${tarefa.id})">Concluir</button>
                    <button class="btn cancelar" onclick="cancelarTarefa(${tarefa.id})">Cancelar</button>
                    <button class="btn editar" onclick="editarTarefa(${tarefa.id})">Editar</button>
              
            `;
            

                lista.appendChild(li);
            });
        });
}
function concluirTarefa(id) {
    fetch(`http://localhost:8080/tarefas/${id}/concluir`, {
        method: "PUT"
    }).then(() => listarTarefas());
}
function cancelarTarefa(id) {
    fetch(`http://localhost:8080/tarefas/${id}/cancelar`, {
        method: "PUT"
    }).then(() => listarTarefas());
}
function editarTarefa(id) {
    const novoTitulo = prompt("Novo título:");
    const novaDescricao = prompt("Nova descrição:");

    fetch(`http://localhost:8080/tarefas/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            titulo: novoTitulo,
            descricao: novaDescricao
        })
    }).then(() => listarTarefas());
}
