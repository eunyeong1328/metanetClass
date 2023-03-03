<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

		<h3>글번호</h3>
		<p>${board.title }</p>
		<h3>제목</h3>
		<p>${board.writer }</p>
		<h3>작성자</h3>
		<p>${board.contents }</p>
		<h3>등록일</h3>
		<p>${board.regdate }</p>
		<h3>조회수</h3>
		<p>${board.hitcount }</p>
		
		<button onclick= "doAction()">삭제하기</button>
		<script type="text/javascript">
			function doAction(){
				location.href = "hello.do";
			}
		</script>
</body>
</html>