package estrutura.arvore_busca;

import estrutura.arvore_busca.interfaces.INo;

public class No<T extends Comparable<T>>implements INo<T> {

    private T valor;
    private No<T> filhoEsq;
    private No<T> filhoDir;


    public No(T valor) {
        this.valor = valor;
        this.filhoEsq = null;
        this.filhoDir = null;
    }

    @Override
    public T getValor() {
        return valor;
    }

    @Override
    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public No getFilhoEsq() {
        return filhoEsq;
    }

    @Override
    public void setFilhoEsq(No<T> filhoEsq) {
        this.filhoEsq = filhoEsq;
    }

    @Override
    public No getFilhoDir() {
        return filhoDir;
    }

    @Override
    public void setFilhoDir(No<T> filhoDir) {
        this.filhoDir = filhoDir;
    }
}
