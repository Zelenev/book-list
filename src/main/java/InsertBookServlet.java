import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InsertBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        InsertBook.insertB(title,author,quantity);
        //getServletContext().getRequestDispatcher("/books").forward(request,response);
        response.sendRedirect("/books");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
