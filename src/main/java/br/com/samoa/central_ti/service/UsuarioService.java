package br.com.samoa.central_ti.service;

import br.com.samoa.central_ti.dto.UsuarioEdicaoDTO;
import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
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
     * Salva um novo usuário.
     *
     * A senha é criptografada com BCrypt
     * antes de ser armazenada.
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
     * Busca usuário pelo ID.
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Busca usuário pelo e-mail.
     */
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Atualiza um usuário existente.
     */
    public Usuario atualizar(
            Long id,
            UsuarioEdicaoDTO dados) {

        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Usuário não encontrado. ID: " + id
                        )
                );

        usuario.setNome(
                dados.getNome().trim()
        );

        usuario.setEmail(
                dados.getEmail()
                        .trim()
                        .toLowerCase(Locale.ROOT)
        );

        usuario.setPerfil(
                dados.getPerfil()
        );

        usuario.setAtivo(
                Boolean.TRUE.equals(dados.getAtivo())
        );

        /*
         * Só altera a senha quando uma nova
         * senha tiver sido informada.
         */
        if (dados.getSenha() != null
                && !dados.getSenha().isBlank()) {

            String novaSenhaCriptografada =
                    passwordEncoder.encode(
                            dados.getSenha()
                    );

            usuario.setSenha(
                    novaSenhaCriptografada
            );
        }

        return usuarioRepository.save(usuario);
    }

    /**
     * Exclui usuário pelo ID.
     */
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}