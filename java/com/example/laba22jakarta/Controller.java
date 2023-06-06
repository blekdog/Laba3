package com.example.laba22jakarta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Controller {
    private static String pathStr = "C:\\Tomcat\\webapps\\examples\\Laba2.2\\Laba22Jakarta\\src\\main\\webapp\\newData.dat";
    private static Path path = Paths.get(pathStr);

    public static void writeFoodToFile(Food food) throws IOException {
        String seriesString = "";
        seriesString += food.getFirstMeal() + ";";
        seriesString += food.getSecondMeal() + ";";
        seriesString += food.getThirdMeal() + ";";
        seriesString += food.getFourthMeal() + ";";
        seriesString += food.getWeight() + "\n";
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, seriesString.getBytes(), StandardOpenOption.APPEND);
    }

    public static ArrayList<Food> readFoodFromFile() throws IOException {
        if (Files.exists(path)) {
            BufferedReader reader = new BufferedReader(new FileReader(pathStr));
            String data = reader.readLine();
            ArrayList<Food> food = new ArrayList<>();
            while (data != null) {
                String[] parameters = data.split(";");
                Food tempSeries = new Food(parameters[0], parameters[1], parameters[2], parameters[3], Integer.parseInt(parameters[4]));
                food.add(tempSeries);
                data = reader.readLine();
            }
            reader.close();
            return food;
        }
        return null;
    }
}