package br.com.codeshella.cleanarchitecture.application.usecases;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {

    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf) {
        this.repositorio.excluiUsuario(cpf);
    }
}
