    import java.util.Scanner;

public class CadastroAlunos {
    
    // Classe Aluno (inner class)
    static class Aluno {
        private String nome;
        private int idade;
        private String matricula;

        // Construtor
        public Aluno(String nome, int idade, String matricula) {
            this.nome = nome;
            this.idade = idade;
            this.matricula = matricula;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return "Aluno{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", matricula='" + matricula + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10]; // Array para armazenar até 10 alunos
        int contador = 0; // Contador de alunos cadastrados

        System.out.println("=== Sistema de Cadastro de Alunos ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Listar alunos cadastrados");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    if (contador < alunos.length) {
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite a idade do aluno: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        System.out.print("Digite a matrícula do aluno: ");
                        String matricula = scanner.nextLine();

                        alunos[contador] = new Aluno(nome, idade, matricula);
                        contador++;
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de alunos atingido!");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Alunos Cadastrados ===");
                    for (int i = 0; i < contador; i++) {
                        System.out.println((i + 1) + ". " + alunos[i]);
                    }
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
