

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample_board.Board;
import sample_board.BoardDTO;

/**
 * Servlet implementation class FixServlet
 */
@WebServlet("/FixServlet")
public class FixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		BoardDAO boardDAO = new BoardDAO();
		Board bd = new Board();
		String btn = request.getParameter("btn");
		int index = btn.indexOf("正");
		String s_id = btn.substring(index + 1);
		int id = Integer.parseInt(s_id);
		bd.setId(id);
		BoardDTO boardDTO = boardDAO.oneselect(bd);
		request.setAttribute("boardDTO", boardDTO);
		RequestDispatcher rd = request.getRequestDispatcher("/Fix.jsp");
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
