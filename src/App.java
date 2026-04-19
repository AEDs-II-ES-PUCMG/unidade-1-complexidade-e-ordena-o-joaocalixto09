import java.util.Arrays;
import java.util.Random;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }


   public static void main(String[] args) {
    // Teste com um tamanho médio para observar as métricas (ex: 12.500)
    int tam = 12500; 
    Integer[] vetorOriginal = gerarVetorObjetos(tam);

    // Lista de ordenadores para facilitar o loop de teste
    IOrdenador<Integer>[] ordenadores = new IOrdenador[] {
        new Bubblesort<Integer>(),
        new InsertionSort<Integer>(),
        new SelectionSort<Integer>()
    };

    String[] nomes = {"Bubblesort", "InsertionSort", "SelectionSort"};

    System.out.println("Comparação de Desempenho (Tamanho: " + tam + ")");
    System.out.println("-------------------------------------------------");

    for (int i = 0; i < ordenadores.length; i++) {
        // Ordena
        ordenadores[i].ordenar(vetorOriginal);

        // Exibe resultados
        System.out.println("Método: " + nomes[i]);
        System.out.println("Comparações: " + ordenadores[i].getComparacoes());
        System.out.println("Movimentações: " + ordenadores[i].getMovimentacoes());
        System.out.printf("Tempo: %.4f ms\n", ordenadores[i].getTempoOrdenacao());
        System.out.println("-------------------------------------------------");
    }
}
}
