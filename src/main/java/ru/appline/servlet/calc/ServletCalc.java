package ru.appline.servlet.calc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.calc.Calculator;
import ru.appline.logic.user.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = gson.fromJson(String.valueOf(stringBuffer), JsonObject.class);
        request.setCharacterEncoding("UTF-8");

        double a = jsonObject.get("a").getAsDouble();
        double b = jsonObject.get("b").getAsDouble();
        String operator = jsonObject.get("operator").getAsString();
        Calculator calculator = new Calculator();

        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(calculator.getResult(a, b, operator)));
    }
}
