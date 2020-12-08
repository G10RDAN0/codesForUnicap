package concorrencia;

import java.util.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random randomNum = new Random();
        Barbearia barbearia = new Barbearia();
        (new Thread(new Barbeiro(barbearia))).start();
        
        while (true) {  // simula chegada de clientes
            int r = randomNum.nextInt(1000);
            Thread.sleep(r);
            (new Thread(new Cliente(barbearia))).start();
        }
    }
}