package co.com.Automatizacion.models.login;

public class DatosLogin {

    private String email;
    private String password;

    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public String setEmail(String email){return this.email=email;}
    public String setPassword(String password){return this.password=password;}
    public void MostrarDatos(String email,String password){
        this.email=email;
        this.password=password;
    }
}
