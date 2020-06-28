package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet controller class
 */
@WebServlet(name="search")
public class Search extends HttpServlet {

    DatabaseConnection connection = new DatabaseConnection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("message");
        String filter = request.getParameter("filter");

        // Format results
        List<String> result = connection.select(filter, message);
        String heading = String.format("<b>%-5s%-10s%-12s%-10s%-10s%-12s%-5s</b><br>",
                "ID", "Numbets", "Game", "Stake", "Returns", "Client ID", "Date");
        StringBuilder resultString = new StringBuilder(heading);
        for (String str : result) {
            resultString.append(str).append("<br>");
        }
        request.setAttribute("result", resultString.toString());
        // Load/reload search page
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
