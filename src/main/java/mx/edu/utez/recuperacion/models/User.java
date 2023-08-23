package mx.edu.utez.recuperacion.models;

public class User {

    private Long id_user;
    private String role;
    private String name;
    private String lastname;
    private String mail;
    private String pass;

    public User() {
    }

    public User(Long id_user, String role, String name, String lastname, String mail, String pass) {
        this.id_user = id_user;
        this.role = role;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.pass = pass;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
