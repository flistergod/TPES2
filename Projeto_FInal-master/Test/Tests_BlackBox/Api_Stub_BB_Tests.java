package Tests_BlackBox;

import com.es2.Projeto_FInal.*;
import org.json.JSONException;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Api_Stub_BB_Tests {
    @BeforeAll
    static void setUpBeforeClass()   {

    }

    @AfterAll
    static void tearDownAfterClass() {
        End e= new End();
    }

    @BeforeEach
    void setUp() throws Exception {
        Aplicacao.prePopular(Aplicacao.users, Aplicacao.users_registados, Aplicacao.resources);
    }

    @AfterEach
    void tearDown(){
        Aplicacao.users.clear();
        Aplicacao.users_registados.clear();
        Aplicacao.resources.clear();
        Utilizador.conta_ids=1;
        Recurso.conta_ids=1;
    }

    @Test
    void ListUsers_Api_Stub() throws  JSONException, API_Expetion, IOException {

        int actual;
        int expected = 1;

        Interface_API interface_api =  new API_Stub();
        actual = interface_api.listUsers();

        assertEquals(expected, actual);

    }

    @Test
    void singleUser_Api_Stub() throws  IOException,  CampoNullException, JSONException,  UserNotFoundException {

        int actual;
        int expected = 1;

        Interface_API interface_api =  new API_Stub();
        actual = interface_api.singleUser(1);

        assertEquals(expected, actual);


    }

    @Test
    void singleUserNotFound_Api_Stub(){

        String actual = "";
        String expected = "Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.singleUser(20);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void singleUserId_is_0_Api_Stub(){

        String actual = "";
        String expected = "Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.singleUser(0);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void singleUserId_is_null_Api_Stub()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.singleUser(null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void listResources_Api_Stub() throws  JSONException, API_Expetion, IOException {

        int actual;
        int expected = 1;

        Interface_API interface_api =  new API_Stub();
        actual = interface_api.listResources();

        assertEquals(expected, actual);
    }

    @Test
    void singleResource_Api_Stub() throws CampoNullException, RecursoException,  ResourceNotFound {

        int actual;
        int expected = 1;

        Interface_API interface_api =  new API_Stub();
        actual = interface_api.singleResource(1);

        assertEquals(expected, actual);
    }

    @Test
    void singleResourceId_is_0_Api_Stub()  {

        String actual = "";
        String expected = "Recurso nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.singleResource(0);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void singleResourceId_is_null_Api_Stub()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.singleResource(null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void singleResourceNotFound_Api_Stub() {


        String actual = "";
        String expected = "Recurso nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.singleResource(20);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void Create_Api_Stub() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion{

        int actual;
        int expected = 1;

        Interface_API interface_api =  new API_Stub();

        actual = interface_api.Create("Afonso","Informatico", "Afonso@mail.com");

        assertEquals(expected, actual);
    }

    @Test
    void CreateInvalidEmail_Api_Stub()  {

        String actual = "";
        String expected = "Email invalido";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Afonso", "Informático", "Afonsomail.com");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateEmailNull_Api_Stub()  {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.Create("Afonso", "Informático", null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateNameNull_Api_Stub() {

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{

         interface_api.Create(null,"Informatico", "Afonso@mail.com");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateJobNull_Api_Stub(){

        String actual = "";
        String expected = "Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
             interface_api.Create("Afonso",null, "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateUnsuccessfull_Api_Stub(){

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Create("Afonso","macho", "michael.lawson@reqres.in");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPut_Api_Stub() {

        int actual=0;
        int expected=1;

        Interface_API interface_api = (Interface_API) new API_Stub();

        try{
          actual=  interface_api.updateUserPut(4, "Nelson", "boss");


        }catch (Exception e){}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutId_is_0_Api_Stub(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
           interface_api.updateUserPut(0, "Nelson", "boss");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutId_is_null_Api_Stub()  {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(null, "Nelson", "boss");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void UpdateUserPutName_is_null_Api_Stub()  {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, null, "boss");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutJob_is_null_Api_Stub(){

        String actual="";
        String expected="Campo a null";


        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(2, "Nelson", null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutUserNotFound_Api_Stub() {

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.updateUserPut(20, "Nelson", "boss");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUser_Api_Stub()  {

        int actual=0;
        int expected=2;


        Interface_API interface_api = (Interface_API) new API_Stub();

        try{

          actual=  interface_api.deleteUser(2);


        }catch (Exception e){}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserUserNotFound_Api_Stub(){

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.deleteUser(20);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserId_is_0_Api_Stub() {

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.deleteUser(0);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void deleteUserId_is_null_Api_Stub() {

        String actual="";
        String expected="Campo a null";

        Interface_API interface_api =  new API_Stub();

        try{
            interface_api.deleteUser(null);


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void RegistarSuccessfull_Api_Stub(){

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
    void RegistarInvalidEmail_Api_Stub() {


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
    void RegistarEmailNull_Api_Stub() {

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
    void RegistarPassword_is_Null_Api_Stub() {

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
    void RegistarUserInexistente_Api_Stub() {

        String actual="";
        String expected="Utilizador nao encontrado";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Registar("jp230@mail.com", "kek12345");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected,actual);

    }

    @Test
    void RegistarEmail_ja_Existe_Api_Stub() {

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
    void LoginSuccessfull_Api_Stub() {

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
    void LoginInvalidEmail_Api_Stub() {

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
    void LoginEmailNull_Api_Stub() {

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
    void LoginPassword_is_null_Api_Stub() {

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
    void Login_Wrong_Password_Api_Stub() {

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
    void CreateBigJob_Api_Stub() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();
        try{
            interface_api.Create("Afonso","ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                    "ggggggggggggggggggggggggggggggggggggggggggggggggggggg", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateShortJob_Api_Stub() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Create("Afonso","oi", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateShortName_Api_Stub() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Create("Ru","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateBigName_Api_Stub() {

        String actual = "";
        String expected = "Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.Create("Nelson Elias de Andrade 23456gtfderfgyffdgdfgfdgfdgfdgfdgdfgfdg" +
                    "dfgdyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy","programador", "Afonso@mail.com");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutBigJob_Api_Stub() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api = (Interface_API) new API_Stub();

        try{

            interface_api.updateUserPut(2, "Nelson", "gggggggggggggggggggggggggggggggggggggg" +
                    "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutShortJob_Api_Stub() {

        String actual="";
        String expected="Utilizador invalido";


        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.updateUserPut(2, "Nelson", "oi");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutShortName_Api_Stub() {

        String actual="";
        String expected="Utilizador invalido";

        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.updateUserPut(2, "Ne", "Programador");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void UpdateUserPutBigName_Api_Stub() {

        String actual="";
        String expected="Utilizador invalido";


        Interface_API interface_api =  new API_Stub();

        try{

            interface_api.updateUserPut(2, "Nelson Elias de Andrade 23456gtfderfgyffdgdfgfdgfdgfdgfdgdfgfdg" +
                    "dfgdyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy", "Programador");


        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }



    @Test
    void singleUserLimiteInferior_API_Stub() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual;
        int expected=1;

        Interface_API interface_api= new API_Stub();

        actual= interface_api.singleUser(1);

        assertEquals(expected,actual);
    }

    @Test
    void singleUserLimiteSuperior_API_Stub() throws UserNotFoundException, CampoNullException, JSONException, IOException {
        int actual;
        int expected=12;

        Interface_API interface_api= new API_Stub();

        actual= interface_api.singleUser(12);

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceLimiteInferior_API_Stub() throws CampoNullException, RecursoException, ResourceNotFound {
        int actual;
        int expected=1;

        Interface_API interface_api= new API_Stub();

        actual= interface_api.singleResource(1);

        assertEquals(expected,actual);
    }

    @Test
    void singleResourceLimiteSuperior_API_Stub() throws CampoNullException, RecursoException, ResourceNotFound {
        int actual;
        int expected=12;

        Interface_API interface_api= new API_Stub();

        actual= interface_api.singleResource(12);

        assertEquals(expected,actual);
    }

    @Test
    void CreateUserNameLimiteInferior_API_Stub() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {


        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=    interface_api.Create("Nel","programador", "Afonso@mail.com");


        assertEquals(expected, actual);
    }

    @Test
    void CreateUserNameLimiteSuperior_API_Stub() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {
        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=    interface_api.Create("Nelson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias","programador", "Afonso@mail.com");


        assertEquals(expected, actual);
    }

    @Test
    void CreateUserJobLimiteInferior_API_Stub() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=    interface_api.Create("Nelson Elias de Andrade","pro", "Afonso@mail.com");


        assertEquals(expected, actual);
    }

    @Test
    void CreateUserJobLimiteSuperior_API_Stub() throws EmailException, IOException, JSONException, UtilizadorException, AvatarException, CampoNullException, API_Expetion {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=    interface_api.Create("Nelson Elias de Andrade","proson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias1234567890", "Afonso@mail.com");


        assertEquals(expected, actual);
    }

    @Test
    void UpdateIdLimiteInferior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {


        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(1, "Nelson Elias de Andrade", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateIdLimiteSuperior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(12, "Nelson Elias de Andrade", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateNameLimiteInferior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(2, "Nel", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateNameLimiteSuperior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(2, "Nelson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias", "Programador");



        assertEquals(expected, actual);
    }

    @Test
    void UpdateJobLimiteInferior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {
        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(2, "Nelson", "Pro");



        assertEquals(expected, actual);

    }

    @Test
    void UpdateJobLimiteSuperior_API_Stub() throws UserNotFoundException, UtilizadorException, CampoNullException, JSONException, IOException {

        int expected=1;
        Interface_API interface_api =  new API_Stub();


        int actual=   interface_api.updateUserPut(2, "Nelson", "proson Elias de Andrade, qwertyuiopasdfghjklcvbnm ,._" +
                "1234567890'qwertyuioasdfghjklpçcxzvbnmwertyuias1234567890");


        assertEquals(expected, actual);
    }

    @Test
    void deleteIdLimiteInferior_API_Stub() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual=1;

        Interface_API interface_api= new API_Stub();


        int expected= interface_api.deleteUser(1);



        assertEquals(expected,actual);

    }

    @Test
    void deleteIdLimiteSuperior_API_Stub() throws UserNotFoundException, CampoNullException, JSONException, IOException {

        int actual=12;

        Interface_API interface_api= new API_Stub();


        int expected= interface_api.deleteUser(12);



        assertEquals(expected,actual);
    }

    @Test
    void RegisterPasswordLimiteInferior_API_Stub() throws CampoNullException, EmailException, IOException, JSONException, RegisterException, UserNotFoundException, UtilizadorException, API_Expetion, AvatarException {

        int actual=3;


        Interface_API interface_api = new API_Stub();


        interface_api.Create("Nelson", "boss", "nelson@mail.com");
      int   expected=  interface_api.Registar("nelson@mail.com", "123456");




        assertEquals(expected,actual);
    }

    @Test
    void RegisterPasswordLimiteSuperior_API_Stub() throws CampoNullException, EmailException, IOException, JSONException, RegisterException, UserNotFoundException, UtilizadorException {

        int actual=200;


        Interface_API interface_api = new API();


        int expected=     interface_api.Registar("michael.lawson@reqres.in", "123456789012345678901234567890");



        assertEquals(expected,actual);
    }



    private static class End {
    }
}
