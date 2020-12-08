package concorrencia;

import java.util.Random;

public class Barbeiro implements Runnable {
    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    public void run() {
        while(true) {
            barbearia.atenderCliente();
        }
    }
}
