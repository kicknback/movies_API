import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="TestingServlet", urlPatterns = "/testing")
public class TestingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            out.println("Blah blah testing.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}