package br.com.codeshella.cleanarchitecture.config;

import br.com.codeshella.cleanarchitecture.application.gateways.RepositorioDeUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.AlterarUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.CriarUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.ExcluirUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.ListarUsuarios;
import br.com.codeshella.cleanarchitecture.infra.gateways.RepositorioDeUsuarioJPA;
import br.com.codeshella.cleanarchitecture.infra.gateways.UsuarioEntityMapper;
import br.com.codeshella.cleanarchitecture.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJPA repositorioDeUsuarioJPA(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJPA(repositorio, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapper() {
        return new UsuarioEntityMapper();
    }


    @Bean
    AlterarUsuario alteraUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new AlterarUsuario(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuario excluirUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ExcluirUsuario(repositorioDeUsuario);
    }
}
