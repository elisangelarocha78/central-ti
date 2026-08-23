package br.com.samoa.central_ti.service;

import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Lista todos os usuários.
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Salva um usuário.
     *
     * Para novos usuários, a senha é criptografada
     * com BCrypt antes de ser armazenada no banco.
     */
    public Usuario salvar(Usuario usuario) {

        if (usuario.getId() == null) {

            String senhaCriptografada =
                    passwordEncoder.encode(usuario.getSenha());

            usuario.setSenha(senhaCriptografada);
        }

        return usuarioRepository.save(usuario);
    }

    /**
     * Busca um usuário pelo ID.
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Busca um usuário pelo e-mail.
     */
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Exclui um usuário pelo ID.
     */
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}