package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
