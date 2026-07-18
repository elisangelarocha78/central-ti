package br.com.samoa.central_ti.enums;

public enum PerfilUsuario {

    ADMIN("Administrador"),
    TECNICO("Técnico");

    private final String descricao;

    PerfilUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}