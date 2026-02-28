package com.leite.java.back.end.controller;

import com.leite.java.back.end.dto.UsuarioDTO;
import com.leite.java.back.end.model.Usuario;
import com.leite.java.back.end.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Listar todos os usuários")
    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.getAll();
    }

    @Operation(summary = "Buscar usuário por ID")
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @Operation(summary = "Criar um novo usuário")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @Operation(summary = "Buscar usuário por CPF")
    @GetMapping("/cpf/{cpf}")
    public UsuarioDTO buscarPorCpf(@PathVariable String cpf) {
        return usuarioService.findByCpf(cpf);
    }

    @Operation(summary = "Deletar usuário por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = usuarioService.delete(id);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Buscar usuários pelo nome")
    @GetMapping("/buscar")
    public List<Usuario> buscarPorNome(
            @RequestParam(name = "nome", required = true) String nome) {
        return usuarioService.queryByName(nome);
    }
}

