<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

		<h3>�۹�ȣ</h3>
		<p>${board.title }</p>
		<h3>����</h3>
		<p>${board.writer }</p>
		<h3>�ۼ���</h3>
		<p>${board.contents }</p>
		<h3>�����</h3>
		<p>${board.regdate }</p>
		<h3>��ȸ��</h3>
		<p>${board.hitcount }</p>
		
		<button onclick= "doAction()">�����ϱ�</button>
		<script type="text/javascript">
			function doAction(){
				location.href = "hello.do";
			}
		</script>
</body>
</html>