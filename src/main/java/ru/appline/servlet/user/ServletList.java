package ru.appline.servlet.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.appline.logic.user.Model;
import ru.appline.logic.user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = response.getWriter();
//        int id = Integer.parseInt(request.getParameter("id"));
//        if (id == 0) {
//            writer.print("<html>" +
//                    "<h3>Доступные пользователи:</h3></br>"
//                    + "Id пользвоателя:" +
//                    "<ul>");
//
//            for (Map.Entry<Integer, User> userEntry : model.getFromList().entrySet()) {
//                writer.print("<li>" + userEntry.getKey() + "</li>"
//                        + "<ul>" +
//                        "<li>Имя:" + userEntry.getValue().getName() + "</li>" +
//                        "<li>Фамилия:" + userEntry.getValue().getSurName() + "</li>"
//                        + "</ul>");
//            }
//            writer.print("</ul>" +
//                    "<a href=\"index.jsp\">Домой</a>" +
//                    "</html>");
//        } else if (id > 0) {
//            if (id > model.getFromList().size()) {
//                writer.print("<html>" +
//                        "<h3>Такого пользователя не существует:(</h3>" +
//                        "<a href=\"index.jsp\">Домой</a>" +
//                        "</html>");
//            } else {
//                writer.print("<html>" +
//                        "<h3>Найден пользователь:</h3></br>" +
//                        "Имя:" + model.getFromList().get(id).getName() + "</br>" +
//                        "Фамилия:" + model.getFromList().get(id).getSurName() + "</br>" +
//                        "Зарплата:" + model.getFromList().get(id).getSalary() + "</br>" +
//                        "<a href=\"index.jsp\">Домой</a>" +
//                        "</html>");
//            }
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json:charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(model.getFromList()));
    }
}
