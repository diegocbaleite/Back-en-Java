package com.leite.java.back.end.repository;

import com.leite.java.back.end.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);

    List<Usuario> queryByNomeLike(String nome);
}
