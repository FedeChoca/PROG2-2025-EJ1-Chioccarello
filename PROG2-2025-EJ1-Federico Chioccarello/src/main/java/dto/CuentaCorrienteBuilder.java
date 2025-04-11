package dto;

public class CuentaCorrienteBuilder {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    private CuentaCorrienteBuilder(Builder builder) {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
        this.giroDescubierto = builder.giroDescubierto;
    }

    public static class Builder {
        private double saldo;
        private int operaciones;
        private double giroDescubierto;

        public Builder saldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder operaciones(int operaciones) {
            this.operaciones = operaciones;
            return this;
        }

        public Builder giroDescubierto(double giroDescubierto) {
            this.giroDescubierto = giroDescubierto;
            return this;
        }

        public CuentaCorrienteBuilder build() {
            return new CuentaCorrienteBuilder(this);
        }
    }
}
