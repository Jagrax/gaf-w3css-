package gaf.entity;

public enum Estados {
    ARREGLANDO(0, "Arreglando", "yellow"),
    DISPONIBLE(1, "Disponible", "green"),
    EN_DEUDA(2, "En deuda", "blue"),
    EN_PRODUCCION(3, "En produccion", "orange"),
    NO_DISPONIBLE(4, "No disponible", "red");

    private Integer id;
    private String name;
    private String color;

    Estados(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}