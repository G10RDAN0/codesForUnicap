package concorrencia;

import java.util.*;

public class Barbearia {
    private static final int NUM_MAX_CLIENTES = 6;
    private static long[] cadeiras = new long[NUM_MAX_CLIENTES];
    private Random rnd = new Random();
    private int numeroDeClientes=0; // clientes na barbearia
    private int entra=0;
    private int sai=0;

    											
    public synchronized void atenderCliente() { // Barbeiro atende cliente quando houver um
        try {
            while (numeroDeClientes == 0) {
                System.out.println("O barbeiro está dormindo...");
                wait(); 		//  barbeiro dorme até chegar cliente
            }
            System.out.println("Barbeiro começou a cortar o cabelo do cliente "+ cadeiras[sai] + " da cadeiras " + sai);
            numeroDeClientes--;
            Thread.sleep(rnd.nextInt(3000)); // fica um tempo cortando o cabelo do cliente
        } catch (InterruptedException e) {}
        System.out.println("Barbeiro acabou de cortar o cabelo do cliente " + cadeiras[sai] + " da cadeiras " + sai);
      
        sai = (sai+1)%NUM_MAX_CLIENTES;
      
        return;
    }

    public synchronized void chegadaDoCliente(long threadID) {
        if (numeroDeClientes < NUM_MAX_CLIENTES) {
            cadeiras[entra] = threadID;
            System.out.println("Cliente " + threadID + " sentou na cadeiras " + entra + " proximo " + sai);
            entra = (entra+1)%NUM_MAX_CLIENTES;
            numeroDeClientes++;

            if (numeroDeClientes == 1)
                notifyAll(); // acorda o barbeiro
        }
        else
            System.out.println("Cliente " + threadID + " foi embora ");
    }
}