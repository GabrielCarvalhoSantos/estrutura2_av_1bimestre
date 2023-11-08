package estrutura.arvore_busca.interfaces;

import estrutura.arvore_busca.No;
import estrutura.arvore_busca.execoes.ArvoreVaziaException;
import estrutura.arvore_busca.execoes.ValorDuplicadoException;

public interface IArvore<T extends Comparable<T>>{


    public void inserir(T valor) throws ValorDuplicadoException, ValorDuplicadoException;
    public boolean remover(T valor) throws ArvoreVaziaException, ArvoreVaziaException;
    public void percorrerEmLargura() throws ArvoreVaziaException;
    public No buscar(T valor) throws ArvoreVaziaException;
    
}
