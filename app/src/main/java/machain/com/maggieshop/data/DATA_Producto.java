package machain.com.maggieshop.data;

public class DATA_Producto {
    double precio, costo;
    String nombre, descripcion;
    int existencia, idcategoria;

    public DATA_Producto(double precio, double costo, String nombre, String descripcion, int existencia) {
        this.precio = precio;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencia = existencia;
    }

    public DATA_Producto(String precio, String costo, String nombre, String descripcion, int existencia) {
        this.precio = Double.parseDouble(precio);
        this.costo = Double.parseDouble(costo);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencia = existencia;
    }

    public DATA_Producto() {
        this.precio = 0;
        this.costo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.existencia = 0;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPrecio(String precio) {
        this.precio = Double.parseDouble(precio);
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCosto(String costo) {
        this.costo = Double.parseDouble(costo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = Integer.parseInt(existencia);
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
}
