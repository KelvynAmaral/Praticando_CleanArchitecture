package br.com.codeshella.cleanarchitecture.infra.gateways;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;
import br.com.codeshella.cleanarchitecture.infra.persistence.UsuarioEntity;
import br.com.codeshella.cleanarchitecture.infra.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJPA implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJPA(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repositorio = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repositorio.findByCpf(cpf);
        if (entity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            repositorio.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }
    @Override
    public void excluiUsuario(String cpf) {
        UsuarioEntity entity = repositorio.findByCpf(cpf);
        repositorio.deleteById(entity.getId());
    }
}
