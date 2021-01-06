package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addEmp")
public class PutEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PutEmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		int salar = Integer.parseInt(salary);

		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jobId);
		vo.setSalary(salar);

		EmpDAO dao = new EmpDAO();
		if (dao.insertEmp(vo)) {
			response.getWriter().append("<h1>OK</h1>");
		} else {
			response.getWriter().append("<h1>NG</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
