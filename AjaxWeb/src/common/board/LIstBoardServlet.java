package common.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.EmployeeVO;


@WebServlet("/LIstBoardServlet")
public class LIstBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LIstBoardServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.getBorList();
		String xml = "<dataset>";
		for (BoardVO bro : list) {
			xml += "<record>";
			xml += "<boardNo>" + bro.getBoardNo() + "</boardNo>" 
					+ "<title>" + bro.getTitle() + "</title>"
					+ "<content>" + bro.getContent() + "</content>"
					+ "<writer>" + bro.getWriter() + "</writer>"
					+ "<creationDate>" + bro.getCreationDate() + "</creationDate>";
					
			xml += "</record>";
		}
		xml += "</dataset>";

		response.getWriter().append(xml);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
