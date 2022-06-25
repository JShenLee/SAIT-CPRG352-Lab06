package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String action = request.getQueryString();
        if (action != null && action.equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        //Redirects to home if user is logged in, but types in /login 
        if (username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            String item = request.getParameter("item");
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.add(item);
            session.setAttribute("items", items);
        } else if (action != null && action.equals("delete")) {
            String item = request.getParameter("item");
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.remove(item);
        } else {
//          Get the name from the input in register.jsp
            String username = request.getParameter("username");

//          When the user registers, create an empty arraylist
            ArrayList<String> items = new ArrayList<>();

//          Send the name into the session
            session.setAttribute("username", username);

            session.setAttribute("items", items);

        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }

}
