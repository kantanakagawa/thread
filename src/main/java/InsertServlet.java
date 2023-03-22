import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample_board.Board;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public InsertServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		if(btn.equals("投稿")) {
			Board bd = new Board();
			bd.setName(request.getParameter("name"));
			bd.setContent(request.getParameter("content"));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insert(bd);
		} else if(btn.startsWith("削除")){
			int index = btn.indexOf("除");
			String s_id = btn.substring(index + 1);
			Board bd = new Board();
			int id = Integer.parseInt(s_id);
			bd.setId(id);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.delete(bd);
		} else if(btn.equals("修正")) {
			Board bd = new Board();
			bd.setName(request.getParameter("name"));
			bd.setContent(request.getParameter("content"));
			int id = Integer.parseInt(request.getParameter("id"));
			bd.setId(id);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.update(bd);
		}
		response.sendRedirect(request.getContextPath() + "/Toppage");
		doGet(request, response);
	}

}