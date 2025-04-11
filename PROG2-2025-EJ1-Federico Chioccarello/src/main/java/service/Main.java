package service;
import dto.*;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CuentaService cuentaService = CuentaService.getInstancia(); // Singleton
        Random random = new Random();
        int cantidadIteraciones = 100000;

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                cuentaService.agregarCuenta(new CajaDeAhorro());
            } else {
                cuentaService.agregarCuenta(new CuentaCorriente(1000.0)); // giroDescubierto
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < cantidadIteraciones; i++) {
            executor.execute(() -> {
                int cuentaIndex = random.nextInt(10);
                double monto = 50 + random.nextDouble() * 450; // entre 50 y 500
                boolean esAgregar = random.nextBoolean();

                if (esAgregar) {
                    cuentaService.agregarSaldo(cuentaIndex, monto);
                } else {
                    cuentaService.quitarSaldo(cuentaIndex, monto);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        for (int i = 0; i < 10; i++) {
            double saldo = cuentaService.consultarSaldo(i);
            int operaciones = cuentaService.getOperaciones(i);
            System.out.println("Cuenta " + i + ": Saldo = $" + saldo + " | Operaciones = " + operaciones);
        }
    }
}
