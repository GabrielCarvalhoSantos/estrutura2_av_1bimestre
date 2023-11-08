package estrutura.arvore_busca.interfaces;

import estrutura.arvore_busca.No;

public interface INo<T extends Comparable<T>>{

    T getValor();
    void setValor(T valor);

    No getFilhoEsq();
    void setFilhoEsq(No<T> filhoEsq);

    No getFilhoDir();
    void setFilhoDir(No<T> filhoDir);
}
