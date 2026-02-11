package com.leite.java.back.end.service;

import com.leite.java.back.end.dto.UsuarioDTO;
import com.leite.java.back.end.model.Usuario;
import com.leite.java.back.end.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository userRepository;

    public List<UsuarioDTO> getAll() {
        List<Usuario> users = userRepository.findAll();
        return users
                .stream()
                .map(UsuarioDTO::convert)
                .collect(Collectors.toList());
    }

}