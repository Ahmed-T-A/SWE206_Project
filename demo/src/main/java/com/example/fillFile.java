package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fillFile {
  public static void main(String[] args) throws Exception {
    List<String[]> rows = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("U:\\Term222\\SWE206\\SWE206_Project\\StudentDetails.csv"))) {
        String line;
        br.readLine(); // skip the header row
        while ((line = br.readLine()) != null) {
            String[] fields = parseCsvLine(line);
            rows.add(fields);
        }
    }
    try{
      FileOutputStream theBinaryFile = new FileOutputStream("U:\\Term222\\SWE206\\SWE206_Project\\" + "students" + ".dat", true);
      ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
  
    for (String[] row : rows) {
        String username = row[0];
        String password = row[1];
        String type = row[2];
        String email = row[3];
        String name = row[4];
        String id = genetateID();
        Student student = new Student(name, id, username, password, email);
        output.writeObject(student);
          System.out.println(username + " " + password + " " + type + " " + email + " " + name);
    }
    output.close();
  }
  catch(IOException e){
    System.out.println(e.getMessage());
  } 
}

private static String[] parseCsvLine(String line) {
    List<String> fields = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean inQuotes = false;
    for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == '"') {
            inQuotes = !inQuotes;
        } else if (c == ',' && !inQuotes) {
            fields.add(sb.toString());
            sb = new StringBuilder();
        } else {
            sb.append(c);
        }
    }
    fields.add(sb.toString());
    return fields.toArray(new String[0]);
}

public static String genetateID(){
  int num = (int)(Math.random()*99999);
  String numb = Integer.toString(num);
  return "2020" + numb;
}
}
