package com.es2.Projeto_FInal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class API implements Interface_API {

    public API() {}

    public int listUsers() throws IOException, JSONException, API_Expetion {


        try {


        String url1= "https://reqres.in/api/users?page=1";
        String url2= "https://reqres.in/api/users?page=2";
        URL obj1 = new URL(url1);
        URL obj2 = new URL(url2);
        HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
        HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();

        //default is get
        con1.setRequestMethod("GET");
        con2.setRequestMethod("GET");

        //add request header
        con1.setRequestProperty("User-Agent", "");
        con2.setRequestProperty("User-Agent", "");
        int responseCode1 = con1.getResponseCode();
        int responseCode2 = con2.getResponseCode();
     //   System.out.println("\nSending 'GET' request to URL : "+url1 + " and "+ url2  );
     //   System.out.println("Response Code of url1: "+responseCode1);
            //    System.out.println("Response Code of url2: "+responseCode2);

        BufferedReader in1 =new BufferedReader(
                new InputStreamReader(con1.getInputStream()));

        BufferedReader in2 =new BufferedReader(
                new InputStreamReader(con2.getInputStream()));

        String inputLine1;
        String inputLine2;
        StringBuffer response1 = new StringBuffer();
        StringBuffer response2 = new StringBuffer();

        while ((inputLine1 =in1.readLine()) !=null){
            response1.append(inputLine1);
        }
        in1.close();

        while ((inputLine2 =in2.readLine()) !=null){
            response2.append(inputLine2);
        }

        in2.close();



       // System.out.println(response.toString());

            //      System.out.println("results after reading JSON Response\n");


        JSONObject jsonObject1 = new JSONObject(response1.toString());
        JSONArray jsonArray1 = jsonObject1.getJSONArray("data");

        JSONObject jsonObject2 = new JSONObject(response2.toString());
        JSONArray jsonArray2 = jsonObject2.getJSONArray("data");


        for(int i=0;i<jsonArray1.length();i++){
            JSONObject final_object =jsonArray1.getJSONObject(i);
            //         System.out.println("id: "+final_object.getInt("id"));
            //       System.out.println("email: "+final_object.getString("email"));
            //       System.out.println("nome: "+final_object.getString("first_name")+ " "+final_object.getString("last_name")+"\n");


        }

        for(int i=0;i<jsonArray2.length();i++){
            JSONObject final_object =jsonArray2.getJSONObject(i);
            //     System.out.println("id: "+final_object.getInt("id"));
            //      System.out.println("email: "+final_object.getString("email"));
            //      System.out.println("nome: "+final_object.getString("first_name")+ " "+final_object.getString("last_name")+"\n");

        }

        return responseCode1;


    }catch (Exception e){

        throw  new API_Expetion();
    }

}

    public int singleUser(Integer id) throws JSONException, UserNotFoundException, CampoNullException {

        if (id == null) {
            throw new CampoNullException();
        }
        if (id <= 0) {
            throw new UserNotFoundException();
        }


        int responseCode;
        try {

            String url = "https://reqres.in/api/users/" + id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //default is get
            con.setRequestMethod("GET");


            //add request header
            con.setRequestProperty("User-Agent", "");
            responseCode = con.getResponseCode();

        //    System.out.println("\nSending 'GET' request to URL : " + url);
          //  System.out.println("Response Code of url: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            // System.out.println(response.toString());


          //  System.out.println("results after reading JSON Response\n");

            JSONObject object = new JSONObject(response.toString());
            JSONObject final_object = object.getJSONObject("data");

            //     System.out.println("id: " + final_object.getInt("id"));
            //   System.out.println("email: " + final_object.getString("email"));
            //  System.out.println("nome: " + final_object.getString("first_name") + " " + final_object.getString("last_name") + "\n");


        } catch (Exception e) {

            throw new UserNotFoundException();
        }

        return responseCode;
    }

    public int listResources() throws IOException, JSONException, API_Expetion {

        int responseCode1;
        try {


            String url1 = "https://reqres.in/api/unknown?page=1";
            String url2 = "https://reqres.in/api/unknown?page=2";
            URL obj1 = new URL(url1);
            URL obj2 = new URL(url2);
            HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
            HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();

            //default is get
            con1.setRequestMethod("GET");
            con2.setRequestMethod("GET");

            //add request header
            con1.setRequestProperty("User-Agent", "");
            con2.setRequestProperty("User-Agent", "");
            responseCode1 = con1.getResponseCode();
            int responseCode2 = con2.getResponseCode();

          //  System.out.println("\nSending 'GET' request to URL : " + url1 + " and " + url2);
            //   System.out.println("Response Code of url1: " + responseCode1);
            //  System.out.println("Response Code of url2: " + responseCode2);

            BufferedReader in1 = new BufferedReader(
                    new InputStreamReader(con1.getInputStream()));

            BufferedReader in2 = new BufferedReader(
                    new InputStreamReader(con2.getInputStream()));

            String inputLine1;
            String inputLine2;
            StringBuffer response1 = new StringBuffer();
            StringBuffer response2 = new StringBuffer();

            while ((inputLine1 = in1.readLine()) != null) {
                response1.append(inputLine1);
            }
            in1.close();

            while ((inputLine2 = in2.readLine()) != null) {
                response2.append(inputLine2);
            }

            in2.close();


            // System.out.println(response.toString());

            //     System.out.println("results after reading JSON Response\n");


            JSONObject jsonObject1 = new JSONObject(response1.toString());
            JSONArray jsonArray1 = jsonObject1.getJSONArray("data");

            JSONObject jsonObject2 = new JSONObject(response2.toString());
            JSONArray jsonArray2 = jsonObject2.getJSONArray("data");


            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject final_object = jsonArray1.getJSONObject(i);
                //      System.out.println("id: " + final_object.getInt("id"));
                //     System.out.println("nome: " + final_object.getString("name"));
                //     System.out.println("ano: " + final_object.getInt("year"));
                //   System.out.println("cor: " + final_object.getString("color"));
                //   System.out.println("pantone_value: " + final_object.getString("pantone_value") + "\n");

            }

            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject final_object = jsonArray2.getJSONObject(i);
                //     System.out.println("id: " + final_object.getInt("id"));
                //     System.out.println("nome: " + final_object.getString("name"));
                //     System.out.println("ano: " + final_object.getInt("year"));
                //      System.out.println("cor: " + final_object.getString("color"));
                //     System.out.println("pantone_value: " + final_object.getString("pantone_value") + "\n");

            }
        } catch (Exception e) {

            throw new API_Expetion();
        }


        return responseCode1;

    }

    public int singleResource(Integer id) throws ResourceNotFound, CampoNullException {

        if (id == null) {
            throw new CampoNullException();
        }

        if (id <= 0) {
            throw new ResourceNotFound();
        }

        int responseCode;

        try {

            String url = "https://reqres.in/api/unknown/" + id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //default is get
            con.setRequestMethod("GET");


            //add request header
            con.setRequestProperty("User-Agent", "");
            responseCode = con.getResponseCode();

        /*    System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code of url: " + responseCode);*/

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            // System.out.println(response.toString());
           // System.out.println("results after reading JSON Response\n");


            JSONObject object = new JSONObject(response.toString());
            JSONObject final_object = object.getJSONObject("data");

          /*  System.out.println("id: " + final_object.getInt("id"));
            System.out.println("nome: " + final_object.getString("name"));
            System.out.println("ano: " + final_object.getInt("year"));
            System.out.println("cor: " + final_object.getString("color"));
            System.out.println("pantone_value: " + final_object.getString("pantone_value") + "\n");*/


        } catch (Exception e) {

            throw new ResourceNotFound();
        }

        return responseCode;
    }

    public int Create(String name, String job, String email) throws IOException, JSONException, API_Expetion, EmailException, UtilizadorException, CampoNullException {

        int returned;
        if(email==null){throw  new  CampoNullException();}

        if(!email.contains("@")){throw  new  EmailException();}

        if(job==null){throw new CampoNullException();}

        if(name==null){throw new CampoNullException();}

        if(name.length()<3|| name.length()>100) {
            throw new UtilizadorException();
        }

        if(job.length()<3 || job.length()>110){
            throw  new  UtilizadorException();
        }

        try {

            URL url = new URL("https://reqres.in/api/users");
            Map<String, String> params = new LinkedHashMap<>();
            params.put("name", name);
            params.put("job", job);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : params.entrySet()) {

                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Lenght", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder builder = new StringBuilder();

            for (int i; (i = in.read()) >= 0; )
                builder.append((char) i);
            String response = builder.toString();

            //  System.out.println(response);

            JSONObject myResponse = new JSONObject(response.toString());

            // System.out.println("results after reading JSON Response\n");
         /*   System.out.println("\nSending 'POST' request to URL : " + url);

            System.out.println("Response Code: " + conn.getResponseCode() + "\n");
            System.out.println("id: " + myResponse.getString("id"));
            System.out.println("nome: " + myResponse.getString("name"));
            System.out.println("profissao: " + myResponse.getString("job"));
            System.out.println("data de cricacao: " + myResponse.getString("createdAt") + "\n");

            System.out.println("Utilizador criado\n");*/
           returned= Integer.parseInt(myResponse.getString("id"));

        }catch (Exception e){

            throw  new API_Expetion();
        }

        return returned;
    }

    public int updateUserPut(Integer id, String name, String job) throws IOException, JSONException, UserNotFoundException, UtilizadorException, CampoNullException {

        if (id == null) {
            throw new CampoNullException();
        }

        if(id<=0){
            throw new UserNotFoundException();
        }

        if(job==null){throw  new CampoNullException();}

        if(name==null){ throw new CampoNullException();}

        if(singleUser(id)!=200){ throw new UserNotFoundException();}

        if(name.length()<3|| name.length()>100) {
            throw new UtilizadorException();
        }

        if(job.length()<3 || job.length()>110){
            throw  new  UtilizadorException();
        }

        try{

            URL url = new URL("https://reqres.in/api/users/"+id);
            Map<String, String> params = new LinkedHashMap<>();
            params.put("name", name);
            params.put("job", job);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : params.entrySet()) {

                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Lenght", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder builder = new StringBuilder();

            for (int i; (i = in.read()) >= 0; )
                builder.append((char) i);
            String response = builder.toString();

            //  System.out.println(response);

            JSONObject myResponse = new JSONObject(response.toString());

            // System.out.println("results after reading JSON Response\n");
       // System.out.println(myResponse.toString());

    /*System.out.println("\nSending 'PUT' request to URL : " + url);
            System.out.println("Response Code: " + conn.getResponseCode() + "\n");
            System.out.println("id: " + id);
            System.out.println("nome: " + myResponse.getString("name"));
            System.out.println("profissao: " + myResponse.getString("job"));
            System.out.println("data de edicao: " + myResponse.getString("updatedAt") + "\n");


            System.out.println("Utilizador editado\n");*/

    }catch (Exception e){

        throw  new UserNotFoundException();
    }

return 1;


    }

    public int deleteUser(Integer id) throws IOException, JSONException, UserNotFoundException, CampoNullException {

        if (id == null) {
            throw new CampoNullException();
        }
        if (id <= 0 || id>12) {
            throw new UserNotFoundException();
        }

        int responseCode;

        try {
            String url = "https://reqres.in/api/users/" + id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //default is get
            con.setRequestMethod("DELETE");


            //add request header
            con.setRequestProperty("User-Agent", "");
            responseCode = con.getResponseCode();

            //System.out.println("\nSending 'DELETE' request to URL : " + url);
            //System.out.println("Response Code of url: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            //System.out.println(response.toString());

            //System.out.println("Utilizador apagado\n");


        } catch (Exception e) {

            throw new UserNotFoundException();
        }

        return responseCode;


    }

    public int Registar(String email, String password) throws IOException, JSONException, RegisterException, EmailException, CampoNullException, UtilizadorException {

        if(email==null){throw  new  CampoNullException();}

        if(!email.contains("@")){throw  new  EmailException();}

        if(password==null){throw  new CampoNullException();}

        if(password.length()<6 || password.length()>30){
            throw  new  UtilizadorException();
        }


        try{
            URL url = new URL("https://reqres.in/api/register");
            Map<String, String> params = new LinkedHashMap<>();
            params.put("email", email);
            params.put("password", password);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : params.entrySet()) {

                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Lenght", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder builder = new StringBuilder();

            for (int i; (i = in.read()) >= 0; )
                builder.append((char) i);
            String response = builder.toString();

              //System.out.println(response);

            JSONObject myResponse = new JSONObject(response.toString());

            /*System.out.println("results after reading JSON Response\n");
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code: " + conn.getResponseCode() + "\n");
            System.out.println("id: " + myResponse.getInt("id"));
            System.out.println("token: " + myResponse.getString("token"));
            System.out.println("\nRegisto feito com sucesso\n");*/


            return conn.getResponseCode();
        }catch (Exception e){

            throw  new RegisterException();
        }



    }

    public int Login(String email, String password) throws LoginException, EmailException, CampoNullException, UtilizadorException {

        if(email==null){throw  new  CampoNullException();}

        if(!email.contains("@")){throw  new  EmailException();}

        if(password==null){throw  new CampoNullException();}

        if(password.length()<6 || password.length()>30){
            throw  new  UtilizadorException();
        }

        try {

            URL url = new URL("https://reqres.in/api/login");
            Map<String, String> params = new LinkedHashMap<>();
            params.put("email", email);
            params.put("password", password);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : params.entrySet()) {

                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Lenght", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder builder = new StringBuilder();

            for (int i; (i = in.read()) >= 0; )
                builder.append((char) i);
            String response = builder.toString();

            //  System.out.println(response);

            JSONObject myResponse = new JSONObject(response.toString());
            // System.out.println("results after reading JSON Response\n");
            //System.out.println("\nSending 'POST' request to URL : " + url);
            //System.out.println("Response Code: " + conn.getResponseCode() + "\n");
            //System.out.println("token: " + myResponse.getString("token"));

            //System.out.println("\nLogin feito com sucesso\n");

            return conn.getResponseCode();

        }catch (Exception e){

            throw  new LoginException();
        }
    }


}
