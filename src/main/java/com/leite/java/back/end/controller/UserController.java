package com.leite.java.back.end.controller;

import com.leite.java.back.end.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static List<UsuarioDTO> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String getMensagem() {
        return "Spring Boot está funcionando!";
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarios;
    }

    @GetMapping("/{cpf}")
    public UsuarioDTO filtroPorCpf(@PathVariable String cpf) {
        return usuarios
                .stream()
                .filter(usuarioDTO -> usuarioDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    @PostConstruct
    public void iniciarLista() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("Diego Assunção");
        usuarioDTO.setCpf("123");
        usuarioDTO.setEndereco("Rua a");
        usuarioDTO.setEmail("eduardo@email.com");
        usuarioDTO.setTelefone("1234-3454");
        usuarioDTO.setDataCadastro(LocalDateTime.now());

        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        usuarioDTO2.setNome("Luiz Henrique");
        usuarioDTO2.setCpf("456");
        usuarioDTO2.setEndereco("Rua b");
        usuarioDTO2.setEmail("luiz@email.com");
        usuarioDTO2.setTelefone("1234-3454");
        usuarioDTO2.setDataCadastro(LocalDateTime.now());

        UsuarioDTO usuarioDTO3 = new UsuarioDTO();
        usuarioDTO3.setNome("Bruna Santos");
        usuarioDTO3.setCpf("678");
        usuarioDTO3.setEndereco("Rua c");
        usuarioDTO3.setEmail("bruna@email.com");
        usuarioDTO3.setTelefone("1234-3454");
        usuarioDTO3.setDataCadastro(LocalDateTime.now());

        UsuarioDTO usuarioDTO4 = new UsuarioDTO();
        usuarioDTO4.setNome("Carlos Henrique");
        usuarioDTO4.setCpf("987");
        usuarioDTO4.setEndereco("Avenida 2");
        usuarioDTO4.setEmail("carlos@email.com");
        usuarioDTO4.setTelefone("1234-3454");
        usuarioDTO4.setDataCadastro(LocalDateTime.now());

        usuarios.add(usuarioDTO);
        usuarios.add(usuarioDTO2);
        usuarios.add(usuarioDTO3);
        usuarios.add(usuarioDTO4);

    }

    public UsuarioDTO inserir(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(usuarioDTO);
        return usuarioDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        boolean removido = usuarios.removeIf(usuarioDTO -> usuarioDTO.getCpf().equals(cpf));

        if (!removido) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        System.out.println("Usuário excluído com sucesso.");
        return true;
    }

}

