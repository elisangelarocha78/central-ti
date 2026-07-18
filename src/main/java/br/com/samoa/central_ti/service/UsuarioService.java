package br.com.samoa.central_ti.service;

import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

}
