package info.searchman.lesson.jsp_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �ϐ��̏����ݒ�
		String name = "ゲスト"; // ���O�̏����l�ݒ�
		String status = "ログイン失敗"; // ���O�C���X�e�[�^�X

		// �����R�[�h�̏����ݒ�
		request.setCharacterEncoding("Windows-31J");

		// ID�̎擾
		String id = request.getParameter("id");

		// �p�X���[�h�̎擾
		String pass = request.getParameter("pass");

		// ID�ƃp�X���[�h�̃`�F�b�N
		if (id.equals("search") && pass.equals("man")) {
			status = "ログイン成功";
			name = "佐藤";
		}

		// �T�[�u���b�g���g�ŕ\������
		//		response.setContentType("text/html; charset=windows-31J");
		//		PrintWriter out = response.getWriter();
		//		out.println("<html>");
		//		out.println("<head>");
		//		out.println("<title></title>");
		//		out.println("</head>");
		//		out.println("<body><br><br>");
		//		out.println(status + "<br><br>こんにちは " + name + " さん");
		//		out.println("</body>");
		//		out.println("</html>");

		// ���N�G�X�g�Ƀf�[�^��ǉ�����
		request.setAttribute("login", status);
		request.setAttribute("name", name);

		// HttpSession�̍쐬�ƃZ�b�V�����Ƀf�[�^��ǉ�����
		// HttpSession session = request.getSession( true );
		// session.setAttribute( "name", name );

		// result.jsp�֓]��
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}
}
