import com.google.gson.Gson;
import data.DaoFactory;
import data.Movie;
import data.MoviesDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {

            // Eventually get movies from database
            PrintWriter out = response.getWriter();
//            Movie movie = new Movie(
//                    6,
//                    "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
//                    "Goodfellas",
//                    "5",
//                    "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.",
//                    "Martin Scorsese",
//                    "Robert De Niro, Ray Liotta, Joe Pesci, Lorraine Bracco",
//                    "Biography, Crime, Drama",
//                    "1990"
//            );

            MoviesDao moviesDao = DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL);


            String movieString = new Gson().toJson(moviesDao.all());
            out.println(movieString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;

        try {
            out = response.getWriter();
//            Movie[] movies = new Gson().fromJson(request.getReader(), Movie[].class);
//            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).insertAll(movies);
            // Reformatted to insert one movie at a time
            Movie movie = new Gson().fromJson(request.getReader(), Movie.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).insert(movie);
        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        }
        out.println(new Gson().toJson("{message: \"Movies POST was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;

        try {
            out = response.getWriter();
            Movie movie = new Gson().fromJson(request.getReader(), Movie.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).update(movie);
        } catch (SQLException e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(400);
            e.printStackTrace();
            return;
        }
        out.println(new Gson().toJson("{message: \"Movies PUT was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            BufferedReader reader = request.getReader();
//
//            int id = new Gson().fromJson(reader, int.class);
//            System.out.println("The movie id to delete: " + id);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        try {
            out = response.getWriter();
            var id = new Gson().fromJson(request.getReader(), int.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).destroy(id);
        } catch (SQLException e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(400);
            e.printStackTrace();
            return;
        }
        out.println(new Gson().toJson("{message: \"Movies DELETE was successful\"}"));
        response.setStatus(200);
    }


}














