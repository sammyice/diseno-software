package Servicios;

abstract class AbstractHandler implements Handler {
    protected Handler next;
    protected final int BASE_MODULO = 5000;
    protected int valorBillete;

    public AbstractHandler(int valorBillete) {
        this.valorBillete = valorBillete;
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handle(int monto) {
        boolean noEsMultiplo = monto % BASE_MODULO != 0;
        if (noEsMultiplo) {
            throw new Error("La cantidad ingresada no es un múltiplo de 5000");
        } else {
            if (monto >= valorBillete) {
                int numeroDeBilletes = monto / valorBillete;
                int resto = monto % valorBillete;
                System.out.printf("Entregando %d billetes de %d.\n", numeroDeBilletes, valorBillete);
                if (resto > 0 && this.next != null) {
                    this.next.handle(resto);
                }
            } else if (this.next != null) {
                this.next.handle(monto);
            }
        }
    }
}