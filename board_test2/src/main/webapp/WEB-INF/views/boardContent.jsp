<%@page import="com.board.test.domain.Comment"%>
<%@page import="com.board.test.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
<style>
	*{
		margin : 0 auto;
		padding : 0 auto;
		overflow : hidden;
	}	
	td, h2 {
		text-align : center;
	}
</style>
</head>
<script type="text/javascript">
  	function goList(){
  		location.href='/boardList'
  	}
  	<%
	List<Comment> list = (List<Comment>) request.getAttribute("list");
	%>
  </script>
  
<body>
	
	  <h2>글 내용</h2>
	  
	  
	  	<table width="500" cellpadding="0" cellspacing="0" border="1">
	  		<tr>
	  			<td>번호</td>
	  			<td>${board.b_num }</td>
	  		</tr>
	  		
	  		<tr>
	  			<td>이름</td>
	  			<td>${board.b_writer }</td>
	  		</tr>
	  		<tr>
	  			<td>제목</td>
	  			<td>${board.b_title }</td>
	  		</tr>
	  		<tr>
	  			<td>내용</td>
	  			<% pageContext.setAttribute("newLine","\n"); %>
	  			<td>${ fn:replace(board.b_content, newLine, "<br>") }</td>
	  		</tr>
	  		<tr>
	  			<td>작성일</td>
	  			<td>${fn:split(board.b_date," ")[0] }</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" align="center">
	  				<button onClick="goList();">목록</button>
	  				<button onClick="goDelete(${board.b_num})">삭제</button>
	  				<button onClick="goUpdate(${board.b_num})">수정</button>
	  			</td>
	  		</tr>
	  	</table>
	  	
	  	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<input type="hidden" name="bno" value="${comment.b_num}">
		<tr>
			<th>글번호</th>
			<th>댓글내용</th>
			<th>날짜</th>
			<th>작성자</th>
		
		</tr>
		<%
			for (Comment comment : list) {
		%>
		<tr>
			<td><%=comment.getC_num() %></td>
			<td><%=comment.getC_content() %></td>
			<td><%=comment.getC_date() %></td>
			<td><%=comment.getMem_id() %></td>
			<td><button onClick="goDelete(${comment.c_num})">댓글삭제</button></td>
		</tr>
		<%
			}
		%>
		
	</table>
  <div class="panel panel-default">
    <div class="panel-body">
				<form class="form-horizontal" action='CommentwriteAction.do' method="post">
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="content">댓글:</label>
						<div class="col-sm-10">
							<textarea name="c_content" id="c_content" rows="10" class="form-control"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">댓글입력</button>
						
						</div>
					</div>
				</form>
			</div>
  </div>
</body>
</html>