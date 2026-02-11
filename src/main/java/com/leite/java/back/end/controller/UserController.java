package com.leite.java.back.end.controller;

import com.leite.java.back.end.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.spi.ToolProvider.findFirst;

@RestController
@RequestMapping("/user")
public class UserController {

    private static List<UserDTO> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String getMensagem() {
        return "Spring Boot está funcionando!";
    }

    @GetMapping("/listar")
    public List<UserDTO> listarUsuarios() {
        return usuarios;
    }

    @GetMapping("/{cpf}")
    public UserDTO filtroPorCpf(@PathVariable String cpf) {
        return usuarios
                .stream()
                .filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    @PostConstruct
    public void iniciarLista() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Diego Assunção");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz Henrique");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna Santos");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO4 = new UserDTO();
        userDTO4.setNome("Carlos Henrique");
        userDTO4.setCpf("987");
        userDTO4.setEndereco("Avenida 2");
        userDTO4.setEmail("carlos@email.com");
        userDTO4.setTelefone("1234-3454");
        userDTO4.setDataCadastro(LocalDateTime.now());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
        usuarios.add(userDTO4);

    }

    public UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        boolean removido = usuarios.removeIf(userDTO -> userDTO.getCpf().equals(cpf));

        if (!removido) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        System.out.println("Usuário excluído com sucesso.");
        return true;
    }

}

