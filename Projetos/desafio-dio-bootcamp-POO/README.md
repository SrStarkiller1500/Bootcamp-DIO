# Abstraindo um BOOTCAMP 💻📚

Esse repositório armazena o conteudo do desafio proposto de abstração de um BOOTCAMP

## Melhorias Realizadas 📚

### 1. **Estrutura de Classes**
- **Classe `Conteudo`**: Base para cursos e mentorias. Possui atributos comuns como título, descrição e o método abstrato `calcularXp()`.
- **Classe `Curso` e `Mentoria`**: Herdam de `Conteudo` e implementam o método `calcularXp()` de formas específicas para calcular o XP de acordo com a carga horária ou um valor fixo para mentorias.
- **Classe `Dev`**: Representa um desenvolvedor que pode se inscrever em um bootcamp, progredir nos conteúdos e calcular seu XP total com base nos conteúdos concluídos.
- **Classe `Bootcamp`**: Representa um bootcamp, contendo uma lista de conteúdos (cursos e mentorias) e desenvolvedores inscritos.

### 2. **Melhorias no Código**
- **Uso de Coleções**: Utilização de coleções como `Set` para armazenar os conteúdos e os desenvolvedores, evitando duplicações e garantindo uma ordem coerente.
- **Método `progredir()`**: Implementado para permitir que os desenvolvedores avancem no bootcamp, movendo os conteúdos da lista de "inscritos" para "concluídos".
- **Cálculo de XP**: Cada conteúdo (curso ou mentoria) possui uma forma distinta de calcular o XP, considerando a carga horária dos cursos ou um valor fixo para as mentorias.

### 3. **Melhorias na Exibição da Saída**
- **Formatação Melhorada da Saída**:
    - Uso de `System.out.printf` para exibir o XP total com precisão de duas casas decimais.
    - Mensagens informativas sobre o progresso dos desenvolvedores, separando claramente os "Conteúdos Inscritos", "Conteúdos Concluídos" e o "XP Total".
- **Separadores Visuais**:
    - Linhas de separação (com `---------------------------------------------------`) foram adicionadas para tornar a saída mais legível e organizada, especialmente quando há múltiplos desenvolvedores no bootcamp.
- **Listagem de Conteúdos**:
    - A exibição dos conteúdos é agora feita de forma mais clara e organizada, listando todos os cursos e mentorias de cada desenvolvedor.
- **Detalhamento do Progresso**:
    - O progresso dos desenvolvedores é mostrado de maneira clara, indicando quais conteúdos ainda estão em andamento e quais já foram concluídos.

### 4. **Melhorias na Organização do Código**
- **Métodos Auxiliares**:
    - Criados métodos auxiliares para organizar a criação de desenvolvedores e a exibição do progresso, tornando o código mais modular e reutilizável.
- **Lógica de Inscrição e Progresso**:
    - O processo de inscrição e progresso no bootcamp foi centralizado, facilitando a manutenção e a expansão do código no futuro.