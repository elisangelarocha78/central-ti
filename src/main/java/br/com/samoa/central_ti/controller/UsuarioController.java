package br.com.samoa.central_ti.controller;

import br.com.samoa.central_ti.entity.Usuario;
import br.com.samoa.central_ti.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Lista todos os usuários
     */
    @GetMapping("/usuarios")
    public String listar(Model model) {

        model.addAttribute("usuarios", usuarioService.listarTodos());

        return "usuario/listar";
    }

    /**
     * Abre a tela de cadastro
     */
    @GetMapping("/usuarios/novo")
    public String novo(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "usuario/novo";
    }

    /**
     * Salva um usuário no banco
     */
    @PostMapping("/usuarios/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {

        usuarioService.salvar(usuario);

        return "redirect:/usuarios";
    }

}