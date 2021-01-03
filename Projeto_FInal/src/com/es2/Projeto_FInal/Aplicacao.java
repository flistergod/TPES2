package com.es2.Projeto_FInal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static ArrayList<Utilizador> users = new ArrayList<Utilizador>();
    public static ArrayList<Utilizador> users_registados = new ArrayList<Utilizador>();
    public static ArrayList<Recurso> resources = new ArrayList<Recurso>();
    Scanner keyboard = new Scanner(System.in);
    private Interface_API interface_api = new API();
    int id=0;
    String name, job;


    public Aplicacao() throws UtilizadorException, RecursoException, API_Expetion, IOException, JSONException, colorException, yearException, pantoneException, AvatarException, EmailException, CampoNullException {

     prePopular(users, users_registados, resources);

    }


    public int Menu(Integer aux, Integer auxSub) throws Exception {
        //aux e subaux para verificar se o menu esta a ser chamado na aplicacao ou num dos testes
        //se for chamado num teste, sao dados valores default
        //para obter resultados para os testes, os break dos switch estão em comentario

        if(aux==null){auxSub=null;}

        int op;

        System.out.println("|        Bem-vindo à nossa aplicação         |");
        do {

            if(aux==null) {

                System.out.println("|            Escolha uma opção               |");
                System.out.println("| 1 - Entrar na app                          |");
                System.out.println("| 2 - Registar na app                        |");
                System.out.println("| 3 - Criar utilizador                       |");
                System.out.println("| 0 - Sair                                   |");


                op = keyboard.nextInt();

            }else op=aux;

            switch (op) {
                case 1:

                    if (aux == null) {
                        System.out.println("email?");

                        //recebe o lixo do buffer
                        String bla = keyboard.nextLine();
                        name = keyboard.nextLine();

                        System.out.println("password?");

                        //reutilizacao da variavel, mesmo o nome não sendo o mais adequado
                        job = keyboard.nextLine();

                    } else {
                        name = "michael.lawson@reqres.in";
                        job = "pistol";
                    }

                    if (interface_api.Login(name, job) >= 1) {

                        subMenu(op, auxSub);


                    } else {
                        System.out.println("dados de login invalidos, tente outra vez");
                    }
                    return op;
                //break;


                case 2:

                    if (aux == null) {

                        System.out.println("email?");
                        name = keyboard.nextLine();
                        name = keyboard.nextLine();

                        System.out.println("password?");

                        job = keyboard.nextLine();

                    } else {


                        name = "michael.lawson@reqres.in";
                        job = "pistol";
                        Utilizador uti = new Utilizador(name, "michael lawson");
                        uti.setPassword(job);
                        users.add(uti);
                    }

                    if (interface_api.Registar(name, job) >= 1) {

                        subMenu(op, auxSub);
                    } else {
                        System.out.println("dados de registo invalidos, tente outra vez");
                    }


                    // else{System.out.println("utilizador nao encontrado");}
                    return op;
                //  break;


                case 3:

                    String fname;
                    String lname;
                    if (aux == null) {

                        System.out.println("Introduza o email do utilizador");

                        String name1 = keyboard.nextLine();
                        name = keyboard.nextLine();

                        System.out.println("Introduza a profissao");
                        job = keyboard.nextLine();
                        System.out.println("Introduza o primeiro nome");
                        fname = keyboard.nextLine();
                        System.out.println("Introduza o ultimo nome");
                        lname = keyboard.nextLine();

                    } else {

                        name = "morpheus.god@reqres.in";
                        job = "leader";
                        fname = "morpheus";
                        lname = "god";
                    }


                    interface_api.Create(fname + " " + lname, job, name);
                    return op;
                // break;


                case 0:
                    System.out.println("adeus");
                    op = 0;
                    return op;


                default:
                    System.out.println("dados invalidos, tente outra vez");
                    break;

            }

        } while (op != 0);

            return op;
    }


    public int subMenu(int op, Integer aux) throws RecursoException, ResourceNotFound, JSONException, API_Expetion, IOException, UserNotFoundException, yearException, pantoneException, colorException, CampoNullException, UtilizadorException {

        //op e  subaux para verificar se o menu esta a ser chamado na aplicacao ou num dos testes
        //se for chamado num teste, sao dados valores default
        //para obter resultados para os testes, os break dos switch estão em comentario

        do {
                if(aux==null) {

                    System.out.println("|                  Entrou na aplicacao              |");


                    System.out.println("|                  Escolha uma opção                |");
                    System.out.println("| 1 - Procurar recurso                              |");
                    System.out.println("| 2 - Listar recursos                               |");
                    System.out.println("| 3 - Procurar um utilizador                        |");
                    System.out.println("| 4 - Listar utilizadores                           |");
                    System.out.println("| 5 - Criar recurso                                 |");
                    System.out.println("| 6 - Atualizar utilizador                          |");
                    System.out.println("| 7 - Eliminar utilizador                           |");
                    System.out.println("| 0 - Sair                                          |");

                    op = keyboard.nextInt();

                }else op=aux;

            switch (op) {

                case 1:

                    if (aux == null) {
                        System.out.println("Introduza o id do recurso");
                        id = keyboard.nextInt();

                    } else {
                        id = 1;
                    }

                    interface_api.singleResource(id);
                    return op;
                //  break;


                case 2:

                    interface_api.listResources();
                    return op;
                // break;


                case 3:
                    if (aux == null) {
                        System.out.println("Introduza o id do user");
                        id = keyboard.nextInt();

                    } else {
                        id = 1;
                    }

                    interface_api.singleUser(id);
                    return op;
                //  break;

                case 4:
                    interface_api.listUsers();

                // break;


                case 5:

                    String cor;
                    int year;
                    String pantone_value;

                    if (aux == null) {
                        System.out.println("Introduza o nome do recurso");

                        name = keyboard.nextLine();
                        name = keyboard.nextLine();

                        System.out.println("Introduza o ano");
                        year = keyboard.nextInt();
                        System.out.println("Introduza a cor em hex code");

                        //recebe o lixo do buffer
                        cor = keyboard.nextLine();

                        cor = keyboard.nextLine();
                        System.out.println("Introduza o valor do pantone");
                        pantone_value = keyboard.nextLine();

                    } else {
                        name = "banana";
                        year = 2001;
                        cor = "#FFFF00";
                        pantone_value = "012-C";
                    }


                    Recurso recurso = new Recurso(name, year, cor, pantone_value);
                    resources.add(recurso);
                    return op;
                //   break;

                case 6:
                    if (aux == null) {


                        System.out.println("Introduza o id do user");
                        id = keyboard.nextInt();
                        System.out.println("Introduza o nome do user");

                        //recebe o lixo do buffer
                        name = keyboard.nextLine();

                        name = keyboard.nextLine();
                        System.out.println("Introduza a profissao do user");
                        job = keyboard.nextLine();

                    }else{
                        id=2;
                        name="morpheus";
                        job="zion resident";
                    }

                    interface_api.updateUserPut(id, name, job);
                    return op;
                //  break;

                case 7:

                    if (aux == null) {
                        System.out.println("Introduza o id do user");
                        id = keyboard.nextInt();

                    }else {id=1;}

                    interface_api.deleteUser(id);
                    return op;
                //  break;

                case 0:
                    System.out.println("saiu da aplicacao");
                    op = 0;
                    break;


                default:
                    System.out.println("dados invalidos, tente outra vez");
                    break;

            }

        } while (op != 0);
        return op;
    }


    public static int prePopular(ArrayList<Utilizador> users, ArrayList<Utilizador> users_registados, ArrayList<Recurso> resources) throws JSONException, API_Expetion, IOException, AvatarException, EmailException, yearException, pantoneException, colorException, UtilizadorException, CampoNullException, RecursoException {
        //iremos preencher os arrays users, users_registados e resources para imitar a informacao que vem da API
        //antes de os preencher, limpamos o seu conteudo só para ter a certeza que estão vazios
        int aux=0;
        Aplicacao.users.clear();
        Aplicacao.users_registados.clear();
        Aplicacao.resources.clear();
        Utilizador.conta_ids=1;
        Recurso.conta_ids=1;

        //as strings response 1 e 2 terão a mesma estrutura que os array json que vêm da API
        //tendo a mesma estrutura, podemos usar o mesmo processo usado na classe API para separar a informacao
        //ao separar a informacao, basta guardar esta nos arrays corretos
        //sao precisos 2 for porque na API sao 2 urls
             String response2="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg\"}],\"ad\":{\"company\":\"StatusCode Weekly\",\"url\":\"http://statuscode.org/\",\"text\":\"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"}}";
            String response1="{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"},{\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\",\"last_name\":\"Wong\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"},{\"id\":4,\"email\":\"eve.holt@reqres.in\",\"first_name\":\"Eve\",\"last_name\":\"Holt\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg\"},{\"id\":5,\"email\":\"charles.morris@reqres.in\",\"first_name\":\"Charles\",\"last_name\":\"Morris\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg\"},{\"id\":6,\"email\":\"tracey.ramos@reqres.in\",\"first_name\":\"Tracey\",\"last_name\":\"Ramos\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg\"}],\"ad\":{\"company\":\"StatusCode Weekly\",\"url\":\"http://statuscode.org/\",\"text\":\"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"}}";

            JSONObject jsonObject1 = new JSONObject(response1.toString());
            JSONArray jsonArray1 = jsonObject1.getJSONArray("data");
            JSONObject jsonObject2 = new JSONObject(response2.toString());
            JSONArray jsonArray2 = jsonObject2.getJSONArray("data");

            for(int i=0;i<jsonArray1.length();i++){
                JSONObject final_object =jsonArray1.getJSONObject(i);

                Utilizador u=new Utilizador(final_object.getString("email"),final_object.getString("first_name")+" "+
                        final_object.getString("last_name"));

                u.setAvatar(final_object.getString("avatar"));
                u.setPassword("pistol");
                users.add(u);
                users_registados.add(u);
            }

            for(int i=0;i<jsonArray2.length();i++){

                JSONObject final_object =jsonArray2.getJSONObject(i);

                Utilizador u=new Utilizador(final_object.getString("email"),final_object.getString("first_name")
                        + final_object.getString("last_name"));

                u.setAvatar(final_object.getString("avatar"));
                u.setPassword("pistol");

                users.add(u);
                users_registados.add(u);
            }


            //fazemos o mesmo para os recursos

          response2="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"name\":\"sand dollar\",\"year\":2006,\"color\":\"#DECDBE\",\"pantone_value\":\"13-1106\"},{\"id\":8,\"name\":\"chili pepper\",\"year\":2007,\"color\":\"#9B1B30\",\"pantone_value\":\"19-1557\"},{\"id\":9,\"name\":\"blue iris\",\"year\":2008,\"color\":\"#5A5B9F\",\"pantone_value\":\"18-3943\"},{\"id\":10,\"name\":\"mimosa\",\"year\":2009,\"color\":\"#F0C05A\",\"pantone_value\":\"14-0848\"},{\"id\":11,\"name\":\"turquoise\",\"year\":2010,\"color\":\"#45B5AA\",\"pantone_value\":\"15-5519\"},{\"id\":12,\"name\":\"honeysuckle\",\"year\":2011,\"color\":\"#D94F70\",\"pantone_value\":\"18-2120\"}],\"ad\":{\"company\":\"StatusCode Weekly\",\"url\":\"http://statuscode.org/\",\"text\":\"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"}}";
             response1="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"name\":\"sand dollar\",\"year\":2006,\"color\":\"#DECDBE\",\"pantone_value\":\"13-1106\"},{\"id\":8,\"name\":\"chili pepper\",\"year\":2007,\"color\":\"#9B1B30\",\"pantone_value\":\"19-1557\"},{\"id\":9,\"name\":\"blue iris\",\"year\":2008,\"color\":\"#5A5B9F\",\"pantone_value\":\"18-3943\"},{\"id\":10,\"name\":\"mimosa\",\"year\":2009,\"color\":\"#F0C05A\",\"pantone_value\":\"14-0848\"},{\"id\":11,\"name\":\"turquoise\",\"year\":2010,\"color\":\"#45B5AA\",\"pantone_value\":\"15-5519\"},{\"id\":12,\"name\":\"honeysuckle\",\"year\":2011,\"color\":\"#D94F70\",\"pantone_value\":\"18-2120\"}],\"ad\":{\"company\":\"StatusCode Weekly\",\"url\":\"http://statuscode.org/\",\"text\":\"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"}}";


             jsonObject1 = new JSONObject(response1.toString());
             jsonArray1 = jsonObject1.getJSONArray("data");

             jsonObject2 = new JSONObject(response2.toString());
             jsonArray2 = jsonObject2.getJSONArray("data");


            for(int i=0;i<jsonArray1.length();i++){
                JSONObject final_object =jsonArray1.getJSONObject(i);

                Recurso r = new Recurso(final_object.getString("name"), final_object.getInt("year"),
                        final_object.getString("color"), final_object.getString("pantone_value"));


              resources.add(r);

            }

            for(int i=0;i<jsonArray2.length();i++){
                JSONObject final_object =jsonArray2.getJSONObject(i);

                Recurso r = new Recurso(final_object.getString("name"), final_object.getInt("year"),
                        final_object.getString("color"), final_object.getString("pantone_value"));


                resources.add(r);
        aux=1;
            }


        return aux;

    }

}




