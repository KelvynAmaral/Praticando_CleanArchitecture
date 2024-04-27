package br.com.codeshella.cleanarchitecture.application.usecases;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return repositorio.alteraUsuario(cpf, usuario);
    }
}
