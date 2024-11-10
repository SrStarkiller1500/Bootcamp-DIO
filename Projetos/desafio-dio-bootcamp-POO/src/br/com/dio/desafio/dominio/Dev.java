package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // Metodo que Inscreve o Dev em um Bootcamp
    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp != null) {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        } else {
            System.err.println("Bootcamp inválido!");
        }
    }

    // Progride para o próximo conteúdo do Dev
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        conteudo.ifPresentOrElse(
                c -> {
                    this.conteudosConcluidos.add(c);
                    this.conteudosInscritos.remove(c);
                },
                () -> System.err.println("Você não está matriculado em nenhum conteúdo!")
        );
    }

    // Calcula o total de XP dos conteúdos concluídos
    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // Comparação entre objetos Dev
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
                Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
                Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}