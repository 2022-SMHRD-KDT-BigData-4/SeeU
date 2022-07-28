<%@page import="java.util.List"%>
<%@page import="com.board.test.domain.Board"%>
<%@page import="com.board.test.domain.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	<%
		List<Comment> list = (List<Comment>) request.getAttribute("list");
	%>
</script>
</head>
<body>
 <h2>댓글작성</h2>
  <table width="500" cellpadding="0" cellspacing="0" border="1">
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