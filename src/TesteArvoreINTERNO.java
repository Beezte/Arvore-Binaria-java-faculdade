import java.util.Random;

public class TesteArvoreINTERNO {
    public static void main(String[] args) {
        // testando a adição de elementos
        Arvore<Integer> arvore = new Arvore<Integer>();
        Random random = new Random();

        System.out.println("Adicionando elementos:");
        for (int i = 0; i < 50; i++) {
            int valor = random.nextInt(100);
            arvore.adicionar(valor);
            System.out.print(valor + " ");
        }
        System.out.println("\nAdição de elementos passou");

        // aqui listando os elementos em ordem
        System.out.println("\n\nListagem em ordem:");
        arvore.listaremordem();
        System.out.println("Listagem passou");

        // aqui verifico a existência de valores
        System.out.println("\nVerificando existência:");
        for (int i = 0; i < 10; i++) {
            int valorVerificar = random.nextInt(100);
            if (arvore.existe(valorVerificar)) {
                System.out.println("O valor " + valorVerificar + " existe na árvore");
            } else {
                System.out.println("O valor " + valorVerificar + " NÃO existe na árvore");
            }
        }
        System.out.println("Verificação de existência passou");

        // removendo alguns elementos elatorios
        System.out.println("\nRemovendo alguns elementos");
        for (int i = 0; i < 10; i++) {
            int valorRemover = random.nextInt(100);
            arvore.remover(valorRemover);
            System.out.println("Removido: " + valorRemover);
        }
        System.out.println("Remoção de elementos passou");

        // aqui eu listo os elementos em ordem dps da remoção
        System.out.println("\nListagem em ordem após remoção");
        arvore.listaremordem();
        System.out.println("Listagem após remoção passou");
    }
}