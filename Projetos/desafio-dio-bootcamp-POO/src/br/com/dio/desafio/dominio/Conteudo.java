package br.com.dio.desafio.dominio;

import java.util.Objects;

public abstract class Conteudo {

    // Constante que representa o XP
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    // Construtor para inicialização das propriedades do curso
    public Conteudo(String titulo, String descricao) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio ou nulo.");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia ou nula.");
        }

        this.titulo = titulo;
        this.descricao = descricao;
    }

    // Método abstrato que será implementado pelas subclasses para calcular o XP
    public abstract double calcularXp();

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }


    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    // equals e hashCode baseados no título, assumindo que o título é único para cada conteúdo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return titulo.equals(conteudo.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
