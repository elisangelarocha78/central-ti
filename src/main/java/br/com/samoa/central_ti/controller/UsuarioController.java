package br.com.samoa.central_ti.controller;

import br.com.samoa.central_ti.dto.UsuarioEdicaoDTO;
import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;
import java.util.Optional;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    /**
     * Lista todos os usuários.
     */
    @GetMapping("/usuarios")
    public String listar(Model model) {

        model.addAttribute(
                "usuarios",
                usuarioService.listarTodos()
        );

        return "usuario/listar";
    }

    /**
     * Abre a tela de cadastro.
     */
    @GetMapping("/usuarios/novo")
    public String novo(Model model) {

        Usuario usuario = new Usuario();
        usuario.setAtivo(true);

        model.addAttribute(
                "usuario",
                usuario
        );

        return "usuario/novo";
    }

    /**
     * Valida e salva um novo usuário.
     */
    @PostMapping("/usuarios/salvar")
    public String salvar(
            @Valid
            @ModelAttribute("usuario")
            Usuario usuario,

            BindingResult resultado) {

        /*
         * Normaliza o e-mail.
         */
        if (usuario.getEmail() != null) {

            String emailNormalizado =
                    usuario.getEmail()
                            .trim()
                            .toLowerCase(Locale.ROOT);

            usuario.setEmail(
                    emailNormalizado
            );
        }

        /*
         * Bloqueia e-mail duplicado.
         */
        if (!resultado.hasFieldErrors("email")
                && usuario.getEmail() != null
                && usuarioService
                .buscarPorEmail(usuario.getEmail())
                .isPresent()) {

            resultado.rejectValue(
                    "email",
                    "email.duplicado",
                    "Já existe um usuário cadastrado com este e-mail"
            );
        }

        if (resultado.hasErrors()) {
            return "usuario/novo";
        }

        usuarioService.salvar(usuario);

        return "redirect:/usuarios";
    }

    /**
     * Abre a tela de edição.
     */
    @GetMapping("/usuarios/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        Usuario usuario = usuarioService
                .buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Usuário não encontrado. ID: " + id
                        )
                );

        UsuarioEdicaoDTO usuarioEdicao =
                new UsuarioEdicaoDTO(usuario);

        model.addAttribute(
                "usuarioEdicao",
                usuarioEdicao
        );

        return "usuario/editar";
    }

    /**
     * Atualiza um usuário existente.
     */
    @PostMapping("/usuarios/editar/{id}")
    public String atualizar(
            @PathVariable Long id,

            @Valid
            @ModelAttribute("usuarioEdicao")
            UsuarioEdicaoDTO usuarioEdicao,

            BindingResult resultado) {

        /*
         * Normaliza o e-mail.
         */
        if (usuarioEdicao.getEmail() != null) {

            usuarioEdicao.setEmail(
                    usuarioEdicao
                            .getEmail()
                            .trim()
                            .toLowerCase(Locale.ROOT)
            );
        }

        /*
         * Verifica se o novo e-mail pertence
         * a OUTRO usuário.
         */
        if (!resultado.hasFieldErrors("email")
                && usuarioEdicao.getEmail() != null) {

            Optional<Usuario> usuarioMesmoEmail =
                    usuarioService.buscarPorEmail(
                            usuarioEdicao.getEmail()
                    );

            if (usuarioMesmoEmail.isPresent()
                    && !usuarioMesmoEmail
                    .get()
                    .getId()
                    .equals(id)) {

                resultado.rejectValue(
                        "email",
                        "email.duplicado",
                        "Já existe outro usuário cadastrado com este e-mail"
                );
            }
        }

        if (resultado.hasErrors()) {

            usuarioEdicao.setId(id);

            return "usuario/editar";
        }

        usuarioService.atualizar(
                id,
                usuarioEdicao
        );

        return "redirect:/usuarios";
    }
}