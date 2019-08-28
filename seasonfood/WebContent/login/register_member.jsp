<%@page import="seasonfood.LogonDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="seasonfood.LogonDBBean" %>
    
    <%request.setCharacterEncoding("utf-8"); %>
   
    
    <%
    LogonDataBean member = new LogonDataBean();
    String id = request.getParameter("User_id");
    String passwd = request.getParameter("User_passwd");
    String email = request.getParameter("User_email");
    String gender = request.getParameter("User_gender");
    
    if(!id.equals("")){
    	if(!passwd.equals("")){
    		if(!email.equals("")){
    			if(!gender.equals("")){
    				if(LogonDBBean.check(id)){
    					out.println("<script>alert('중복된 아이디입니다.');history.back();</script>");
    				}else{
    			    System.out.println(id);
    			    member.setUser_id(id);
    			    member.setUser_passwd(passwd);
    			    member.setUser_email(email);
    			    member.setUser_gender(gender);
    			    member.setUser_join_date(new Timestamp(System.currentTimeMillis()));
    			    LogonDBBean logon = LogonDBBean.getInstnce();
    			    logon.insertMember(member);out.println("<script>alert('회원가입이 완료되었습니다.');location.href='login.html';</script>");
    				}
    			}else{out.println("<script>alert('성별을 선택해주세요');history.back();</script>");}
    	}else{out.println("<script>alert('이메일을 입력해주세요');history.back();</script>");}
    }else{out.println("<script>alert('패스워드를 입력해주세요');history.back();</script>");}
    }else{out.println("<script>alert('아이디를 입력해주세요');history.back();</script>");}

    %>
