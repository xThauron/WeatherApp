package servlets;

import models.weather.Weather;
import services.WeatherService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class WeatherServlet extends HttpServlet {
    @Inject
    private WeatherService weatherService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Weather weather = weatherService.getWeather(request.getParameter("cityId"));
        request.setAttribute("Weather", weather);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
