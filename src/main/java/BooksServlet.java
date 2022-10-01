import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class BooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        pw.println("<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <title>Book list</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "</head>");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }

         try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db", "postgres", "4678");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title, author, quantity FROM books");

            pw.println("<nav class=\"navbar navbar-light bg-light\">\n" +
                    "    <form class=\"form-inline\">\n" +
                    "        <button onclick=\"window.location.href = '/insert';\" class=\"btn btn-outline-success\" type=\"button\">Add book</button>\n" +
                    "    </form>\n" +
                    "</nav>");

          pw.println("<div class=\"container\">\n" +
                  "    <div class=\"row\">\n" +
                  "        <div class=\"col-sm\">\n" +
                  "            <div class=\"alert alert-dark\" role=\"alert\">\n" +
                  "                 Title\n" +
                  "            </div>\n" +
                  "        </div>\n" +
                  "        <div class=\"col-sm\">\n" +
                  "            <div class=\"alert alert-dark\" role=\"alert\">\n" +
                  "                   Author\n" +
                  "            </div>\n" +
                  "        </div>\n" +
                  "        <div class=\"col-sm\">\n" +
                  "            <div class=\"alert alert-dark\" role=\"alert\">\n" +
                  "                  Quantity\n" +
                  "            </div>\n" +
                  "        </div>\n" +
                  "    </div>\n" +
                  "</div>");

             while (rs.next()) {
                 pw.println("<div class=\"container\">\n" +
                         "    <div class=\"row\">\n" +
                         "        <div class=\"col-sm\">\n" +
                         "            <div class=\"alert alert-primary\" role=\"alert\">\n" +
                         "              \n" + rs.getString("title") +
                         "            </div>\n" +
                         "        </div>\n" +
                         "        <div class=\"col-sm\">\n" +
                         "            <div class=\"alert alert-primary\" role=\"alert\">\n" +
                         "               \n" + rs.getString("author") +
                         "            </div>\n" +
                         "        </div>\n" +
                         "        <div class=\"col-sm\">\n" +
                         "            <div class=\"alert alert-primary\" role=\"alert\">\n" +
                         "              \n" + rs.getString("quantity") +
                         "            </div>\n" +
                         "        </div>\n" +
                         "    </div>\n" +
                         "</div>");
             }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
