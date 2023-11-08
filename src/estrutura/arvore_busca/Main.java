package estrutura.arvore_busca;

import estrutura.arvore_busca.execoes.ArvoreVaziaException;
import estrutura.arvore_busca.execoes.ValorDuplicadoException;

public class Main {
    public static void main(String[] args) throws ValorDuplicadoException, ArvoreVaziaException {


        Arvore_Binaria_Busca<Integer> arvore = new Arvore_Binaria_Busca<>();

        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);
        arvore.inserir(22);

        arvore.menuInterativo();
    }
}

