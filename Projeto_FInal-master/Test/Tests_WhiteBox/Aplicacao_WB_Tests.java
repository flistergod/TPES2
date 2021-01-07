package Tests_WhiteBox;

import com.es2.Projeto_FInal.*;
import org.json.JSONException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Aplicacao_WB_Tests {


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
    void tearDown()  {
        Aplicacao.users.clear();
        Aplicacao.users_registados.clear();
        Aplicacao.resources.clear();
        Utilizador.conta_ids=1;
        Recurso.conta_ids=1;
    }

    @Test
    void CreateMenu() throws Exception {

        Aplicacao AP = new Aplicacao();
        int op =  AP.Menu(0,2);

        assertEquals(0,op);

    }

    @Test
    void subMenu() throws Exception {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(2,0);

        assertEquals(0,op);
    }

    @Test
    void switchLogin() throws Exception {

        Aplicacao AP = new Aplicacao();
        int op =  AP.Menu(1,2);

        assertEquals(1,op);
    }

    @Test
    void switchRegistar() throws Exception {

        Aplicacao AP = new Aplicacao();
        int op =  AP.Menu(2,2);

        assertEquals(2,op);
    }

    @Test
    void switchCriarUser() throws Exception {

        Aplicacao AP = new Aplicacao();
        int op =  AP.Menu(3,2);

        assertEquals(3,op);
    }

    @Test
    void switchsubMenusingleResourse() throws IOException, CampoNullException, JSONException, pantoneException, UserNotFoundException, RecursoException, colorException, yearException, UtilizadorException, API_Expetion, ResourceNotFound, EmailException, AvatarException {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(1,1);

        assertEquals(1,op);
    }

    @Test
    void switchsubMenuListarRecursos() throws EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(1,2);

        assertEquals(2,op);
    }

    @Test
    void switchsubMenusingleUser() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(1,3);

        assertEquals(3,op);
    }

    @Test
    void switchsubMenuListarUsers() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(1,4);

        assertEquals(4,op);
    }

    @Test
    void switchsubMenuCriarRecurso() throws IOException, CampoNullException, JSONException, pantoneException, UserNotFoundException, RecursoException, colorException, yearException, UtilizadorException, API_Expetion, ResourceNotFound, EmailException, AvatarException {

        Aplicacao AP = new Aplicacao();
        int op =  AP.subMenu(1,5);

        assertEquals(5,op);
    }

    @Test
    void switchupdateUserSuccessfulll() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int aux=AP.subMenu(6,6);

        assertEquals(6,aux);

    }


    @Test
    void switchsubMenuDeleteUser() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int aux=AP.subMenu(7,7);

        assertEquals(7,aux);
    }


    @Test
    void switchsubMenuoSair() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion, ResourceNotFound, UserNotFoundException {

        Aplicacao AP = new Aplicacao();
        int aux=AP.subMenu(0,0);

        assertEquals(0,aux);

    }

    @Test
    void PopularUsers() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion {

        Aplicacao AP = new Aplicacao();
        Aplicacao.prePopular(Aplicacao.users, AP.users_registados, AP.resources);

        assertEquals(12, AP.users.size());
    }

    @Test
    void PopularUsers_registados() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion {

        Aplicacao AP = new Aplicacao();
        Aplicacao.prePopular(Aplicacao.users, AP.users_registados, AP.resources);

        assertEquals(12, AP.users_registados.size());
    }

    @Test
    void PopularResources() throws  EmailException, CampoNullException, JSONException, pantoneException, AvatarException, RecursoException, yearException, colorException, IOException, UtilizadorException, API_Expetion {

        Aplicacao AP = new Aplicacao();
        Aplicacao.prePopular(Aplicacao.users, AP.users_registados, AP.resources);

        assertEquals(12, AP.resources.size());

    }


    private static class End {
    }
}
