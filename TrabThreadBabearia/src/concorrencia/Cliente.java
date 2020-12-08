package concorrencia;

import java.util.Random;

public class Cliente implements Runnable {
    private Barbearia barbearia;

    public Cliente(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    public void run() {
        barbearia.chegadaDoCliente(Thread.currentThread().getId());
    }
}