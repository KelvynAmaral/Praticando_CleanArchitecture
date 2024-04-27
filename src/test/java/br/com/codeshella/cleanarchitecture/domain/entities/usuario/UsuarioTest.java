package br.com.codeshella.cleanarchitecture.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-00", "João", LocalDate.parse("1990-01-01"), "joao@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678900", "João", LocalDate.parse("1990-01-01"), "joao@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "João", LocalDate.parse("1990-01-01"), "joao@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("abcdeasdfa", "João", LocalDate.parse("1990-01-01"), "joao@gmail.com"));
    }
    @Test

    public void deveCriarUsuarioUsandoFabrica() {
        FabricaDeUsuarios fabrica = new FabricaDeUsuarios();
        Usuario usuario = fabrica.criarUsuario("123.456.789-00", "João", LocalDate.parse("1990-01-01"));
        Assertions.assertEquals("123.456.789-00", usuario.getCpf());
        Assertions.assertEquals("João", usuario.getNome());
        Assertions.assertEquals(LocalDate.parse("1990-01-01"), usuario.getNascimento());

        usuario = fabrica.incluiEndereco("12345-678", 123, "Casa");
        Assertions.assertEquals("Casa", usuario.getEndereco().getComplemento());
    }

}
