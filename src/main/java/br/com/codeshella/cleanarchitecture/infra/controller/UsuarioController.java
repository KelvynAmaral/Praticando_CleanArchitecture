package br.com.codeshella.cleanarchitecture.infra.controller;

import br.com.codeshella.cleanarchitecture.application.usecases.AlterarUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.CriarUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.ExcluirUsuario;
import br.com.codeshella.cleanarchitecture.application.usecases.ListarUsuarios;
import br.com.codeshella.cleanarchitecture.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AlterarUsuario alterarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(),
                dto.nascimento(), dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }


    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto dto) {
        Usuario atualizado = alterarUsuario.alteraDadosUsuario(cpf,
                new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluirUsuario.excluirUsuario(cpf);
    }

}
