<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    Member member = (Member)session.getAttribute("member");
    // Member member = MemberDao.getInstance().select(member3.getId()); 
%>

<form action="login-Cmember_update.jsp" method="post">
    <table>
        <tr>
            <td>아이디</td>
<%
    if(member != null) {
%>
            <td><input type="text" name="id" readonly value="<%=member.getId()%>"></td>
<%
    }
%>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="text" name="email" value="<%= member != null ? member.getEmail() : "" %>"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="<%= member != null ? member.getName() : "" %>"></td>
        </tr>
    </table>
    <input type="submit" value="저장"> 
</form>

</body>
</html>