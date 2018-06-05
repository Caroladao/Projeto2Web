<%-- 
    Document   : publicacao
    Created on : 31/05/2018, 16:27:41
    Author     : carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
        if(!session.getAttribute("logado").equals("true")){
            response.sendRedirect("./index.jsp");
        }
        
        if(session.getAttribute("adm").equals("false")){
            response.sendRedirect("./home.jsp");
        }
%>
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
		height: 70%;
	}        
	.menu ul{
		margin: 0 auto;
		font-size: 14pt;
		padding: 2% 0;
   		list-style: none;
   		text-align: center;
	}
	.menu ul li {
		margin:1%;
		display: inline; 
	}
	.menu ul li a{
		text-decoration: none;
		color:#b3bfc3;
	}
	.menu ul li a:hover{
		font-weight:bolder;
		color:black;
	}
	.menu2 ul{
		display: none;
	}
	.btn{
		display: none;
	}
	.id{
		text-align: center;
		padding: 1% 0;
		width: 12%;
		height: 10%;
		font-size: 14pt;
		background: #ff664c;
		color: white;
		border:0px;
		margin: 7% 0 2% 0;
	}
	.id a{
            color:white;
    }
    .id:hover{
		font-weight:bolder;
		font-style:italic;
	}

	.section1 h1{
		color: white;
		text-align: center;
		font-size: 20pt;
	}
	.section1 p{
		color:#b3bfc3;
		text-align: center;
	}
	.section2{
		padding: 0;
		margin: 0 auto;
		width: 70%;
		height: 50%;
		
	}
	.section2 p{
		margin: 0;
		padding: 3% 0;
		font-size: 24pt;
		color: #565d60;
		text-align: center;
		letter-spacing: -1px;
	}
	.lbl{
		font-size: 14pt;
		font-weight: bold;
		float: left;
		margin: 0 0 3% 20%;
	}
	.cmp1 , .cmp2 , .cmp3, .cmp4{
		width: 40%;
		height: 21px;
		float: right;
		margin: 0 20% 3% 0;
		border: 2px solid black;
		border-radius: 6px;
	}
	
	.cmp4{
		width: 24%;
		margin: 0 28% 0 0;
		background: white;
		height: 25px;
	}
		
	@media screen and (max-width: 992px) {
		.session1{
			height: auto;
		}
		.menu ul{
			display: none;
		}
		img.btn{
			display: block;
			width: 10%;
		}
		.btn:hover{
			background-color: #868e93;

		}
		.botao{
			padding: 1% 0;
			width: 35%;
			font-size: 170%;
			height: 20%;
		}
		.session1 h1{
			padding: 0 10%;
			font-size:150%;
		}
		.session1 p{
			text-align: center;
			font-size: 130%;
			padding: 0 10% 5% 10%;

		}
		.session2{
			width: 90%;
		}
		.session2 p{
			padding: 5% 0;
			font-size: 150%;
			text-align: left;
		}

	}
</style>
<body>
	<section class="section1">
		<nav class="menu">                    
			<ul>    
				<li><a href="./home.jsp">Home</a></li>
				<li><a href="./cadastroo.jsp">Cadastro</a></li>
                <li><a href="./publicacao.jsp">Publicar</a></li>
                <li><a href="./Logout">Sair</a></li>
			</ul>
		</nav>
		<nav class="menu2">
          <img class="btn" src="images/btn.png">
			<ul>
				<li><a href="./home.jsp">Home</a></li>
				<li><a href="./cadastroo.jsp">Cadastro</a></li>
                <li><a href="./publicacao.jsp">Publicar</a></li>
                <li><a href="./Logout">Sair</a></li>
			</ul>
		</nav>
			<center><button class="id">
                                <b> ${sessionScope.login}</b>
            </button></center>
            <br>
			<h1>Publicação:</h1>
			<p>Se você está nessa pagina você é um administrador e pode postar em seu perfil:</p>
			
		
		
	</section>
	<section class="section2">
		<p>O que você está afim de publicar hoje?</p>
		<form class="form" method="post" action="./UploadServlet" enctype="multipart/form-data">
			<label class="lbl">Titulo:</label>
			<input class="cmp1" type="text" name="titulo" required autofocus ><br>
			<label class="lbl">Descrição:</label>
			<input class="cmp2" type="text-area" name="descricao" required><br>
			<label class="lbl">Foto ou Video</label>
                        <input class="cmp3" type="file" name="file"   accept="imagens/*"> <br>
			<input class="cmp4" type="submit" value="Publicar">
		</form>

	</section>

</body>
</html>