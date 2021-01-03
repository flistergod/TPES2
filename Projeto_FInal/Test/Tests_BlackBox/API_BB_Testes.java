package Tests_BlackBox;

import com.es2.Projeto_FInal.*;
import org.json.JSONException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class API_BB_Testes {

    @BeforeAll
    static void setUpBeforeClass(){


    }

    @AfterAll
    static void tearDownAfterClass(){
        End e= new End();
    }

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown(){
    }

    @Test
    void ListUsers_Api() throws JSONException, API_Expetion, IOException {

        int actual;
        int expected=200;

        Interface_API interface_api= new API();
       actual= interface_api.listUsers();

       assertEquals(expected,actual);
    }

    @Test
    void singleUser_Api() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleUser(2);

        assertEquals(expected,actual);

    }


    @Test
    void singleUserNotFound_Api(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.singleUser(20);

        }catch (Exception e){actual=e.getMessage();}



        assertEquals(expected,actual);
    }

    @Test
    void singleUserId_is_0_Api(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.singleUser(0);

        }catch (Exception e){actual=e.getMessage();}


        assertEquals(expected,actual);
    }

    @Test
    void singleUserId_is_null_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api= new API();

        try{
            interface_api.singleUser(null);

        }catch (Exception e){actual=e.getMessage();}



        assertEquals(expected,actual);
    }

    @Test
    void listResources_Api() throws JSONException, API_Expetion, IOException {

        int actual;
        int expected=200;

        Interface_API interface_api= new API();
        actual= interface_api.listResources();

        assertEquals(expected,actual);
    }

    @Test
    void singleResource_Api() throws  CampoNullException, RecursoException, ResourceNotFound {

        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleResource(2);

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceId_is_0_Api(){

        String actual = "";
        String expected= "Recurso nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.singleResource(0);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceId_is_null_Api(){

        String actual = "";
        String expected= "Campo a null";

        Interface_API interface_api= new API();

        try{
            interface_api.singleResource(null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceNotFound_Api(){

        String actual = "";
        String expected= "Recurso nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.singleResource(70);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void Create_Api() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        int actual;
        int expected = 1;

        Interface_API interface_api = (Interface_API) new API();
        actual = interface_api.Create("Rodrigo","Informatico", "rodas@mail.com");

        assertNotEquals(expected, actual);
    }

    @Test
    void CreateInvalidEmail_Api(){

        String actual = "";
        String expected = "Email invalido";


        Interface_API interface_api = new API_Stub();

        try{
            interface_api.Create("Rodrigo", "Informático", "rodasmail.com");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateEmailNull_Api() {
        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Rodrigo", "Informático", null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateNameNull_Api() {
        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api = new API_Stub();

        try{
            interface_api.Create(null, "Informático", "rodas@mail.com");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateJobNull_Api() {

        String actual = "";
        String expected = "Campo a null";


        Interface_API interface_api = new API_Stub();

        try{
            interface_api.Create("Rodrigo", null, "rodas@mail.com");

        }catch (Exception e){actual=e.getMessage();}


        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPut_Api() {
        int actual=0;
        int expected=1;

        Interface_API interface_api = new API();

        try{
            actual=  interface_api.updateUserPut(4, "Rodrigo", "elmacho");


        }catch (Exception e){}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutId_is_0_Api() {
        String actual="";
        String expected="Utilizador nao encontrado";


        Interface_API interface_api = new API();

        try{
            interface_api.updateUserPut(0, "Rodas", "elmacho");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutId_is_null_Api() {

        String actual="";
        String expected="Campo a null";


        Interface_API interface_api =  new API();

        try{
            interface_api.updateUserPut(null, "Rodrigo", "elmacho");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutName_is_null_Api() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API();

        try{
            interface_api.updateUserPut(2, null, "elmacho");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutJob_is_null_Api() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Rodrigo", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutUserNotFound_Api() {

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API();

        try{
            interface_api.updateUserPut(150000, "Rodrigo", "elmacho");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUser_Api() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual;
        int expected=204;

        Interface_API interface_api= new API();

        actual= interface_api.deleteUser(2);

        assertEquals(expected,actual);
    }

    @Test
    void deleteUserUserNotFound_Api(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.deleteUser(20);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void deleteUserId_is_0_Api(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api= new API();

        try{
            interface_api.deleteUser(0);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void deleteUserId_is_null_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api= new API();

        try{
            interface_api.deleteUser(null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarSuccessfull_Api(){

        int actual=0;
        int expected=200;

        Interface_API interface_api = new API();

        try{
            actual=  interface_api.Registar("michael.lawson@reqres.in", "123456");


        }catch (Exception e){}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarInvalidEmail_Api(){

        String actual="";
        String expected="Email invalido";

        Interface_API interface_api = new API();

        try{
            interface_api.Registar("michael.lawsonreqres.in", "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarEmailNull_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api = new API();

        try{
            interface_api.Registar(null, "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void RegistarPassword_is_Null_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api = new API();
        try{
            interface_api.Registar("michael.lawson@reqres.in", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarUserInexistente_Api(){

        String actual="";
        String expected="dados de registo invalidos";

        Interface_API interface_api = new API();

        try{
            interface_api.Registar("piupiu@iol.pt", "galinha");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void LoginSuccessfull_Api(){

        int actual=0;
        int expected=200;

        Interface_API interface_api= new API();

        try{
            actual= interface_api.Login("eve.holt@reqres.in", "cityslicka");

        }catch (Exception e){}

        assertEquals(expected,actual);
    }

    @Test
    void LoginInvalidEmail_Api(){

        String actual="";
        String expected="Email invalido";

        Interface_API interface_api = new API();

        try{
            interface_api.Login("michael.lawsonreqres.in", "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void LoginEmailNull_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api = new API();
        try{
            interface_api.Login(null, "123");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void LoginPassword_is_null_Api(){

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api = new API();

        try{
            interface_api.Login("michael.lawson@reqres.in", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void LoginUnsuccessfull_Api(){

        String actual="";
        String expected="dados de login invalidos";

        Interface_API interface_api= new API();

        try{
            interface_api.Login("Afonso@regres.in", "OK123456");

        }catch (Exception e){actual=e.getMessage();}


        assertEquals(expected,actual);
    }

    @Test
    void CreateBigJob_Api() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.Create("Afonso","ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                    "ggggggggggggggggggggggggggggggggggggggggggggg", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateShortJob_Api() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.Create("Afonso","oi", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateShortName_Api() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.Create("Ru","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateBigName_Api() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.Create("Nelson Elias de Andrade 23456gtfderfgyffdgdfgfdgfdgfdgfdgdfgfdgdfgdyyyyyy" +
                    "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutBigJob_Api() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API();
        try{
            interface_api.updateUserPut(2, "Nelson", "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                    "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutShortJob_Api() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.updateUserPut(2, "Nelson", "oi");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);


    }

    @Test
    void UpdateUserPutShortName_Api() {

            String actual="";
            String expected="Utilizador invalido";

            Interface_API interface_api = (Interface_API) new API();

            try{
                interface_api.updateUserPut(2, "Ne", "Programador");


            }catch (Exception e){actual=e.getMessage();}

            assertEquals(expected, actual);
        }

    @Test
    void UpdateUserPutBigName_Api() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API();
        try{
            interface_api.updateUserPut(2, "Nelson Elias de Andrade 23456gtfderfgyffdgdfgfdgfdgfdgfdgdfgfdgdfgdyyyy" +
                    "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy", "Programador");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void RegistarBigPassword_Api(){

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API();

        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "12345678901234567890123456789012345");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }

    @Test
    void RegistarShortPassword_Api(){

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API();
        try{
            interface_api.Create("rodrigo", "boss2", "rodrigo@mail.com");
            interface_api.Registar("rodrigo@mail.com", "1");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);
    }


    @Test
    void singleUserLimiteInferior_API() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleUser(1);

        assertEquals(expected,actual);
    }

    @Test
    void singleUserLimiteSuperior_API() throws UserNotFoundException, CampoNullException, JSONException, IOException {
        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleUser(12);

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceLimiteInferior_API() throws CampoNullException, RecursoException, ResourceNotFound {
        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleResource(1);

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceLimiteSuperior_API() throws CampoNullException, RecursoException, ResourceNotFound {
        int actual;
        int expected=200;

        Interface_API interface_api= new API();

        actual= interface_api.singleResource(12);

        assertEquals(expected,actual);
    }

    @Test
    void CreateUserNameLimiteInferior_API() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {


        int expected=1;
        Interface_API interface_api =  new API();


        int actual=    interface_api.Create("Nel","programador", "Afonso@mail.com");


        assertNotEquals(expected, actual);
    }

    @Test
    void CreateUserNameLimiteSuperior_API() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {
        int expected=1;
        Interface_API interface_api =  new API();


        int actual=    interface_api.Create("Nelson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias","programador", "Afonso@mail.com");


        assertNotEquals(expected, actual);
    }

    @Test
    void CreateUserJobLimiteInferior_API() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        int expected=1;
        Interface_API interface_api =  new API();


        int actual=    interface_api.Create("Nelson Elias de Andrade","pro", "Afonso@mail.com");


        assertNotEquals(expected, actual);
    }

    @Test
    void CreateUserJobLimiteSuperior_API() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        int expected=590;
        Interface_API interface_api =  new API();


        int actual=    interface_api.Create("Nelson Elias de Andrade","proson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias1234567890", "Afonso@mail.com");


        assertNotEquals(expected, actual);
    }

    @Test
    void UpdateIdLimiteInferior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {


        int expected=1;
        Interface_API interface_api =  new API();


         int actual=   interface_api.updateUserPut(1, "Nelson Elias de Andrade", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateIdLimiteSuperior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API();


        int actual=   interface_api.updateUserPut(12, "Nelson Elias de Andrade", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateNameLimiteInferior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API();


        int actual=   interface_api.updateUserPut(2, "Nel", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateNameLimiteSuperior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API();


        int actual=   interface_api.updateUserPut(2, "Nelson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateJobLimiteInferior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {
        int expected=1;
        Interface_API interface_api =  new API();


        int actual=   interface_api.updateUserPut(2, "Nelson", "Pro");



        assertEquals(expected, actual);

    }

    @Test
    void UpdateJobLimiteSuperior_API() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API();


        int actual=   interface_api.updateUserPut(2, "Nelson", "proson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias1234567890");


        assertEquals(expected, actual);
    }

    @Test
    void deleteIdLimiteInferior_API() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual=204;

        Interface_API interface_api= new API();


           int expected= interface_api.deleteUser(1);



        assertEquals(expected,actual);

    }

    @Test
    void deleteIdLimiteSuperior_API() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual=204;

        Interface_API interface_api= new API();


        int expected= interface_api.deleteUser(12);



        assertEquals(expected,actual);
    }

    @Test
    void RegisterPasswordLimiteInferior_API() throws CampoNullException, EmailException, IOException, JSONException, RegisterException, UserNotFoundException, UtilizadorException {

    int actual=200;


        Interface_API interface_api = new API();


       int expected=     interface_api.Registar("michael.lawson@reqres.in", "123456");



        assertEquals(expected,actual);
    }

    @Test
    void RegisterPasswordLimiteSuperior_API() throws CampoNullException, EmailException, IOException, JSONException, RegisterException, UserNotFoundException, UtilizadorException {

        int actual=200;


        Interface_API interface_api = new API();


        int expected=     interface_api.Registar("michael.lawson@reqres.in", "123456789012345678901234567890");



        assertEquals(expected,actual);
    }


    private static class End {
    }
}
