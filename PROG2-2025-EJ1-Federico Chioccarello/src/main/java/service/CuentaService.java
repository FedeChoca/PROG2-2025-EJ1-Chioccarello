package service;

import java.util.ArrayList;
import java.util.List;

import dto.Cuenta;

public class CuentaService {

    private static CuentaService instancia;
    private final List<Cuenta> cuentas;

    private CuentaService() {
        cuentas = new ArrayList<>();
    }

    public static synchronized CuentaService getInstancia() {
        if (instancia == null) {
            instancia = new CuentaService();
        }
        return instancia;
    }

    public synchronized void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public synchronized boolean agregarSaldo(int index, double monto) {
        if (esValido(index)) {
            return cuentas.get(index).agregarSaldo(monto);
        }
        return false;
    }

    public synchronized boolean quitarSaldo(int index, double monto) {
        if (esValido(index)) {
            return cuentas.get(index).quitarSaldo(monto);
        }
        return false;
    }

    public synchronized double consultarSaldo(int index) {
        if (esValido(index)) {
            return cuentas.get(index).getSaldo();
        }
        return -1;
    }

    public synchronized int getOperaciones(int index) {
        if (esValido(index)) {
            return cuentas.get(index).getOperaciones();
        }
        return -1;
    }

    private boolean esValido(int index) {
        return index >= 0 && index < cuentas.size();
    }

}
