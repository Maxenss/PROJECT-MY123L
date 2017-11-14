package com.leonis.leonisandrod.APIPackage;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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

    // Метод для обновления контакта

    // Метод для удаления контакта
}