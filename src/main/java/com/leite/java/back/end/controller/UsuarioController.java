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

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Listar todos os usuários
    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.getAll();
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    // Criar um novo usuário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public UsuarioDTO buscarPorCpf(@PathVariable String cpf) {
        return usuarioService.findByCpf(cpf);
    }

    // Deletar usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = usuarioService.delete(id);
        if (removido) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // Buscar usuários pelo nome
    @GetMapping("/buscar")
    public List<Usuario> buscarPorNome(
            @RequestParam(name = "nome", required = true) String nome) {
        return usuarioService.queryByName(nome);
    }
}