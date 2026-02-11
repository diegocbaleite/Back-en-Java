package com.leite.java.back.end.dto;

import com.leite.java.back.end.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    @NotBlank(message = "Nome é	obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    private String endereco;
    @NotBlank(message = "E-mail é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static UsuarioDTO convert(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEndereco(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getDataCadastro()
        );
    }
}
