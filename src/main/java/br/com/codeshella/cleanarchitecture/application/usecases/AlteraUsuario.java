package br.com.codeshella.cleanarchitecture.application.usecases;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;

public class AlteraUsuario {
    private final RepositorioDeUsuario repositorio;

    public AlteraUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(Usuario usuario) {
        return repositorio.alteraUsuario(usuario.getCpf(), usuario.getEmail());
    }
}
