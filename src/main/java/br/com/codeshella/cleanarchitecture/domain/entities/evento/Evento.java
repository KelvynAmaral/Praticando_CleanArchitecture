package br.com.codeshella.cleanarchitecture.domain.entities.evento;

import br.com.codeshella.cleanarchitecture.domain.Endereco;
import br.com.codeshella.cleanarchitecture.domain.entities.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {

    private UUID uuid;
    private Categoria categoria;
    private String descricao;
    private Endereco endereco;
    private LocalDateTime data;
    private List<TipoIngresso> tipoIngressos = new ArrayList<>();


    public Evento(Categoria categoria, String descricao, Endereco endereco, LocalDateTime data) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.endereco = endereco;
        this.data = data;

        gerarIdentificadorUnico();
    }

    private void gerarIdentificadorUnico() {
        this.uuid = UUID.randomUUID();
    }

}
