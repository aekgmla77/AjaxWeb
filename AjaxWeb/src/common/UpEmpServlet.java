package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upEmp")
public class UpEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpEmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		int emId = Integer.parseInt(eid);
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String pNumber = request.getParameter("pNumber");
		String hDate = request.getParameter("hDate");
		String jobId = request.getParameter("jobId");
		String salar = request.getParameter("salary");
		int salary = Integer.parseInt(salar);
		
		EmployeeVO vo = new EmployeeVO();
	
		vo.setEmployeeId(emId);
		vo.setFirstName(fName);
		vo.setLastName(lName);
		vo.setEmail(email);
		vo.setPhoneNumber(pNumber);
		vo.setHireDate(hDate);
		vo.setJobId(jobId);
		vo.setSalary(salary);

		EmpDAO dao = new EmpDAO();
		EmployeeVO v = dao.updateEmp(vo);
		String result = "<result>";
		result += "<emId>" + v.getEmployeeId() + "</emId>";
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
