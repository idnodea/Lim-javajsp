package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;
import dto.Member;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		if (path.equals("/list.do")) {
			BoardDao boardDao = BoardDao.getInstance();
			ArrayList<Board> bList = boardDao.selectList();
			// 포워딩 작업
			request.setAttribute("bList", bList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
			dispatcher.forward(request, response);

		} else if (path.equals("/view.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			BoardDao boardDao = BoardDao.getInstance();
			Board boardDto = boardDao.selectOne(num, true);
			// 글 제목과 내용이 웹 페이지에 올바르게 출력되도록
			// 공백과 줄 바꿈 처리
			String title = boardDto.getTitle().replace(" ", "&nbsp;");
			boardDto.setTitle(title);

			String content = boardDto.getContent().replace(" ", "&nbsp;").replace("\n", "<br>");
			boardDto.setContent(content);

			// 포워딩 작업
			request.setAttribute("bd", boardDto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
			dispatcher.forward(request, response);
		} else if (path.equals("/login.do")) {
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			Member memberDto 
			     = MemberDao.getInstance().selectForLogin(id, email);
			if (memberDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberDto", memberDto);
				response.sendRedirect("list.do");
			} else {
				response.sendRedirect("loginForm.jsp");
			}
		} else if (path.equals("/logout.do")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("loginForm.do");
		} else if (path.equals("/loginForm.do")) {
			response.sendRedirect("loginForm.jsp");
		}
	}

}