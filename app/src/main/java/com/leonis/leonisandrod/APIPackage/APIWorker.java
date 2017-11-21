package com.leonis.leonisandrod.APIPackage;

import com.leonis.leonisandrod.ContactPackage.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Floglor on 10.11.2017.
 */

// ВСЕ МЕТОДЫ ДЕЛАЕМ СТАТИЧЕСКИМИ!!!!!!
public class APIWorker {
    // Корневой адрес сайта
    static String rootURL;
    // Токен, который мы получаем при авторизации
    static String token;
    // Ключ API
    static String apiKey = "0eea7a9ca75af8e1fe6f59d62d1c7ba1";

    // Описываем методы

    // Метод для авторизации
    public static void authentication(String login, String password) throws Exception {
        URL obj = new URL(rootURL);
        // Открываем соединение
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String responseData = "";
        int responseCode;

        // Setting basic GET request
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", login + " " + password);
        con.setRequestProperty("X-Leonis-Api", apiKey);

        responseCode = con.getResponseCode();
        System.out.println("nSending 'GET' request to URL : " + rootURL);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        // Считываем входящие данные
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        // Преобразовываем StringBuffer в String
        responseData = response.toString();

        // Создаем новый JSONObject из строки с ответом
        JSONObject jsonObject = new JSONObject(responseData);
        // Парсим этот объъект и сохраняем значение токена
        token = jsonObject.get("token").toString();

        System.out.println(responseData);
    }

    // Метод для запроса одного контакта

    // Метод для запроса большого кол-ва контактов

    // Метод для добавления контакта на сервер
    public static FullContact createContact(FullContact contact) throws IOException{
        //Конфигурация gson
        //Для сериализации обьекта сontact в формат JSON при запросе
        GsonBuilder gsonRequestBuilder = new GsonBuilder();
        gsonRequestBuilder.setPrettyPrinting();
        final Gson gsonRequest = gsonRequestBuilder.create();
        //Для десериализации формата JSON при ответе в обьект класса FullContact
        GsonBuilder gsonResponseBuilder = new GsonBuilder();
        Gson gsonResponse = gsonResponseBuilder.create();

        //Java to JSON
        final String jsonContact = gsonRequest.toJson(contact);

        URL obj = new URL(rootURL);
        String responseData = "";
        int responseCode;

        //Открываем соединение
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //POST request
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", token);
        con.setRequestProperty("X-Leonis-Api", apiKey);
        //Отправление POST request
        con.setDoOutput(true);
        try(BufferedWriter out = new BufferedWriter
                (new OutputStreamWriter(con.getOutputStream()))){
            out.write(jsonContact);
            out.flush();
        }
        //Принимаем response
        responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + rootURL);
        System.out.println("Response Code : " + responseCode);

        try(BufferedReader in = new BufferedReader
                (new InputStreamReader(con.getInputStream()))){
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            responseData = response.toString();
        }

        //JSON to Java
        final FullContact createdContact =
                (FullContact) gsonResponse.fromJson(responseData, FullContact.class);

        /**
         * Если есть необходимость проверки созданного контакта
         if(compareContacts(contact, createdContact){
         return createdContact;
         } else {
         return null;
         }
         */

         return createdContact;
    }

    /**
     * Проверка идентичности данных контакта созданных на сервере
     * с данными контакта клиента

    private boolean compareContacts (FullContact cont1, FullContact cont2) {

     boolean identical = true;

     if(cont1.firstname != cont2.firstname){
     identical = false;
     }
     if(cont1.lastname != cont2.lastname){
     identical = false;
     }
     if(cont1.middlename != cont2.middlename){
     identical = false;
     }
     if(cont1.company != cont2.company){
     identical = false;
     }
     if(cont1.company != cont2.company){
     identical = false;
     }
     if(cont1.jobtitle != cont2.jobtitle){
     identical = false;
     }
     if(cont1.about != cont2.about){
     identical = false;
     }
     if(!cont1.emails.equals(cont2.emails){
     identical = false;
     }
     if(!cont1.phones.equals(cont2.phones){
     identical = false;
     }
     if(!cont1.ims.equals(cont2.ims){
     identical = false;
     }
     if(!cont1.urls.equals(cont2.urls){
     identical = false;
     }
     if(!cont1.socialNetworks.equals(cont2.socialNetworks){
     identical = false;
     }
     if(!cont1.addresses.equals(cont2.addresses){
     identical = false;
     }

     return identical;
     }
     */

    // Метод для обновления контакта

    // Метод для удаления контакта

}