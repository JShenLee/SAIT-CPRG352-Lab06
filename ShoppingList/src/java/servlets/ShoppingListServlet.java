package servlets;

import java.io.IOException;
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
               //Redirects to home if user is logged in, but types in /login 
        if (session.getAttribute("username") != null) {
            response.sendRedirect("ShoppingList");
            return;
        }
        
getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
return; //Stops the code call. VERY IMPORTANT.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
    }

}
