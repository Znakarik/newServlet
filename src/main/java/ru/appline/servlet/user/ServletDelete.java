package ru.appline.servlet.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.appline.logic.user.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        writer.print("<html>");
        if (model.findById(id) != null) {
            model.deleteById(id);
            writer.print("<h3>Пользователь с id - " + id + " успешно удален</h3></br>");
        } else {
            writer.print("<h3>Пользователь с id - " + id + "не найден</h3>");
        }
        writer.print("<a href=\"index.jsp\">Домой</a>" +
                "</html>");
    }
}
