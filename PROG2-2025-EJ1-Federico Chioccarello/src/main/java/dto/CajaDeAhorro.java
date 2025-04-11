package dto;

public class CajaDeAhorro extends Cuenta {

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        operaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto <= 0 || monto > saldo) return false;
        saldo -= monto;
        operaciones++;
        return true;
    }
}
