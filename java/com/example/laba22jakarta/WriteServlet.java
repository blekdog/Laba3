package com.example.laba22jakarta;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/write.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathStr = "C:\\Tomcat\\webapps\\examples\\Laba2.2\\Laba22Jakarta\\src\\main\\webapp\\newData.dat";
        Path path = Paths.get(pathStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Food> FoodList = new ArrayList<>();
        String jsonArrayString = "";
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        jsonArrayString = Files.readString(path);
        if (jsonArrayString != "") {
            Type listOfSeries = new TypeToken<ArrayList<Food>>() {}.getType();
            FoodList = gson.fromJson(jsonArrayString, listOfSeries);
        }
        String data = request.getReader().readLine();
        Food food = gson.fromJson(data, Food.class);
        FoodList.add(food);
        Controller.writeFoodToFile(food);
    }
}