package com.github.pol.una.traceability.entities;

public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column (name = "fecha_inicio")
    private String fecha_inicio;

    @Column (name = "fecha_fin")
    private String fecha_fin;

    @Id
    @Column (name = "id_lider")
    private long id_lider;

    @Column (name = "fecha_alta")
    private String fecha_alta;

    @Column (name = "fecha_modificacion")
    private String fecha_modificacion;

    @Column (name = "usuario_alta")
    private long usuario_alta;

    @Column (name = "usuario_modificacion")
    private long usuario_modificacion;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String descripcion) {
        this.fecha_fin = fecha_fin;
    }

    public long getId_lider() {
        return id_lider;
    }

    public void setId_lider(long id_lider) {
        this.id_lider = id_lider;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public long getUsuario_alta() {
        return usuario_alta;
    }

    public void setUsuario_alta(long usuario_alta) {
        this.usuario_alta = usuario_alta;
    }

}
