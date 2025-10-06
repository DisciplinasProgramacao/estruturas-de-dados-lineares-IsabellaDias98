import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo); // 3 Processos: criar nova célula, atribuir topo a nova célula, atualizar topo
	}

	public E desempilhar() { // Remove o elemento do topo e o retorna

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		if (numItens <= 0) {
        throw new IllegalArgumentException("O número de itens deve ser maior que zero.");
		}

		Celula<E> atual = topo;
		Pilha<E> novaPilha = new Pilha<E>();
		int contador = 0;

		while (atual != fundo && contador < numItens) {
			novaPilha.empilhar(atual.getItem());
			atual = atual.getProximo();
			contador++;
		}

		if (contador < numItens) {
			throw new IllegalArgumentException("A pilha não contém " + numItens + " elementos.");
		}

		// Inversão da Pilha (Ficar Igual a Original)
		Pilha<E> pilhaInvertida = new Pilha<E>();

		while (!novaPilha.vazia()) {
			pilhaInvertida.empilhar(novaPilha.desempilhar());
		}

		return pilhaInvertida;
		
	}
}