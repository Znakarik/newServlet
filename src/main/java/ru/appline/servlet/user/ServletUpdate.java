package ru.appline.servlet.user;

import ru.appline.logic.user.Model;
import ru.appline.logic.user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/update")
public class ServletUpdate extends HttpServlet {

    Model model = Model.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        double salary = Double.parseDouble(request.getParameter("salary"));

        writer.print("<html>");
        User user = model.findById(id);
        if (user != null) {
            user.setName(name);
            user.setSurName(surName);
            user.setSalary(salary);

            model.deleteById(id);
            model.add(user, id);

            writer.print("<h3>Пользователь обновлен</h3>" +
                    "<a href=\"addUser.html\">Создать нового пользователя</a></br>");
        } else {
            writer.print("<h3>Пользователь с id - " + id + " не найден</h3>");
        }
        writer.print("<a href=\"index.jsp\">Домой</a>" +
                "</html>");
    }
}
