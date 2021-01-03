package Tests_WhiteBox;

import com.es2.Projeto_FInal.*;
import org.json.JSONException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Stub_WB_Tests {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        End e= new End();
    }

    @BeforeEach
    void setUp() throws Exception {
        Aplicacao.prePopular(Aplicacao.users, Aplicacao.users_registados, Aplicacao.resources);
    }

    @AfterEach
    void tearDown() throws Exception {
        Aplicacao.users.clear();
        Aplicacao.users_registados.clear();
        Aplicacao.resources.clear();
        Utilizador.conta_ids=1;
        Recurso.conta_ids=1;
    }

    @Test
    void ListUsers_for() throws JSONException, API_Expetion, IOException {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.listUsers();

        assertEquals(1, aux);

    }

    @Test
    void singleUserifnull() {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {

            interface_api.singleUser(null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void singleUserifid_0()  {


        String actual = "";
        String expected = "Utilizador nao encontrado";

        Interface_API interface_api = new API_Stub();

        try {

            interface_api.singleUser(0);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void singleUserif_id_lower(){

        String actual = "";
        String expected = "Utilizador nao encontrado";

        Interface_API interface_api = new API_Stub();
        try {
            interface_api.singleUser(-1);
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void singleUsertry() throws  IOException, CampoNullException, JSONException, UserNotFoundException {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.singleUser(1);

        assertEquals(1, aux);
    }

    @Test
    void listResourcesfor() throws  JSONException, API_Expetion, IOException {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.listResources();

        assertEquals(1, aux);

    }

    @Test
    void singleResourceifnull(){

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.singleResource(null);
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);


    }

    @Test
    void singleResourceifid_0(){

        String actual = "";
        String expected = "Recurso nao encontrado";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.singleResource(0);
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void singleResourceif_id_lower(){

        String actual = "";
        String expected = "Recurso nao encontrado";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.singleResource(-1);
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void singleResourcetry() throws  CampoNullException,  RecursoException, ResourceNotFound {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.singleResource(1);

        assertEquals(1, aux);


    }

    @Test
    void Createfor() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.Create("Afonso", "Informatico", "afonso@mail.com");

        assertNotEquals(1, aux);
    }

    @Test
    void CreateifEmailNull()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.Create("Afonso", "Informatico", null);
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateifEmail()  {

        String actual = "";
        String expected = "Email invalido";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.Create("Afonso", "Informatico", "afonsomail.com");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateifName()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.Create(null, "Informatico", "afonso@mail.com");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateifJob() {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.Create("Afonso", null, "afonso@mail.com");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPut_try() throws IOException, CampoNullException, JSONException, UtilizadorException, UserNotFoundException {

        Interface_API interface_api = new API_Stub();
        int aux = interface_api.updateUserPut(1, "Afonso", "informatico");

        assertEquals(1, aux);


    }

    @Test
    void UpdateUserPut_ifId0()  {

        String actual = "";
        String expected = "Utilizador nao encontrado";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.updateUserPut(0, "Afonso", "informatico");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutIfIdNull()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.updateUserPut(null, "Afonso", "informatico");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutIfNameNull()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try {
            interface_api.updateUserPut(1, null, "informatico");
        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutIfJobNull()   {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Nelson", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserifIdNull()  {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api = (Interface_API) new API_Stub();

        try{
            interface_api.deleteUser(null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserUserifId0() {

        String actual="";
        String expected="Utilizador nao encontrado";


        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.deleteUser(0);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserTry() {

        int actual=0;
        int expected=2;


        Interface_API interface_api =  new API_Stub();

        try{
            actual=  interface_api.deleteUser(2);


        }catch (Exception e){}

        assertEquals(expected, actual);
    }

    @Test
    void Registarfor() {

        int actual=0;
        int expected=3;


        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Nelson", "boss", "nelson@mail.com");
            actual=  interface_api.Registar("nelson@mail.com", "123456");


        }catch (Exception e){}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarifInvalidEmail()  {

        String actual="";
        String expected="Email invalido";


        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Create("Nelson2", "boss2", "nelson2@mail.com");
            interface_api.Registar("nelson2mail.com", "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void RegistarifNullEmail() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rODRIGO", "boss2", "rODRIGO@mail.com");
            interface_api.Registar(null, "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarifNullPassword() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarExceptionUserNotFound() {

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Registar("jp230@mail.com", "kek12345");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void RegistarException() {

        String actual="";
        String expected="dados de registo invalidos";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            interface_api.Registar("rodrigo@mail.com", "123456");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void LoginFor() {

        int actual=0;
        int expected=1;

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            actual=interface_api.Login("rodrigo@mail.com", "123456");


        }catch (Exception e){}

        assertEquals(expected,actual);
    }

    @Test
    void LoginifEmailInvalid() {

        String actual="";
        String expected="Email invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            interface_api.Login("rodrigomail.com", "123456");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void LoginifEmailNull() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            interface_api.Login(null, "123456");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void LoginifPasswordNull() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            interface_api.Login("rodrigo@mail.com", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void Login_Wrong_Password() {

        String actual="";
        String expected="dados de login invalidos";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "123456");
            interface_api.Login("rodrigo@mail.com", "1234567");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void CreateBigJob() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Afonso","fdssgfdgdffgdfgfgfdgfdgfdghhfgdhfgfggfdgdfgfdgfdgfdgfdgfgdfgdfgdgfd" +
                    "gfsdfdsfdsfdfsdfsdfsdfsdfsdfdsfsdfsdffdgfdgfdgfdg", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateShortJob() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Afonso","a", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateShortName() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("A","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateBigName() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Afonso da Pina FildaLGO Afonso da Pina Fidalgo Afonso da Pina Fidalgo Af" +
                    "onso da Pina Fidalgo Afonso da Pina Fidalgo ","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutBigJob() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Nelson", "fdssgfdgdffgdfgfgfdgfdgfdghhfgdhfgfggfdgdfgfdgfdgfdgf" +
                    "dgfgdfgdfgdgfdgfsdfdsfdsfdfsdfsdfsdfsdfsdfdsfsdfsdffdgfdgfdgfdg");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutShortJob() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Nelson", "d");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutShortName() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Ne", "professor");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutBigName() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Afonso da Pina FildaLGO Afonso da Pina Fidalgo Afons" +
                    "o da Pina Fidalgo Afonso da Pina Fidalgo Afonso da Pina Fidalgo ", "professor");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void RegistarBigPassword(){

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "12345678901234567890123456789012345");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarShortPassword(){

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "1");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    private static class End {
    }
}
