package user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.crimesDao;
import user.dao.criminalDao;
import user.dao.policeRegisterDao;
import user.domain.crimes;
import user.domain.criminal;
import user.domain.policeRegister;


/**
 * Servlet implementation class crimeServlet
 */
@WebServlet("/")
public class crimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private crimesDao crimeDAO;
	private criminalDao criminalDAO;
	private policeRegisterDao registerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crimeServlet() {
       this.crimeDAO = new crimesDao();
       this.criminalDAO = new criminalDao();
       this.registerDAO = new policeRegisterDao();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		
			switch (action) {
			case "/new":
				newForm(request, response);
				break;
			case "/newcriminal":
				newFormCriminal(request, response);
				break;
			case "/newpolice":
				newFormPolice(request, response);
				break;
			case "/insert":
				try {
					insertCrime(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/insertcriminal":
				try {
					insertCriminal(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/insertpolice":
				try {
					insertPoliceRegister(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/delete":
				try {
					deleteCrime(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/deletecriminal":
				try {
					deleteCriminal(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/deletepolice":
				try {
					deletePoliceRegister(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/edit":
				try {
					showEditForm(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/editcriminal":
				try {
					showEditFormCriminal(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/editpolice":
				try {
					showEditFormPolice(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/update":
				try {
					updateCrime(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/updatecriminal":
				try {
					updateCriminal(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/updatepolice":
				try {
					updatePoliceRegister(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/listcrime":
				try {
					listCrime(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/listcriminal":
				try {
					listCriminal(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/listpolice":
				try {
					listPoliceRegister(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
			
		
	}
	
	private void listCriminal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<criminal> listCriminal = criminalDAO.selectAllCriminal();
		request.setAttribute("listCriminal", listCriminal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/criminal-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listCrime(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<crimes> listCrime = crimeDAO.selectAllCrimes();
		request.setAttribute("listCrime", listCrime);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/crime-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listPoliceRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<policeRegister> listRegister = registerDAO.selectAllPoliceRegister();
		request.setAttribute("listRegister", listRegister);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/police-list.jsp");
		dispatcher.forward(request, response);
	}
////////////////////
	private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/crime-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void newFormCriminal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/criminal-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void newFormPolice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/police-form.jsp");
		dispatcher.forward(request, response);
	}
////////////////////
	private void insertCrime(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int crimeID = Integer.parseInt(request.getParameter("crimeID"));
		String crimeType = request.getParameter("crimeType");
		String crimeLocation = request.getParameter("crimeLocation");
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));
		crimes newcrime = new crimes(crimeID,crimeType,crimeLocation,policeID,criminalID);
		crimeDAO.insertCrime(newcrime);
		response.sendRedirect("listcrime");
	}
	
	private void insertCriminal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));
		String criminalName = request.getParameter("criminalName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String arrested = request.getParameter("arrested");
		criminal newcriminal = new criminal(criminalID,criminalName,age,gender,arrested);
		criminalDAO.insertCriminal(newcriminal);
		response.sendRedirect("listcriminal");
	}
	
	private void insertPoliceRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String policeRank = request.getParameter("policeRank");
		policeRegister newRegister = new policeRegister(policeID,age, gender, policeRank);
		registerDAO.insertPoliceRegister(newRegister);
		response.sendRedirect("listpolice");
	}
////////////////////	
	private void deleteCrime(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int crimeID = Integer.parseInt(request.getParameter("crimeID"));
		crimeDAO.deleteCrime(crimeID);
		response.sendRedirect("listcrime");

	}
	
	private void deleteCriminal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));
		criminalDAO.deleteCriminal(criminalID);
		response.sendRedirect("listcriminal");

	}
	
	private void deletePoliceRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		registerDAO.deletePoliceRegister(policeID);
		response.sendRedirect("listpolice");

	}
////////////////////	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		int crimeID = Integer.parseInt(request.getParameter("crimeID"));
		crimes existingCrime = crimeDAO.selectCrime(crimeID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/crime-form.jsp");
		request.setAttribute("crimeID", existingCrime);
		dispatcher.forward(request, response);

	}
	private void showEditFormCriminal(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));
		criminal existingCriminal = criminalDAO.selectCriminal(criminalID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/criminal-form.jsp");
		request.setAttribute("criminalID", existingCriminal);
		dispatcher.forward(request, response);

	}
	
	private void showEditFormPolice(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		policeRegister existingRegister = registerDAO.selectpoliceRegister(policeID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/police-form.jsp");
		request.setAttribute("policeID", existingRegister);
		dispatcher.forward(request, response);

	}
////////////////////	
	private void updateCrime(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int crimeID = Integer.parseInt(request.getParameter("crimeID"));
		String crimeType = request.getParameter("crimeType");
		String criminalLocation = request.getParameter("crimeLocation");
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));

		crimes crime = new crimes(crimeID,crimeType, criminalLocation, policeID, criminalID);
		crimeDAO.updateCrime(crime);
		response.sendRedirect("listcrime");
	}
	
	private void updateCriminal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int criminalID = Integer.parseInt(request.getParameter("criminalID"));
		String criminalName = request.getParameter("criminalName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String arrested = request.getParameter("arrested");

		criminal criminals = new criminal(criminalID,criminalName, age, gender,arrested );
		criminalDAO.updateCriminal(criminals);
		response.sendRedirect("listcriminal");
	}
	
	private void updatePoliceRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int policeID = Integer.parseInt(request.getParameter("policeID"));
		String gender = request.getParameter("gender");
		String policeRank = request.getParameter("policeRank");
		int age = Integer.parseInt(request.getParameter("age"));

		policeRegister register = new policeRegister(policeID, age, gender, policeRank);
		registerDAO.updatePoliceRegister(register);
		response.sendRedirect("listpolice");
	}

	

}
