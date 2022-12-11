package co.edu.unab.misiontic.nivelacionservicios.entity;

public class Computador {
    private long id;
    private String codigo;
    private String marca;
    private long serial;
    private String SO;
    private int ram_gb;

    public Computador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public int getRam_gb() {
        return ram_gb;
    }

    public void setRam_gb(int ram_gb) {
        this.ram_gb = ram_gb;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", marca='" + marca + '\'' +
                ", serial=" + serial +
                ", SO='" + SO + '\'' +
                ", ram_gb=" + ram_gb +
                '}';
    }
}
