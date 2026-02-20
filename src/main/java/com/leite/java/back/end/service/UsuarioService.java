package com.leite.java.back.end.service;

import com.leite.java.back.end.dto.UsuarioDTO;
import com.leite.java.back.end.model.Usuario;
import com.leite.java.back.end.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Camada de serviço responsável pelas regras de negócio
 * relacionadas à entidade Usuario.
 */
@Service
@RequiredArgsConstructor
public class UsuarioService {

    // Injeção de dependência automática via Lombok
    private final UsuarioRepository usuarioRepository;

    /**
     * Retorna todos os usuários cadastrados.
     * Converte a lista de entidades Usuario para UsuarioDTO.
     */
    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios
                .stream()
                .map(UsuarioDTO::convert) // Converte entidade em DTO
                .collect(Collectors.toList());
    }

    /**
     * Retorna usuários de forma paginada.
     * Pageable contém informações como página, tamanho e ordenação.
     */
    public Page<UsuarioDTO> getAllPage(Pageable page) {
        Page<Usuario> usuarios = usuarioRepository.findAll(page);

        // O metodo map converte cada entidade da página em DTO
        return usuarios.map(UsuarioDTO::convert);
    }

    /**
     * Busca um usuário pelo ID.
     * Lança exceção caso não encontre.
     */
    public UsuarioDTO findById(long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        return UsuarioDTO.convert(usuario);
    }

    /**
     * Salva um novo usuário no banco.
     * Define automaticamente a data de cadastro.
     */
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        // Define data atual antes de salvar
        usuarioDTO.setDataCadastro(LocalDateTime.now());

        // Converte DTO para entidade e salva no banco
        Usuario usuario = usuarioRepository.save(
                Usuario.convert(usuarioDTO)
        );

        // Retorna DTO atualizado
        return UsuarioDTO.convert(usuario);
    }

    /**
     * Busca usuário pelo CPF.
     * Retorna null caso não encontre.
     */
    public UsuarioDTO findByCpf(String cpf) {

        Usuario usuario = usuarioRepository.findByCpf(cpf);

        if (usuario != null) {
            return UsuarioDTO.convert(usuario);
        }

        return null;
    }

    /**
     * Busca usuários pelo nome utilizando LIKE.
     * Retorna lista de DTOs.
     */
    public List<UsuarioDTO> queryByNome(String nome) {

        List<Usuario> usuarios =
                usuarioRepository.queryByNomeLike(nome);

        return usuarios
                .stream()
                .map(UsuarioDTO::convert)
                .collect(Collectors.toList());
    }

    /**
     * Atualiza dados específicos do usuário.
     * Só altera os campos enviados no DTO.
     */
    public UsuarioDTO editUser(Long userId, UsuarioDTO usuarioDTO) {

        // Busca usuário existente
        Usuario usuario = usuarioRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        // Atualiza email se diferente
        if (usuarioDTO.getEmail() != null &&
                !usuario.getEmail().equals(usuarioDTO.getEmail())) {
            usuario.setEmail(usuarioDTO.getEmail());
        }

        // Atualiza telefone se diferente
        if (usuarioDTO.getTelefone() != null &&
                !usuario.getTelefone().equals(usuarioDTO.getTelefone())) {
            usuario.setTelefone(usuarioDTO.getTelefone());
        }

        // Atualiza endereço se diferente
        if (usuarioDTO.getEndereco() != null &&
                !usuario.getEndereco().equals(usuarioDTO.getEndereco())) {
            usuario.setEndereco(usuarioDTO.getEndereco());
        }

        // Salva alterações no banco
        usuario = usuarioRepository.save(usuario);

        // Retorna usuário atualizado convertido para DTO
        return UsuarioDTO.convert(usuario);
    }
}