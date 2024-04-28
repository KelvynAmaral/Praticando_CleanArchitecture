package br.com.codeshella.cleanarchitecture.application.ingresso;

import br.com.codeshella.cleanarchitecture.domain.entities.ingresso.Definicao;
import br.com.codeshella.cleanarchitecture.domain.entities.ingresso.Setor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroTipoIngresso (

    @NotNull(message = "O setor do ingresso é obrigatório")
    Setor setor,
    @NotNull(message = "A definição do tipo de ingresso é obrigatória")
    Definicao definicao,
    @NotNull
    Double valor,
    @Positive
    int totalDisponivel
){

}
