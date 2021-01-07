package com.es2.Projeto_FInal;

import static com.es2.Projeto_FInal.Aplicacao.*;

public class API_Stub implements Interface_API {

    public int listUsers(){

        int aux=0;
        for(int i = 0; i< users.size(); i++){
            aux=1;
           // System.out.println("id: "+users.get(i).getId());
            //System.out.println("email: "+users.get(i).getEmail());
            //System.out.println("nome: "+users.get(i).getName()+"\n");


        }
        return aux;
    }

    public int singleUser(Integer id) throws UserNotFoundException, CampoNullException {

        int idUser;

        if (id == null) {
            throw new CampoNullException();
        }

        if(id<=0){
            throw new UserNotFoundException();
        }


        try {
            idUser = users.get(id - 1).getId();
            //System.out.println("id: " + id);
            //System.out.println("id: " + users.get(id - 1).getId());
            //System.out.println("email: " + users.get(id - 1).getEmail());
            //System.out.println("ultimo nome: "+users.get(id-1).getName()+"\n");

        }catch (Exception e){throw  new  UserNotFoundException();}

        return idUser;
    }

    public int listResources(){

        int aux=0;
        for(int i = 0; i< resources.size(); i++){
            aux=1;
           // System.out.println("id: "+resources.get(i).getId());
            //System.out.println("nome: "+resources.get(i).getName());
            //System.out.println("ano: "+resources.get(i).getYear());
            //System.out.println("cor: "+resources.get(i).getColor());
            //System.out.println("pantone_value: "+resources.get(i).getPantone_value()+"\n");

        }

        return aux;


    }

    public int singleResource(Integer id) throws  ResourceNotFound, CampoNullException {

        int idResource;

        if (id == null) {
            throw new CampoNullException();
        }


        if(id<=0){
            throw new ResourceNotFound();
        }



        try {
            idResource = resources.get(id - 1).getId();
            //System.out.println("id: "+resources.get(id - 1).getId());
            //System.out.println("nome: "+resources.get(id - 1).getName());
            //System.out.println("ano: "+resources.get(id - 1).getYear());
            //System.out.println("cor: "+resources.get(id - 1).getColor());
            //System.out.println("pantone_value: "+resources.get(id - 1).getPantone_value()+"\n");

        }catch (Exception e){throw  new ResourceNotFound();}

        return idResource;
    }

    public int Create(String name, String job, String email) throws AvatarException, EmailException, UtilizadorException, CampoNullException {

        int aux=0;


        if(email==null){throw  new  CampoNullException();}

        if(!email.contains("@")){throw  new  EmailException();}

        if(job==null){throw new CampoNullException();}

        if(name==null){throw new CampoNullException();}

        else{    if(name.length()<3|| name.length()>100) {
            throw new UtilizadorException();
        }

            if(job.length()<3 || job.length()>110){
                throw  new  UtilizadorException();
            }
        }



        for(int i =0;i<users.size();i++){

            aux=1;

            if(users.get(i).getEmail().equals(email)){
                throw  new UtilizadorException();
            }
        }

        Utilizador utilizador= new Utilizador(email, name);
        utilizador.setJob(job);
        users.add(utilizador);

        return aux;
    }

    public int updateUserPut(Integer id, String name, String job) throws UserNotFoundException, UtilizadorException, CampoNullException {
    int aux=0;

        if( id==null){throw new CampoNullException();}

        if(id<=0){
            throw new UserNotFoundException();
        }

        if(job==null){throw  new CampoNullException();}

        if(name==null){ throw new CampoNullException();}

        if(name.length()<3|| name.length()>100) {
            throw new UtilizadorException();
        }

        if(job.length()<3 || job.length()>110){
            throw  new  UtilizadorException();
        }

        try {

            users.get(id - 1).setName(name);
            users.get(id - 1).setJob(job);
            aux=1;

        }catch (Exception e){throw  new UserNotFoundException();}

        return aux;
    }

    public int deleteUser(Integer id) throws UserNotFoundException, CampoNullException {
            int aux=0;

        if (id == null) {
            throw new CampoNullException();
        }

        if(id<=0){
            throw new UserNotFoundException();
        }


        try {
            aux=id;
            users.remove(id-1);
            users_registados.remove(id-1);

        }catch (Exception e){throw new UserNotFoundException();}

        return aux;
    }

    public int Registar(String email, String password) throws UtilizadorException, RegisterException, EmailException, CampoNullException, UserNotFoundException {


        if(email==null){throw  new  CampoNullException();}

        if(!email.contains("@")){throw  new  EmailException();}

        if(password==null){throw  new CampoNullException();}

        if(password.length()<6 || password.length()>30){
            throw  new  UtilizadorException();
        }

        int aux=0, id=0;

        for(int i =0;i<users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                aux=1;
                id=i;
            }
        }

        if(aux==1){

            for(int i =0;i<users_registados.size();i++){
                aux=2;
                if(users_registados.get(i).getEmail().equals(email)){
                    throw  new RegisterException();

                }
            }
        }
        else{throw  new UserNotFoundException();}

        if(aux>1)
        {
            users.get(id).setPassword(password);
            users_registados.add(users.get(id));
            aux=3;
        }

        return aux;}

    public int Login(String email, String password) throws EmailException, LoginException, CampoNullException, UtilizadorException {

        if(email==null){throw  new  CampoNullException();}
        if(!email.contains("@")){throw  new  EmailException();}

        if(password==null){throw  new CampoNullException();}

        if(password.length()<6 || password.length()>30){
            throw  new  UtilizadorException();
        }

        int aux=0;

        for(int i=0;i<users_registados.size();i++){
            if(users_registados.get(i).getEmail().equals(email) && users_registados.get(i).getPassword().equals(password)){
                aux=1;
            }
        }

        if(aux==0){throw  new LoginException();}
        return aux;}

}
