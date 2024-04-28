package br.com.codeshella.cleanarchitecture;

import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;
import br.com.codeshella.cleanarchitecture.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {

        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();
        repositorio.cadastrarUsuario(new Usuario("123.456.789-10", "João", LocalDate.parse("1992-10-22"), "joão@gmail.com"));
        repositorio.cadastrarUsuario(new Usuario("123.456.789-11", "Maria", LocalDate.parse("1992-10-22"), "maria@gmail.com"));

        repositorio.gravaUsuarioEmArquivo("usuarios.txt");

    }
}
