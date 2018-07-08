package DTO;

import java.io.Serializable;

public class AdmDTO implements Serializable {
    private int cadm;
    private String username;
    private String password;

    public int getCadm() {
        return cadm;
    }

    public void setCadm(int cadm) {
        this.cadm = cadm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
