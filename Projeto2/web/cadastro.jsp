<%-- 
    Document   : cadastro
    Created on : 31/05/2018, 16:27:41
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
        .section1 h3{
                color:white;
                text-align: center;
        }
        .section1 h3:hover{
                color:red;
                font-weight: bolder;
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
		
		margin: 1% 0 2% 30%;
	}
	.cmp1 , .cmp2 , .cmp3, .cmp4,.cmp5{
		width: 40%;
		height: 21px;
		float: right;
		margin: 0 30% 2% 0;
		border: 2px solid black;
		border-radius: 6px;
	}
	
	.cmp5{
		width: 24%;
		margin: 0 38% 5% 0;
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
				<li><a href="./index.jsp">Voltar para o login</a></li>
			</ul>
		</nav>
		<nav class="menu2">
          <img class="btn" src="images/btn.png">
			<ul>
				<li><a href="./index.jsp">Voltar para o login</a></li>
			</ul>
		</nav>
			<center><button class="id">
            <b> Olá</b>
            </button></center>
            <br>
			<h1>Cadastro:</h1>
			<p>Se você está nessa pagina você está prestes a fazer um cadastro</p>
                        <h3>${sessionScope.mensagem}</h3>
			
		
		
	</section>
	<section class="section2">
		<p>Vamos saber um pouco mais sobre você: </p>
		<form class="form" method="post" action="./cadastrar">
			<label class="lbl">Nome:</label>
			<input class="cmp1" type="text" name="nome" required autofocus ><br>
			<label class="lbl">Login:</label>
			<input class="cmp1" type="text" name="login" required><br>
			<label class="lbl">Senha:</label>
			<input class="cmp2" type="password" name="senha" required><br>
			<label class="lbl">Email:</label>
			<input class="cmp3" type="email" name="email" required><br>
			<label class="lbl">Endereço:</label>
			<input class="cmp4" type="text" name="endereco" required><br>
			<input class="cmp5" type="submit" value="Cadastrar">
		</form>

	</section>

</body>
</html>