import java.util.Scanner;
import java.util.Random;

public class App {
    static Random aleatorio = new Random();

    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("--- SISTEMA DE ORDENAÇÃO ---");
        System.out.print("Digite o tamanho do vetor: ");
        int tam = leitor.nextInt();

        if (tam <= 0) {
            System.out.println("Tamanho invalido. Informe um valor maior que zero.");
            leitor.close();
            return;
        }
        
        Integer[] vetorOriginal = gerarVetorObjetos(tam);

        System.out.println("\nEscolha o método:");
        System.out.println("1 - BubbleSort");
        System.out.println("2 - InsertionSort");
        System.out.println("3 - SelectionSort");
        System.out.println("4 - MergeSort");
        int opcao = leitor.nextInt();

        IOrdenador<Integer> ordenador = null;

        switch (opcao) {
            case 1 -> ordenador = new BubbleSort<>();
            case 2 -> ordenador = new InsertionSort<>();
            case 3 -> ordenador = new SelectionSort<>();
            case 4 -> ordenador = new MergeSort<>();
            default -> System.out.println("Opção inválida!");
        }

        if (ordenador != null) {
            ordenador.ordenar(vetorOriginal);
            
            System.out.println("\n--- RESULTADO ---");
            System.out.println("Método: " + ordenador.getClass().getSimpleName());
            System.out.println("Comparações: " + ordenador.getComparacoes());
            System.out.println("Movimentações: " + ordenador.getMovimentacoes());
            System.out.printf("Tempo: %.4f ms\n", ordenador.getTempoOrdenacao());
        } else {
            System.out.println("Encerrando execucao.");
        }
        
        leitor.close();
    }
}

