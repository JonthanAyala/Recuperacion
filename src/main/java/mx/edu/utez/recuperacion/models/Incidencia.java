package mx.edu.utez.recuperacion.models;

public class Incidencia {

    /*
    * id int primary key auto_increment,
    titulo varchar(100),
    descripcion varchar(255),
    tipo varchar(100),
    estado varchar(30),
    mensaje varchar(255),
    fk_user int,
    * */

    private Long id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private String estado;
    private String mensaje;
    private Long fk_user;

    public Incidencia() {
    }

    public Incidencia(Long id, String titulo, String descripcion, String tipo, String estado,String mensaje, Long fk_user) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.mensaje = mensaje;
        this.fk_user = fk_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getFk_user() {
        return fk_user;
    }

    public void setFk_user(Long fk_user) {
        this.fk_user = fk_user;
    }
}
