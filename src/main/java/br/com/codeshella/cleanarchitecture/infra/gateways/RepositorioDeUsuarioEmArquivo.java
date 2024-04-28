package br.com.codeshella.cleanarchitecture.infra.gateways;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        return this.usuarios.stream()
                .filter(u -> u.getCpf().equals(cpf))
                .findFirst()
                .map(u -> {
                    u.setNome(usuario.getNome());
                    u.setNascimento(usuario.getNascimento());
                    u.setEndereco(usuario.getEndereco());
                    return u;
                })
                .orElse(null);
    }

    @Override
    public void excluiUsuario(String cpf) {
        this.usuarios.removeIf(u -> u.getCpf().equals(cpf));

    }
    public void  gravaUsuarioEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
