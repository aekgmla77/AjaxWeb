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
		String phoneNumber = request.getParameter("pNumber");
		String hDate = request.getParameter("hDate");
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		int salar = Integer.parseInt(salary);

		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		vo.setPhoneNumber(phoneNumber);
		vo.setHireDate(hDate);
		vo.setJobId(jobId);
		vo.setSalary(salar);

		EmpDAO dao = new EmpDAO();
		EmployeeVO v = dao.insertEmp(vo);
		String result = "<result>";
		result += "<empId>" + v.getEmployeeId() + "</empId>";
		result += "<fName>" + v.getFirstName() + "</fName>";
		result += "<lName>" + v.getLastName() + "</lName>";
		result += "<email>" + v.getEmail() + "</email>";
		result += "<pNumber>" + v.getPhoneNumber() + "</pNumber>";
		result += "<hireDate>" + v.getHireDate() + "</hireDate>";
		result += "<jobId>" + v.getJobId() + "</jobId>";
		result += "<salary>" + v.getSalary() + "</salary>";
		result += "</result>";

		response.getWriter().append(result);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
