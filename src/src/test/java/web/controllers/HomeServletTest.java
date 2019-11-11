package web.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.dao.VolDAOLocal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    RequestDispatcher requestDispatcher;

    @Mock
    VolDAOLocal volDAOLocal;

    @Mock
    PrintWriter responseWriter;

    HomeServlet servlet;

    @BeforeEach
    public void setup() throws IOException {
        servlet = new HomeServlet();
        servlet.volDAO = volDAOLocal;
        when(request.getRequestDispatcher("/WEB-INF/pages/restreint/home.jsp")).thenReturn(requestDispatcher);
    }


    @Test
    void doGetShouldForwardRequest() throws ServletException, IOException {
        servlet.doGet(request, response);
        verify(request).getRequestDispatcher("/WEB-INF/pages/restreint/home.jsp");
        verify(requestDispatcher).forward(request, response);
    }
}