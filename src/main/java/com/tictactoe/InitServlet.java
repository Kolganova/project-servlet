package com.tictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        Field field = new Field();
        Map<Integer, Sign> fieldData = field.getField();
        List<Sign> data = field.getFieldData();
        currentSession.setAttribute("field", field);
        currentSession.setAttribute("data", data);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
