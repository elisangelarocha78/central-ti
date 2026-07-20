package br.com.samoa.central_ti.controller;

import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
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

        model.addAttribute("usuario", usuario);

        return "usuario/novo";
    }

    /**
     * Valida e salva um usuário no banco.
     */
    @PostMapping("/usuarios/salvar")
    public String salvar(
            @Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult resultado) {

        if (resultado.hasErrors()) {
            return "usuario/novo";
        }

        usuarioService.salvar(usuario);

        return "redirect:/usuarios";
    }
}