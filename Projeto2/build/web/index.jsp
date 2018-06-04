<%-- 
    Document   : index
    Created on : 31/05/2018, 16:12:18
    Author     : carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Projeto Web</title>
</head>
<style type="text/css">
	html,body{
		background:#f7f9f9;
		height: 100%;
		margin: 0 auto;
    	padding: 0;
    	font-family: Calibri;
	}
	.section1{
		background:url('images/montanha.jpg');
		background-size: cover;
		width: 100%;
		height: 100%;
	}
	.fml{
		width: 25%;
		margin: 0 auto;
	}
	.lg{
		padding: 1% 0;
		width: 80%;
		color: white;
		border:0px;
		margin: 5% 10%;
	}
	.section1 h1{
		text-align: center;
		font-size: 20pt;
	}
	.formu{
		text-align: center;
		width: 90%;
		margin: 0 5%;
		height: 10%;
		border-radius: 6px;
	}
	.bot{
		text-align: center;
		width: 50%;
		margin: 3% 25%;
		border-radius: 6px;
		border-color:black;
		color: white;
		background: black;
	}
	h3{
		text-align: center;
	}
	@media screen and (max-width: 992px) {
		.session1{
			height: auto;
		}
		.session1 h1{
			padding: 0 10%;
			font-size:150%;
		}
	}
</style>
<body>
	<section class="section1">
			<form class="fml" method="post" action="./valida">
				<img class="lg" src="images/log.png">
				<h1>Login</h1>
				<input class="formu" type="text" name="login" placeholder="Login">
				<h1>Senha</h1>
				<input class="formu" type="password" name="senha" placeholder="Senha">
				<input class="bot" type="submit" value="Entrar">
				<h3>Novo por aqui? faça seu cadastro já:</h3>
				<a href="./cadastro.jsp"><input class="bot" type="button" value="Cadastro"></a>
			</form>		
		
	</section>
</body>
</html>
