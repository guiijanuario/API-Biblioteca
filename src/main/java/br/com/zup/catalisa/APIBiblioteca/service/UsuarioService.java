package br.com.zup.catalisa.APIBiblioteca.service;

import br.com.zup.catalisa.APIBiblioteca.enums.RoleEnum;
import br.com.zup.catalisa.APIBiblioteca.model.RoleModel;
import br.com.zup.catalisa.APIBiblioteca.model.UsuarioModel;
import br.com.zup.catalisa.APIBiblioteca.repository.UsuarioRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Para criptografar a senha

    public void criarUsuario(UsuarioModel usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new DuplicateKeyException("Nome de usuário já existe");
        }

        // Criptografar a senha antes de armazenar
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        RoleModel adminRole = new RoleModel();
        adminRole.setRole(RoleEnum.ROLE_ADMIN);
        usuario.setRoles(Collections.singletonList(adminRole));

        usuarioRepository.save(usuario);
    }


    public UsuarioModel obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public void deletarUsuario(Long id) {
        UsuarioModel usuario = obterUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }
}
