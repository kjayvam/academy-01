package com.javaEdu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaEdu.model.MemberDto;
import com.javaEdu.service.MembersAllService;
import com.javaEdu.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();				// 프로젝트 + 파일 주소 가져온다
		String conPath = request.getContextPath();			// 프로젝트에 주소만 가져온다
		String command = uri.substring(conPath.length());	// uri에서 프로젝트 주소를 자른다 (파일주소만 가져온다)
		
		if(command.equals("/membersAll.do")) {

			response.setContentType("text/html; charset=UTF-8");	// 클라이언트에 보낼때 타입 전송; 클라우저가 받을 타입
			PrintWriter writer = response.getWriter();				// 클라이언트에 HTML로 보낼때 출력스트림
			writer.println("<html><head></head><body>");
			
			Service service = new MembersAllService();
			ArrayList<MemberDto> dtos = service.execute(request, response); // dao에서 회원들의 모든 리스트로 가져온다
			
			for (int i = 0; i < dtos.size(); i++) {		// dtos에 저장된게 떨어질 때 까지 실행
				MemberDto dto = dtos.get(i);			// i번에 있는 리스트를 가져온다
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
				String eMail = dto.geteMail();
				Timestamp rDate = dto.getrDate();
				String address = dto.getAddress();
				
				writer.println(id + ", " + pw + ", " + name + ", " + eMail + ", " + rDate.toLocalDateTime() + ", " + address + "<hr />");
			}
			
			writer.println("</body></html>");
			
			// 해당 JSP 페이지로 forwarding 해야 함  //board controller에서 하는 기법을 설명해줘야 함.
			// String viewPage = null;
			// RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			// dispatcher.forward(request, response);
		}
		else if(command.equals("/insert.do")) {
			//1. DTO를 생성한다.
			//2. request에서 회원의 정보를  얻어서
			//3. DTO에 넎는다.
			//4. dao.insertMemeber(dto)
			//5. return 값이 1이면 DB insert 성공함.
			
		}
		else if(command.equals("/modify.do")) {
		
		}
		else if(command.equals("/logout.do")) {
			
		}
		
		
	}

}
