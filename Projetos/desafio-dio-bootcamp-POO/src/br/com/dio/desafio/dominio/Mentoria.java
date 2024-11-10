package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Conteudo {


    private final LocalDate data;  // Imutável

    // Construtor completo para garantir dados válidos
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);  // Chama o construtor da classe pai
        if (data == null || data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data da mentoria não pode ser nula ou no passado.");
        }
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    // Getter para data
    public LocalDate getData() {
        return data;
    }

    // Não há necessidade de setter, pois a data é imutável

    @Override
    public String toString() {
        return super.toString() + ", data=" + data + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mentoria mentoria = (Mentoria) o;
        return data.equals(mentoria.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data);
    }
}
