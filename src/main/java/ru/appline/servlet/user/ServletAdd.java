package ru.appline.servlet.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.user.Model;
import ru.appline.logic.user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/add")
public class ServletAdd extends HttpServlet {
    private static AtomicInteger counter = new AtomicInteger(4);
    private Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        PrintWriter writer = response.getWriter();
//
//        String name = request.getParameter("name");
//        String surName = request.getParameter("surName");
//        Double salary = Double.parseDouble(request.getParameter("salary"));
//
//        User user = new User(name, surName, salary);
//        model.add(user, counter.getAndIncrement());
//
//        writer.print("" +
//                "<html><h3>Добавлен новый пользователь</h3>" +
//                "<a href=\"addUser.html\">Создать нового пользователя</a></br>" +
//                "<a href=\"index.jsp\">Домой</a>\n\n" +
//                "</html>");
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        JsonObject jsonObject = gson.fromJson(String.valueOf(stringBuffer), JsonObject.class);
        request.setCharacterEncoding("UTF-8");

        String name = jsonObject.get("name").getAsString();
        String surName = jsonObject.get("surName").getAsString();
        Double salary = jsonObject.get("salary").getAsDouble();

        User user = new User(name, surName, salary);
        model.add(user, counter.getAndIncrement());

        response.setContentType("application/json:charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(model.getFromList()));
    }
}
