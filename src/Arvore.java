public class Arvore<TIPO extends Comparable<TIPO>> {

    private Elemento<TIPO> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void adicionar(TIPO valor) {
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);
        if (raiz == null) {
            this.raiz = novoElemento;
        } else {
            Elemento<TIPO> atual = this.raiz;
            while (true) {
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                } else { // aqui eh se for maior ou igual
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }

    public void remover(TIPO valor) {
        this.raiz = removerecursivo(this.raiz, valor);
    }

    private Elemento<TIPO> removerecursivo(Elemento<TIPO> raiz, TIPO valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor.compareTo(raiz.getValor()) < 0) {
            raiz.setEsquerda(removerecursivo(raiz.getEsquerda(), valor));
        } else if (valor.compareTo(raiz.getValor()) > 0) {
            raiz.setDireita(removerecursivo(raiz.getDireita(), valor));
        } else {
            // Nó com apenas um filho ou nenhum filho
            if (raiz.getEsquerda() == null) {
                return raiz.getDireita();
            } else if (raiz.getDireita() == null) {
                return raiz.getEsquerda();
            }

            // Nó com dois filhos, encontrar o menor valor na subárvore direita
            raiz.setValor(acharmenorValor(raiz.getDireita()));

            // Remover o menor valor na subárvore direita
            raiz.setDireita(removerecursivo(raiz.getDireita(), raiz.getValor()));
        }

        return raiz;
    }

    private TIPO acharmenorValor(Elemento<TIPO> raiz) {
        return raiz.getEsquerda() == null ? raiz.getValor() : acharmenorValor(raiz.getEsquerda());
    }

    public void listaremordem() {
        System.out.println("Listagem em ordem:");
        if (this.raiz == null) {
            System.out.println("A árvore está vazia. Não há valores cadastrados.");
        } else {
            listarOrdemR(this.raiz);
        }
        System.out.println();
    }

    private void listarOrdemR(Elemento<TIPO> raiz) {
        if (raiz != null) {
            listarOrdemR(raiz.getEsquerda());
            System.out.print(raiz.getValor() + " ");
            listarOrdemR(raiz.getDireita());
        }
    }

    public boolean existe(TIPO valor) {
        return existeRecursivo(this.raiz, valor);
    }

    private boolean existeRecursivo(Elemento<TIPO> raiz, TIPO valor) {
        if (raiz == null) {
            return false;
        }

        if (valor.equals(raiz.getValor())) {
            return true;
        } else if (valor.compareTo(raiz.getValor()) < 0) {
            return existeRecursivo(raiz.getEsquerda(), valor);
        } else {
            return existeRecursivo(raiz.getDireita(), valor);
        }
    }


}