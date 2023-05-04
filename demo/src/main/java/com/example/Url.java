package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Url {
  private static final String BASE_URL = "https://us-central1-swe206-221.cloudfunctions.net/app";

  public static String makeRequest(String givenUsername, String givenPassword) {
      try {
          // Example usage: call the sign in endpoint with username and password
          String username = givenUsername;
          String password = givenPassword;
          String signInPath = "/UserSignIn";
          URL signInUrl = new URL(BASE_URL + signInPath + "?username=" + URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8"));
          String signInResponse = makeHttpRequest(signInUrl, "GET");

          // Example usage: call the user endpoint with username
          String userPath = "/User";
          URL userUrl = new URL(BASE_URL + userPath + "?username=" + URLEncoder.encode(username, "UTF-8"));
          String userResponse = makeHttpRequest(userUrl, "GET");

          // Print the responses to the console
          return signInResponse;
          // System.out.println("Sign in response: " + signInResponse);
          // System.out.println("User response: " + userResponse);
      } catch (Exception e) {
          return e.getMessage();
      }
  }

  private static String makeHttpRequest(URL url, String method) throws Exception {
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod(method);

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
      }
      in.close();

      return response.toString();
  }

  public static String getName(String username, String password){
    JSONParser parser = new JSONParser();
    try {
        JSONObject jsonObject = (JSONObject) parser.parse(makeRequest(username, password));
        return jsonObject.get("name").toString();
    } catch (ParseException e) {
        return e.getMessage();
    }
  }

  public static String getType(String username, String password){
    JSONParser parser = new JSONParser();
    try {
        JSONObject jsonObject = (JSONObject) parser.parse(makeRequest(username, password));
        return jsonObject.get("type").toString();
    } catch (ParseException e) {
        return e.getMessage();
    }
  }

  public static String getEmail(String username, String password){
    JSONParser parser = new JSONParser();
    try{
        JSONObject jsonObject = (JSONObject) parser.parse(makeRequest(username, password));
        return jsonObject.get("email").toString();
    } catch (ParseException e) {
        return e.getMessage();
    }
  }

  public static void main(String[] args) {
    // System.out.println(getName("iuhsd","8377"));
    System.out.println(getType("Ahmed","8377"));
    // System.out.println(getEmail("Ahmed","8377"));
    
  }
}
