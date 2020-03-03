package com.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapmle.LiquorService;
import com.sapmle.model1.LiquorType;

/**
 * Servlet implementation class SelectLiquorServlet
 */
@WebServlet(
		name = "selectliquorservlet",
        urlPatterns = "/SelectLiquor"
        )
public class SelectLiquorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String liquorType = req.getParameter("Type");

	        LiquorService liquorService = new LiquorService();
	        LiquorType l = LiquorType.valueOf(liquorType);

	        List liquorBrands = liquorService.getAvailableBrands(l);

	        req.setAttribute("brands", liquorBrands);
	        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
	        view.forward(req, resp);

	    }
	}


