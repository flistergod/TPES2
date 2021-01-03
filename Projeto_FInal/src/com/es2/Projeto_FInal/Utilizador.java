package com.es2.Projeto_FInal;

public class Utilizador {
    int id=0;
    String email="", name="", avatar="", password=""; String job="";

    public static int conta_ids=1;

    public Utilizador(String email, String name) throws  EmailException, UtilizadorException, CampoNullException {
        setName(name);
        this.id=conta_ids++;
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) throws CampoNullException, UtilizadorException {

        if(job!=null){
        this.job = job;}

        else{throw  new CampoNullException();}

        if(job.length()<3 || job.length()>110){
            throw  new  UtilizadorException();
        }

        else{this.job=job;}

    }

    public void setEmail(String email) throws EmailException, CampoNullException {

        if(email==null){throw  new  CampoNullException();}

        if(email.contains("@")){
            this.email = email;
        }

        else throw  new  EmailException();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UtilizadorException, CampoNullException {

        if(name!=null){
        this.name = name;}

        else{throw  new CampoNullException();}

        if(name.length()<3|| name.length()>100){
            throw  new  UtilizadorException();
        }
        else{this.name=name;}



    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws CampoNullException, UtilizadorException {

        if(password!=null){
        this.password = password;}

        else{throw  new CampoNullException();}

        if(password.length()<6 || password.length()>30){
            throw  new  UtilizadorException();
        }

        else{this.password=password;}
    }

    public void setAvatar(String avatar) throws AvatarException, CampoNullException {

        if(avatar==null){throw  new  CampoNullException();}

        if(avatar.contains("https://") && avatar.contains(".jpg")) {
            this.avatar = avatar;

        }else throw  new  AvatarException();



    }

    @Override
    public String toString() {

        return "Utilizador{" +
                "id=" + id +
                ", email=" + email +
                ", nome=" + name +
                ", avatar=" + avatar +
                ", password=" + password +
                '}';
    }
}
