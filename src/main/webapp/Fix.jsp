<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sample_board.*"%>
<jsp:useBean id="boardDTO" scope="request" class="sample_board.BoardDTO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正画面</title>
</head>
<body>
<h2>修正画面</h2>
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
</tr>
<%} %>
</tbody>
</table>
<br /><br />

<form method="post" action="/Thread/InsertServlet">
<label for="name">名前</label><br />
<input type="text" name="name" />
<br /><br />
<label for="content">メッセージ</label>
<textarea name="content"></textarea>
<br /><br />
<label for="id">ID</label><br />
<input type="text" name="id" />
<br /><br />
<input type="submit" name="btn" value="修正">
</form>
<br />
<button type="button" onclick="history.back()">戻る</button>
</body>
</html>