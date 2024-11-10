package br.com.dio.desafio.dominio;

import java.util.Objects;

public class Curso extends Conteudo{

    private final int cargaHoraria;  // Tornando cargaHoraria imutável

    // Construtor completo para garantir a criação com dados válidos
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);  // Chamando o construtor da classe pai
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero.");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    // Getter para cargaHoraria
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Não há necessidade de setter para cargaHoraria devido à imutabilidade

    @Override
    public String toString() {
        return super.toString() + ", cargaHoraria=" + cargaHoraria + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;  // Compara os atributos da classe pai
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargaHoraria);
    }
}
