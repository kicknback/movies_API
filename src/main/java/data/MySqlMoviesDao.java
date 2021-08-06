package data;

import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.List;

public class MySqlMoviesDao implements MoviesDao{

    private Connection connection = null;

    public MySqlMoviesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Movie> all() throws SQLException {
        return null;
    }

    @Override
    public Movie findOne(int id) {
        return null;
    }

    @Override
    public void insert(Movie movie) {

    }

    @Override
    public void insertAll(Movie[] movies) throws SQLException {

        // Build sql template
        StringBuilder sql = new StringBuilder("INSERT INTO movies (" +
                "id, title, rating, actors, director, genre, plot, poster, year) " +
                "VALUES ");


        // Add a interpolation template for each element in movies list
        sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?), ".repeat(movies.length));

        // Create a new String and take off the last comma and whitespace
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));

        // Use the sql string to create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql.toString());

        // Add each movie to the prepared statement using the index of each sql param: '?'
        // This is done by using a counter
        // You could use a for loop to do this as well and use its incrementor
        int counter = 0;
        for (Movie movie : movies) {
            statement.setInt((counter * 9) + 1, movie.getId());
            statement.setString((counter * 9) + 2, movie.getTitle());
            statement.setString((counter * 9) + 3, movie.getRating());
            statement.setString((counter * 9) + 4, movie.getActors());
            statement.setString((counter * 9) + 5, movie.getDirector());
            statement.setString((counter * 9) + 6, movie.getGenre());
            statement.setString((counter * 9) + 7, movie.getPlot());
            statement.setString((counter * 9) + 8, movie.getPoster());
            statement.setString((counter * 9) + 9, movie.getYear());
            counter++;
        }
        statement.executeUpdate();
    }

        //    id       INT AUTO_INCREMENT,
        //    title    VARCHAR(75)  NOT NULL,
        //    rating   CHAR,
        //    actors   TEXT         NOT NULL,
        //    director VARCHAR(50)  NOT NULL,
        //    genre    VARCHAR(255) NOT NULL,
        //    plot     TEXT         NOT NULL,
        //    poster   TEXT,
        //    year     VARCHAR(4)          NOT NULL

    @Override
    public void update(Movie movie) throws SQLException {

    }

    @Override
    public void destroy(int id) throws SQLException {

    }
}
