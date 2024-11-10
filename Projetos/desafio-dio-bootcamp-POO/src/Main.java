import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Criar cursos com um construtor
        Curso cursoJava = new Curso("Curso Java", "Descrição curso Java", 8);
        Curso cursoJS = new Curso("Curso JS", "Descrição curso JS", 4);
        Curso cursoPython = new Curso("Curso Python", "Descrição curso Python", 6);  // Novo curso
        Curso cursoCSharp = new Curso("Curso C#", "Descrição curso C#", 5);  // Novo curso

// Criar mentorias com um construtor
        Mentoria mentoriaJava = new Mentoria("Mentoria Java", "Descrição mentoria Java", LocalDate.now());
        Mentoria mentoriaPython = new Mentoria("Mentoria Python", "Descrição mentoria Python", LocalDate.now().plusDays(2));  // Nova mentoria

        // Criando Bootcamp e adicionando conteúdos
        Bootcamp bootcampJava = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoJS);
        bootcampJava.getConteudos().add(cursoPython);  // Adicionando novo curso
        bootcampJava.getConteudos().add(cursoCSharp);  // Adicionando novo curso
        bootcampJava.getConteudos().add(mentoriaJava);
        bootcampJava.getConteudos().add(mentoriaPython);  // Adicionando nova mentoria

        // Esatmos aqui Criando e inscrevendo desenvolvedores no bootcamp
        Dev devCamila = criarDevComInscricao("Camila", bootcampJava);
        Dev devJoao = criarDevComInscricao("Joao", bootcampJava);
        Dev devLucas = criarDevComInscricao("Lucas", bootcampJava);  // Novo desenvolvedor
        Dev devMaria = criarDevComInscricao("Maria", bootcampJava);  // Nova desenvolvedora

        // Exibir progresso de Camila
        exibirProgressoDev(devCamila);

        // Exibir progresso de João
        exibirProgressoDev(devJoao);

        // Exibir progresso de Lucas
        exibirProgressoDev(devLucas);

        // Exibir progresso de Maria
        exibirProgressoDev(devMaria);
    }

    // Método auxiliar para criar um Dev e inscrevê-lo no Bootcamp//
    private static Dev criarDevComInscricao(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);
        return dev;
    }

    // Método auxiliar para exibir o progresso de um Dev
    private static void exibirProgressoDev(Dev dev) {
        // Exibindo o nome do desenvolvedor e o status de inscrição
        System.out.println("---------------------------------------------------");
        System.out.println("Desenvolvedor: " + dev.getNome());
        System.out.println("---------------------------------------------------");

        // Exibindo os conteúdos inscritos
        System.out.println("Conteúdos Inscritos:");
        for (Conteudo conteudo : dev.getConteudosInscritos()) {
            System.out.println("  - " + conteudo.getTitulo());
        }

        // Simulando o progresso do desenvolvedor (exemplo de 2 progressos)
        dev.progredir();
        dev.progredir();

        // Exibindo os conteúdos restantes (não concluídos) e os conteúdos concluídos
        System.out.println("\nConteúdos Restantes:");
        for (Conteudo conteudo : dev.getConteudosInscritos()) {
            System.out.println("  - " + conteudo.getTitulo());
        }

        System.out.println("\nConteúdos Concluídos:");
        for (Conteudo conteudo : dev.getConteudosConcluidos()) {
            System.out.println("  - " + conteudo.getTitulo());
        }

        // Exibindo o XP total
        System.out.printf("\nXP Total de %s: %.2f%n", dev.getNome(), dev.calcularTotalXp());

        // Separando os resultados dos desenvolvedores
        System.out.println("---------------------------------------------------\n");
    }
}