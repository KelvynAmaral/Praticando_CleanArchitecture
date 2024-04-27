package br.com.codeshella.cleanarchitecture.application.usecases;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuario {
    private final RepositorioDeUsuario repositorio;

    public ListarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterUsuarios(){
        return this.repositorio.listarTodos();
    }

}
