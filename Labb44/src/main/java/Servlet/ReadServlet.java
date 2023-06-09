package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/read.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto_database", "root",
                    "root");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String query = String.format("select * from autos");
        ArrayList<Auto> autos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Auto tempAuto = new Auto(resultSet.getString("name"), resultSet.getString("body"),
                        resultSet.getString("transmission"), resultSet.getInt("year"), resultSet.getInt("mileage"), resultSet.getInt("auto_index"));
                autos.add(tempAuto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        String jsonArrayString = "";
        if (autos.size() != 0) {
            jsonArrayString = gson.toJson(autos);
        }
        out.print(jsonArrayString);
        out.close();
    }
}