<%-- 
    Document   : publicacao
    Created on : 31/05/2018, 16:27:41
    Author     : carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (!session.getAttribute("logado").equals("true")) {
        response.sendRedirect("./index.jsp");
    }

    if (session.getAttribute("adm").equals("false")) {
        response.sendRedirect("./home.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Projeto Web</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        
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
        .section1 h3{
            color:white;
            text-align: center;
        }
        .section1 h3:hover{
            color:red;
            font-weight: bolder;
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
            width: 60%;
            height: 80%;	
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
        .cmp8{
            width: 5%;
            margin: 0 0 30px 0;
            height: 25px;
            border: 2px solid black;
            float: left;
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
            <center><button class="id">
                    <b> ${sessionScope.login}</b>
                </button></center>
            <br>
            <h1>Cadastro:</h1>
            <p>Se você está nessa pagina você está prestes a fazer um cadastro</p>	
            <h3 id="msgResposta">Cadastrado!!</h3>
        </section>

        <section class="section2">
            <p>Vamos saber um pouco mais sobre o cadastro: </p>
            <form class="form" action="" method="post" id="formcad">
                <label class="lbl">Nome:</label>
                <input class="cmp1" type="text" name="nome" id="nome" required autofocus ><br>
                <label class="lbl">Login:</label>
                <input class="cmp1" type="text" name="login" id="login" required><br>
                <label class="lbl">Senha:</label>
                <input class="cmp2" type="password" name="senha" id="senha" required><br>
                <label class="lbl">Email:</label>
                <input class="cmp3" type="email" name="email" id="email" required><br>
                <label class="lbl">Endereço:</label>
                <input class="cmp4" type="text" name="endereco" id="endereco" required><br>	
                <label class="lbl">Administrador:</label>
                <select class="cmp1" id="adm" name="adm">
                    <option value="false">Não</option>
                    <option value="true">Sim</option>
                </select>
                <input class="cmp5" id="salvar" type="submit" value="Cadastrar">
                </div>
            </form>
           <!-- <script>
                $(document).ready(function() {
                $("#msgResposta").hide(); // esconde a mensagem
                // Quando usuário clicar em salvar será feito todos os passo abaixo
                $('#salvar').click(function() {
                    debugger
                    var dados = $('#formcad').serialize();
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: './cadastrei',
                        async: true,
                        data: dados,
                        success: function (res) {
                            var data = jQuery.parseJSON(res)
                                    
                        },
                        error: "erro"
                    });
                });
            });
            </script> -->
            <script>
                $(document).ready(function () {
                    $('#salvar').click(function() {
                        var json = {
                            "nome": $("#nome").val(),
                            "login": $("#login").val(),
                            "senha": $("#senha").val(),
                            "email": $("#email").val(),
                            "endereco": $("#endereco").val(),
                            "adm": $("#adm").val()
                        };
                        $.ajax({
                            type: "POST",
                            url: "./cadastrei",
                            data: json, //{nome:nome,dia:data, id:idUser},
                            dataType: "json",
                            success: function (msg, status) {
                                alert("Retorno: " + msg);
                            }
                            /*error: function (xhr, msg, e) {
                                alert(msg + " E: " + e + " XHR: " + xhr);
                            }*/
                        });
                    });
                });
            </script>
        </section>        
    </body>
</html>