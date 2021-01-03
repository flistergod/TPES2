package com.es2.Projeto_FInal;

import org.json.JSONException;

import java.io.IOException;

public interface Interface_API {

    public int listUsers() throws IOException, JSONException, API_Expetion;

    public int singleUser(Integer id) throws IOException, JSONException, UserNotFoundException, CampoNullException;

    public int listResources() throws IOException, JSONException, API_Expetion;

    public int singleResource(Integer id) throws ResourceNotFound, RecursoException, CampoNullException;

    public int Create(String name, String job, String email) throws IOException, JSONException, API_Expetion, AvatarException, EmailException, UtilizadorException, CampoNullException;

    public int updateUserPut(Integer id, String name, String job) throws IOException, JSONException, UserNotFoundException, UtilizadorException, CampoNullException;

    public int deleteUser(Integer id) throws IOException, JSONException, UserNotFoundException, CampoNullException;

    public int Registar(String email, String password) throws IOException, JSONException, RegisterException, UtilizadorException, EmailException, CampoNullException, UserNotFoundException;

    public int Login(String email, String password) throws LoginException, EmailException, RegisterException, CampoNullException, UtilizadorException;


}
