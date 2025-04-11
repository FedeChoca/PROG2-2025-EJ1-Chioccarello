package dto;

public class CuentaCorriente extends Cuenta {
    private double giroDescubierto;

    public CuentaCorriente(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        operaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto <= 0) return false;
        double saldoProvisorio = saldo - monto;
        if (saldoProvisorio < -giroDescubierto) return false;
        saldo = saldoProvisorio;
        operaciones++;
        return true;
    }
}
