package estrutura.arvore_busca.testes;

import estrutura.arvore_busca.Arvore_Binaria_Busca;
import estrutura.arvore_busca.execoes.ArvoreVaziaException;
import estrutura.arvore_busca.execoes.ValorDuplicadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTeste {

    private Arvore_Binaria_Busca<Integer> arvore;

    //Antes de cada teste os Nos com seu valores serão inseridos na arvore para realização dos estrutura.arvore_busca.testes.
    @BeforeEach
    void setUp() throws ValorDuplicadoException {
        arvore = new Arvore_Binaria_Busca<>();
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);
    }


    @Test
    void testInserir() throws ArvoreVaziaException {
        // Testando a inserção e verificando se os elementos existem na árvore.
        System.out.println("Teste inserir:");
        assertTrue(arvore.buscar(10) != null);
        assertTrue(arvore.buscar(8) != null);
        assertTrue(arvore.buscar(5) != null);
        assertTrue(arvore.buscar(9) != null);
        assertTrue(arvore.buscar(7) != null);
        assertTrue(arvore.buscar(18) != null);
        assertTrue(arvore.buscar(13) != null);
        assertTrue(arvore.buscar(20) != null);

    }

    @Test
    void testRemover() throws ArvoreVaziaException {
        // Testando a remoção de elementos e verificando se eles foram removidos com sucesso
        System.out.println("Teste remover:");
        assertTrue(arvore.remover(20));
        assertNull(arvore.buscar(20));
        assertTrue(arvore.remover(5));
        assertNull(arvore.buscar(5));
        assertTrue(arvore.remover(8));
        assertNull(arvore.buscar(8));
        assertTrue(arvore.remover(9));
        assertNull(arvore.buscar(9));
        assertTrue(arvore.remover(13));
        assertNull(arvore.buscar(13));
        assertTrue(arvore.remover(7));
        assertNull(arvore.buscar(7));
        assertTrue(arvore.remover(18));
        assertNull(arvore.buscar(18));
    }

    @Test
    void testPreOrdem(){
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em pré-ordem (preOrder)
        System.out.println("Pre-Ordem:");
        arvore.preOrdemProfundidade(arvore.getRaiz());
    }


    @Test
    void testEmOrdem() {
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em ordem (inOrder)
        System.out.println("Em Ordem:");
        arvore.emOrdemProfundidade(arvore.getRaiz());
    }


    @Test
    void testPosOrdem() {
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em pós-ordem (postOrder)
        System.out.println("Pos-Ordem:");
        arvore.posOrdemProfundidade(arvore.getRaiz());
    }

    @Test
    void testBuscar() throws ArvoreVaziaException {
        // Testando a busca de elementos.
        System.out.println("Teste de busca:");
        assertEquals(7, arvore.buscar(7).getValor());
        assertEquals(5, arvore.buscar(5).getValor());
        assertEquals(20, arvore.buscar(20).getValor());
        assertEquals(8, arvore.buscar(8).getValor());
        assertEquals(10, arvore.buscar(10).getValor());
        assertNull(arvore.buscar(30));
    }

    @Test
    public void testPercorrerEmLargura() throws ValorDuplicadoException, ArvoreVaziaException {
        System.out.println("Percorrer em largura:");
        arvore.percorrerEmLargura();
    }

    @Test
    void testInserirDuplicado() {
        assertThrows(ValorDuplicadoException.class, () -> {
            arvore.inserir(5); // Deve lançar uma exceção
        });
    }
}

