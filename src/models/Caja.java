package models;
public class Caja {
    private double saldo;

    public Caja(double saldoInicial) {

        this.saldo = saldoInicial;
    }

    public void abrir(double montoInicial) {

        saldo += montoInicial;
    }

    public void cerrar() {

        saldo = 0;
    }

    public double getSaldo() {

        return saldo;
    }

    public boolean registrarVenta(Producto producto, int cantidad) {
        if (producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            saldo += producto.getPrecio() * cantidad;
            return true;
        } else {
            System.out.println("No hay suficientes existencias de " + producto.getNombre() + ".");
            return false;
        }
    }
}
