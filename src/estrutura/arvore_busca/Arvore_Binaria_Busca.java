package estrutura.arvore_busca;

import estrutura.arvore_busca.interfaces.IArvore;
import estrutura.arvore_busca.execoes.ArvoreVaziaException;
import estrutura.arvore_busca.execoes.ValorDuplicadoException;

import java.util.ArrayList;
import java.util.Scanner;

public class Arvore_Binaria_Busca<T extends Comparable<T>> implements IArvore<T> {


    private No<T> raiz;

    public Arvore_Binaria_Busca() {
        this.raiz = null;
    }

    @Override
    public void inserir(T valor) throws ValorDuplicadoException {
        No<T> no = new No<T>(valor);

        if (raiz == null) {
            this.raiz = no;
        } else {
            No<T> atual = this.raiz;
            while (true) {
                int comparacao = valor.compareTo(atual.getValor());
                if (comparacao == 0) {
                    throw new ValorDuplicadoException("Valor duplicado: " + valor);
                } else if (comparacao < 0) {
                    if (atual.getFilhoEsq() != null) {
                        atual = atual.getFilhoEsq();
                    } else {
                        atual.setFilhoEsq(no);
                        break;
                    }
                } else {
                    if (atual.getFilhoDir() != null) {
                        atual = atual.getFilhoDir();
                    } else {
                        atual.setFilhoDir(no);
                        break;
                    }
                }
            }
        }
    }

    public No<T> getRaiz() {
        return raiz;
    }


    @Override
    public boolean remover(T valor) throws ArvoreVaziaException {
        //Buscar o br.edu.ifs.academico.atividadeestrutura.arvoredebusca.No na arvore
        No<T> atual = this.raiz;
        No<T> paiAtual = null;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                break;
            } else if (valor.compareTo(atual.getValor()) == -1) { //valor procurado é menor que o que o atual
                paiAtual = atual;
                atual = atual.getFilhoEsq();
            } else {
                paiAtual = atual;
                atual = atual.getFilhoDir();
            }
        }
        //Verifica se o br.edu.ifs.academico.atividadeestrutura.arvoredebusca.No existe
        if (atual != null) {
            //br.edu.ifs.academico.atividadeestrutura.arvoredebusca.No tem dois filhos ou tem filho somente a direita
            if (atual.getFilhoDir() != null) {
                No<T> substituto = atual.getFilhoDir();
                No<T> paiSubstituto = atual;
                while (substituto.getFilhoEsq() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getFilhoEsq();
                }
                substituto.setFilhoEsq(atual.getFilhoEsq());
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //substituto < que paiSubstituto
                        paiAtual.setFilhoEsq(substituto);
                    } else {
                        paiSubstituto.setFilhoDir(substituto);
                    }
                } else { //Se não tem paiAtual então o nó é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setFilhoEsq(null);
                    this.raiz.setFilhoDir(paiSubstituto);
                    this.raiz.setFilhoEsq(atual.getFilhoEsq());
                }
                //Remove o elemento da arvore
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto < que paiSubstituto
                    paiSubstituto.setFilhoEsq(null);
                } else {
                    paiSubstituto.setFilhoDir(null);
                }
            } else if (atual.getFilhoEsq() != null) {//Tem filho só a esquerda
                No<T> substituto = atual.getFilhoEsq();
                No<T> paiSubstituto = atual;
                while (substituto.getFilhoDir() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getFilhoDir();
                }
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual < que paiSubstituto
                        paiAtual.setFilhoEsq(substituto);
                    } else {
                        paiSubstituto.setFilhoDir(substituto);
                    }
                } else { //Se for a raiz
                    this.raiz = substituto;
                }
                //Remove o elemento da arvore
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto < que paiSubstituto
                    paiSubstituto.setFilhoEsq(null);
                } else {
                    paiSubstituto.setFilhoDir(null);
                }
            } else { // Não tem filho
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual < que paiAtual
                        paiAtual.setFilhoEsq(null);
                    } else {
                        paiAtual.setFilhoDir(null);
                    }
                } else { //É a raiz
                    this.raiz = null;
                    throw new ArvoreVaziaException("A árvore está vazia");

                }
            }
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void percorrerEmLargura() throws ArvoreVaziaException {

        ArrayList<No<T>> fila = new ArrayList<>();

        if (raiz != null) {
            fila.add(raiz);
        }

        while (!fila.isEmpty()) {
            No<T> no = fila.remove(0); // Remove o primeiro elemento da lista
            System.out.println(no.getValor());

            if (no.getFilhoEsq() != null) {
                fila.add(no.getFilhoEsq());
            }

            if (no.getFilhoDir() != null) {
                fila.add(no.getFilhoDir());
            }
        }
    }


    public void preOrdemProfundidade(No<T> atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            preOrdemProfundidade(atual.getFilhoEsq());
            preOrdemProfundidade(atual.getFilhoDir());
        }
    }

    public void emOrdemProfundidade(No<T> atual) {
        if (atual != null) {
            emOrdemProfundidade(atual.getFilhoEsq());
            System.out.println(atual.getValor());
            emOrdemProfundidade(atual.getFilhoDir());
        }
    }

    public void posOrdemProfundidade(No<T> atual) {
        if (atual != null) {
            posOrdemProfundidade(atual.getFilhoEsq());
            posOrdemProfundidade(atual.getFilhoDir());
            System.out.println(atual.getValor());
        }
    }

    @Override
    public No<T> buscar(T valor) throws ArvoreVaziaException {
        No<T> atual = this.raiz;

        while (atual != null) {
            int comparacao = valor.compareTo(atual.getValor());

            if (comparacao == 0) { // Valor encontrado
                System.out.println("Valor encontrado: " + valor);
                return atual;
            } else if (comparacao < 0) { // Valor procurado é menor que o atual
                atual = atual.getFilhoEsq();
            } else { // Valor procurado é maior que o atual
                atual = atual.getFilhoDir();
            }
        }
        if (this.raiz == null){
            throw new ArvoreVaziaException("A árvore está vazia");

        }
        // Elemento não encontrado
        System.out.println("Valor nao encontrado: " + valor);
        return null;
    }

    public void menuInterativo() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1 - Percurso em Largura");
            System.out.println("2 - Percurso em Pre-Ordem");
            System.out.println("3 - Percurso em Ordem");
            System.out.println("4 - Percurso em Pos-Ordem");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        percorrerEmLargura();
                    } catch (ArvoreVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    preOrdemProfundidade(getRaiz());
                    break;
                case 3:
                    emOrdemProfundidade(getRaiz());
                    break;
                case 4:
                    posOrdemProfundidade(getRaiz());
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        }
    }
}
