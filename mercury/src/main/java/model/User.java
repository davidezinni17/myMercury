package model;


public class User {

    private String nome;
    private String suranme;
    private String email;
    private String age;
    private String pass;

    public User(){}

    public User(String nome, String suranme, String email, String age, String pass) {
        this.nome = nome;
        this.suranme = suranme;
        this.email = email;
        this.age = age;
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSuranme() {
        return suranme;
    }

    public void setSuranme(String suranme) {
        this.suranme = suranme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
