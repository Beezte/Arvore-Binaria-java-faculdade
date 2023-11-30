import java.util.Scanner;

public class Main {

//    Alunos:
//    Kawã Ricardo Bazante
//    Matricula: 01616235
//    Curso: Engenharia da Computação
//    e
//    Anna Julia
//    Matricula: 01631263
//    Curso: Sistemas da Informação

    public static void main(String[] args){
        Arvore<Integer> arvore = new Arvore<Integer>();
        Scanner leia = new Scanner(System.in);
        int opc = 0;
        while (opc != 4){
            System.out.println("");
            System.out.println("## ÁRVORE BINÁRIA ##");
            System.out.println("1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Listar");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Informe o valor a ser inserido: ");
                    int valorInserir = leia.nextInt();
                    arvore.adicionar(valorInserir);
                    System.out.println("Valor " + valorInserir + " inserido na árvore.");
                    break;
                case 2:
                    System.out.print("Informe o valor a ser removido: ");
                    int valorRemover = leia.nextInt();
                    arvore.remover(valorRemover);
                    System.out.print("Valor " + valorRemover + " removido da árvore com secesso!");
                    break;
                case 3:
                    System.out.print("Listando valores da árvore: ");
                    arvore.listaremordem();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }
}