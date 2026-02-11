package com.leite.java.back.end.model;

import com.leite.java.back.end.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static Usuario convert(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setDataCadastro(usuarioDTO.getDataCadastro());
        return usuario;
    }

    public static UsuarioDTO convert(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEndereco(usuario.getEndereco());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setDataCadastro(usuario.getDataCadastro());
        return usuarioDTO;
    }
}
