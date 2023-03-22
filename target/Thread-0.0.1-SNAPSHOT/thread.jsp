<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sample_board.*"%>
<jsp:useBean id="boardDTO" scope="request" class="sample_board.BoardDTO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
<h2>掲示板</h2>
<table border="1">
<tbody>
<tr>
<th>id</th>
<th>名前</th>
<th>メッセージ</th>
</tr>
<%
for(int i = 0; i < boardDTO.size(); i++){
	Board bd = boardDTO.get(i);
%>
<tr>
<td align="center"><%=bd.getId() %></td>
<td align="center"><%=bd.getName() %></td>
<td align="center"><%=bd.getContent() %></td>
<td>
<form method="post" action="/Thread/InsertServlet">
<input type="submit" name="btn" value="修正<%=bd.getId() %>" />
<input type="submit" name="btn" value="削除<%=bd.getId() %>"   />
</form>
</td>
</tr>
<%} %>
</tbody>
</table>
<br /><br />

<form method="post" action="/Thread/InsertServlet">
<label for="name">名前</label><br />
<input type="text" name="name" />
<br /><br />
<label for="content">メッセージ</label><br />
<textarea name="content"></textarea>
<br /><br />
<input type="submit" name="btn"  value="投稿" />
</form>
</body>
</html>