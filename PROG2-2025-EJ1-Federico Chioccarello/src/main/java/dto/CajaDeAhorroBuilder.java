package dto;

public class CajaDeAhorroBuilder {
    private double saldo;
    private int operaciones;

    private CajaDeAhorroBuilder(Builder builder) {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
    }

    public static class Builder {
        private double saldo;
        private int operaciones;

        public Builder saldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder operaciones(int operaciones) {
            this.operaciones = operaciones;
            return this;
        }

        public CajaDeAhorroBuilder build() {
            return new CajaDeAhorroBuilder(this);
        }
    }
}
