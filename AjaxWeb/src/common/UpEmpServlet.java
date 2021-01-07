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
		String emId = request.getParameter("emId");
		emId = emId == null ? "0" : emId;
		int emI = Integer.parseInt(emId);
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("pNumber");
		String hDate = request.getParameter("hDate");
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		int salar = Integer.parseInt(salary);
		
		EmployeeVO vo = new EmployeeVO();
	
		vo.setEmployeeId(emI);
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		vo.setPhoneNumber(phoneNumber);
		vo.setHireDate(hDate);
		vo.setJobId(jobId);
		vo.setSalary(salar);

		EmpDAO dao = new EmpDAO();
		if(dao.updateEmp(vo)) {
			response.getWriter().append("<h1>OK</h1>");
		}else {
			response.getWriter().append("<h1>NG</h1>");
		};
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
