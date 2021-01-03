package Tests_BlackBox;

import com.es2.Projeto_FInal.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Objects_BB_Tests {


    @BeforeAll
    static void setUpBeforeClass()   {

    }

    @AfterAll
    static void tearDownAfterClass()   {
        End e= new End();
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void CreateUser_Object() throws UtilizadorException, EmailException, CampoNullException {

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Andrade");

    assertEquals("Nelson Andrade", utilizador.getName());
}

    @Test
    void CreateUserInvalidEmail_Object(){

        String expected="Email invalido";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98gmail.com", "Nelson Andrade");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserEmailNull_Object(){

        String expected="Campo a null";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador(null, "Nelson Andrade");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserNameNull_Object() {

        String expected="Campo a null";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", null);

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserJobNull_Object() {

        String expected="Campo a null";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Andrade");
            utilizador.setJob(null);


        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserPasswordNull_Object() {

        String expected="Campo a null";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Andrade");
            utilizador.setPassword(null);


        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserInvalidAvatar_Object()  {

        String expected="imagem invalida";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Andrade");
            utilizador.setAvatar("https://ola.jg");


        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserAvatarNull_Object()  {

        String expected="Campo a null";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Andrade");
            utilizador.setAvatar(null);


        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateResourse_Object() throws  RecursoException, pantoneException, yearException, CampoNullException, colorException {

        Recurso recurso=new Recurso("banana",2018,"#FFFF00","012-C");
        assertEquals("banana",recurso.getName());
    }

    @Test
    void CreateResourseInvalidColor_Object()  {

        String expected="A cor tem de ser em hex code";
        String actual="";


        try {

            Recurso recurso=new Recurso("banana",2018,"FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseNullColor_Object()  {

        String expected="Campo a null";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2018,null,"012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseNameNull_Object()   {

        String expected="Campo a null";
        String actual="";

        try {

            Recurso recurso=new Recurso(null,2018,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateResourseInvalidPantone_Object()  {

        String expected="valor de pantone invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2018,"#FFFF00","012C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);

    }

    @Test
    void CreateResoursePantoneNull_Object()  {

        String expected="Campo a null";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2018,"#FFFF00",null);

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseYearLower2000_Object() {

        String expected="o recurso tem de ser pelo menos de 2000";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",1999,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseYearGreater2020_Object()  {

        String expected="o recurso tem de ser pelo menos de 2000";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2030,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseYearNull_Object() {

        String expected="Campo a null";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",null,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserShortName_Object()  {

        String expected="Utilizador invalido";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Ru");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserBigName_Object() {

        String expected="Utilizador invalido";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade 23456g" +
                    "tfderfgyffdgdfgfdgfdgfdgfdgdfgfdgdfgdyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);

    }

    @Test
    void CreateUserBigJob_Object(){

        String expected="Utilizador invalido";
        String actual="";

        try {

            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
            utilizador.setJob("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                    "gggggggggggggggggggggggggggg");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserShortJob_Object(){

        String expected="Utilizador invalido";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
            utilizador.setJob("oi");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserBigPassword_Object(){

        String expected="Utilizador invalido";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
            utilizador.setPassword("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                    "ggggggggggggggggggggggggggggggggg");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserShortPassword_Object(){

        String expected="Utilizador invalido";
        String actual="";

        try {
            Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
            utilizador.setPassword("oi");

        }catch (Exception e){
            actual=e.getMessage();
        }

        assertEquals(expected, actual);
    }



    @Test
    void CreateResourseShortName_Object()  {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("ba",2020,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseBigName_Object()  {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("bananananaanananananaanananananaananananananaa",2020,"#FFFF00","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseShortColor_Object()  {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2020,"#F","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseBigColor_Object() {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2020,"#FFFF0011223232323","012-C");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseShortPantone_Object()  {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2020,"#FFFF00","02-");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateResourseBigPantone_Object() {

        String expected="Recursos invalido";
        String actual="";

        try {

            Recurso recurso=new Recurso("banana",2020,"#FFFF00","012-Cgfdgfdhgdfgfdgfdgfdgfd");

        }catch (Exception e){actual=e.getMessage();}

        assertEquals(expected, actual);
    }

    @Test
    void CreateUserValorLimiteInferiorName_Object() throws EmailException, CampoNullException, UtilizadorException {

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Rui");

        assertEquals("Rui", utilizador.getName());
    }

    @Test
    void CreateUserValorLimiteSuperiorName_Object() throws EmailException, CampoNullException, UtilizadorException {

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Rui_Sinel_de_Cortes_" +
                "humorista_de_stand-up_mais_de_humor_negro_ababababababababababababababababababab");

        assertEquals("Rui_Sinel_de_Cortes_" +
                "humorista_de_stand-up_mais_de_humor_negro_ababababababababababababababababababab", utilizador.getName());
    }

    @Test
    void CreateUserValorLimiteInferiorJob_Object() throws EmailException, CampoNullException, UtilizadorException {

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Rui Sinel de Cortes");
        utilizador.setJob("rir");

        assertEquals("rir", utilizador.getJob());
    }

    @Test
    void CreateUserValorLimiteSuperiorJob_Object() throws EmailException, CampoNullException, UtilizadorException {


        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Rui Sinel de Cortes");
        utilizador.setJob("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

        assertEquals("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ggggggggggggggggggggggggggggg", utilizador.getJob());

    }

    @Test
    void CreateUserLimiteInferiorPassword_Object() throws CampoNullException, UtilizadorException, EmailException {

        String expected="gggggg";

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
        utilizador.setPassword(expected);
        assertEquals(expected, utilizador.getPassword());
    }

    @Test
    void CreateUserLimiteSuperiorPassword_Object() throws EmailException, CampoNullException, UtilizadorException {

        String expected="gggggggggggggggggggggggggggggg";

        Utilizador utilizador = new Utilizador("nelson.andrade98@gmail.com", "Nelson Elias de Andrade");
        utilizador.setPassword(expected);
        assertEquals(expected, utilizador.getPassword());
    }

    @Test
    void CreateResourceLimiteInferiorName_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {

        String expected="ban";


            Recurso recurso=new Recurso("ban",2020,"#FFFF00","012-C");

        assertEquals(expected, recurso.getName());
    }


    @Test
    void CreateResourceLimiteSuperiorName_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {


        String expected="banananananananananananananana";


        Recurso recurso=new Recurso("banananananananananananananana",2020,"#FFFF00","012-C");

        assertEquals(expected, recurso.getName());
    }

    @Test
    void CreateResourceLimiteInferiorYear_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {

        int expected=2000;


        Recurso recurso=new Recurso("banana",2000,"#FFFF00","012-C");

        assertEquals(expected, recurso.getYear());
    }

    @Test
    void CreateResourceLimiteSuperiorYear_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {

        int expected=2020;


        Recurso recurso=new Recurso("banana",2020,"#FFFF00","012-C");

        assertEquals(expected, recurso.getYear());
    }

    @Test
    void CreateResourceLimiteInferiorPantone_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {

        String expected="012-C";


        Recurso recurso=new Recurso("banana",2010,"#FFFF00","012-C");

        assertEquals(expected, recurso.getPantone_value());
    }

    @Test
    void CreateResourceLimiteSuperiorPantone_Object() throws RecursoException, pantoneException, yearException, CampoNullException, colorException {

        String expected="012-CCCCCC";


        Recurso recurso=new Recurso("banana",2010,"#FFFF00","012-CCCCCC");

        assertEquals(expected, recurso.getPantone_value());
    }

    private static class End {
    }
}
