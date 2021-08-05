import com.google.gson.Gson;
import data.Movie;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            Movie movie = new Movie(
                    6,
                    "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
                    "Goodfellas",
                    "5",
                    "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.",
                    "Martin Scorsese",
                    "Robert De Niro, Ray Liotta, Joe Pesci, Lorraine Bracco",
                    "Biography, Crime, Drama",
                    "1990"
            );
            String movieString = new Gson().toJson(movie);
            out.println(movieString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            BufferedReader reader = request.getReader();

            Movie[] movies = new Gson().fromJson(request.getReader(), Movie[].class);
            System.out.println(Arrays.toString(movies));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
