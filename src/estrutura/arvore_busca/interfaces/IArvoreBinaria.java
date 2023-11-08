package estrutura.arvore_busca.interfaces;

public interface IArvoreBinaria<T> extends IArvore {

    public void preOrdemProfundidade(T atual);
    public void emOrdemProfundidade(T atual);
    public void posOrdemProfundidade(T atual);
}



