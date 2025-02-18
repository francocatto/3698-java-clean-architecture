package br.com.alura.codechella.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    @DisplayName("Não deve cadastrar usuário com CPF com formato inválido")
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario.UsuarioBuilder().cpf("12345678999").nome("Jacque").nascimento(LocalDate.parse("1990-09-08")).email("email@email.com").build());
    }

    @Test
    @DisplayName("Não deve cadastrar usuário com formatação do email inválida")
    public void naoDeveCadastrarUsuarioComEmailNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario.UsuarioBuilder().cpf("12345678999").nome("Jacque").nascimento(LocalDate.parse("1990-09-08")).email("teste@testecom").build(), "CPF formato inválido");
    }

    @Test
    @DisplayName("Não deve cadastrar usuário com formatação do email inválida")
    public void naoDeveCadastrarUsuarioComEmailFormatoValido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario.UsuarioBuilder().cpf("12345678999").nome("Jacque").nascimento(LocalDate.parse("1990-09-08")).email("teste@testecom").build(), "Email formato inválido");
    }

    @Test
    @DisplayName("Deve cadastrar usuário com CPF com formato inválido")
    public void deveCadastrarUsuarioComEmailFormatoValido(){
        Assertions.assertDoesNotThrow(() -> new Usuario.UsuarioBuilder().cpf("123.456.789-99").nome("Jacque").nascimento(LocalDate.parse("1990-09-08")).email("email@email.com").build(),"Email formato inválido");
    }

    @Test
    @DisplayName("Não deve permitir cadastrar usuário menor de idade")
    public void naoDevePermitirCadastrarUsuarioMenorDeIdade(){
        LocalDate dataNascimento = LocalDate.now().minusYears(17);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario.UsuarioBuilder().cpf("123.456.789-99").nome("Jacque").nascimento(dataNascimento).email("email@email.com").build(),"Nascimento inferior a 18 anos");
    }
}
