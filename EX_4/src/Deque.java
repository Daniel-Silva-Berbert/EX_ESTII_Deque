public class Deque<T> {
    private DequeBase<T> cauda = new DequeBase<>();
    private int tamanho;

    public void inserirInicio(T elemento) {
        DequeBase<T> t1 = new DequeBase<>();
        if (tamanho == 0) {
            t1.elemento = elemento;
            cauda.prox = t1;
            cauda.ant = t1;
        } else {
            t1.elemento = elemento;
            t1.prox = cauda.prox;
            t1.ant = cauda;
            cauda.prox.ant = t1;
            cauda.prox = t1;
        }
        ++tamanho;
    }

    public T removeFim() throws Exception {
        if (tamanho == 0) {
            throw new Exception("O deque está vazia");
        }
        T el = cauda.ant.elemento;
        if (cauda.ant == cauda || tamanho == 1) {
            cauda.prox = null;
            cauda.ant = null;
        } else {
            cauda.ant = cauda.ant.ant;
            cauda.ant.prox = cauda;
        }
        --tamanho;
        return el;
    }

    public void inserirFim(T elemento) {
        DequeBase<T> t1 = new DequeBase<>();
        if (tamanho == 0) {
            t1.elemento = elemento;
            cauda.prox = t1;
            cauda.ant = t1;
        } else {
            t1.elemento = elemento;
            t1.ant = cauda.ant;
            t1.prox = cauda;
            cauda.ant.prox = t1;
            cauda.ant = t1;
        }
        ++tamanho;
    }

    public T removeInicio() throws Exception {
        if (tamanho == 0) {
            throw new Exception("O deque está vazia");
        }
        T el = cauda.prox.elemento;
        if (cauda.prox == cauda || tamanho == 1) {
            cauda.prox = null;
            cauda.ant = null;
        } else {
            cauda.prox = cauda.prox.prox;
            cauda.prox.ant = cauda;
        }
        --tamanho;
        return el;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }
}
