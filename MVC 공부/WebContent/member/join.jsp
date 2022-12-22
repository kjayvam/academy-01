<!-- jsp에 들어가는 인코딩 문장 language(사용 스타일) 
contentType(클라이언트에 자원을 보낼때 타입을 전송 , char(클라우저가 받을 타입)) 
page(jsp 작성 타입) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트를 사용하며 주소는 "members.js"이다 -->
<script language="JavaScript" src="members.js" ></script>
</head>
<body>
<!-- 폼~/폼 사이에 있는 내용을 action에 적힌 장소로 이동, method로 보내는 타입을 정한다, name으로 자바스크립트에서 사용하기 위한 방법 -->
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" size="20"><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br />
		이름 : <input type="text" name="name" size="20"><br />
		메일 : <input type="text" name="eMail" size="20"><br />
		주소 : <input type="text" name="address" size="50"><br />
		
		<!-- onclick : 자바스크립트 실행 이벤트로  클릭하면 자바스크립트의 메소드 infoConfirm()을 실행 -->
		<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp; 
		
		<!-- onclick : 자바스크립트 실행 이벤트로  클릭하면 이동할 페이지를 loin.jsp로 설정 -->
		<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>