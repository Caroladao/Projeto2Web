<%-- 
    Document   : home
    Created on : 31/05/2018, 16:27:41
    Author     : carol
--%>

<%@page import="servlet.Publicacao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servlet.ConnectionFactory"%>
<%@page import="com.google.gson.Gson" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%
    if (!session.getAttribute("logado").equals("true")) {
        response.sendRedirect("./index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Projeto Web</title>
        
    <button id ="refreshButton" style ="position: absolute; left: -9999px">
    </button>
        
      <!--
      <script>
        function periodicRefresh(requiredInfo){
            $('#refreshButton').click();
            var myInterval = setInterval( function(){

                $.ajax({
                    url: './home.php',
                    type: 'POST',
                    dataType: 'json',
                    data: {ri: requiredInfo},
                    success: function(response){

                        if(response.success == true){
                            // atualizar contendo novas informações
                            var freshData = response.data;
                            $('#publ').replaceWith(freshData);
                            clearInterval(myInterval);
                        }

                    }
                });
            // REPEATS EVERY 5 SECONDS UNTIL clearInterval IS CALLED
            },5000);
        }
        </script> -->
        
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
            font-size: 18pt;
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
            width: 80%;
            height: auto;
        }
        .publ{
            margin: 2% 0;
            height: 90%;
            padding: 2%;
            border: 2px groove;
            border-radius: 6px;
        }
        .pp{
            margin: 0;
            padding: 3% 0;
            font-size: 24pt;
            color: #565d60;
            text-align: center;
            letter-spacing: -1px;
        }
        .p1{
            margin: 0;
            font-size: 24pt;
            color: #565d60;
            text-align: left;
            font-weight: bold;
        }
        .p2{
            font-size: 16pt;
            color: #565d60;
            text-align: left;
            letter-spacing: -1px;
        }
        .imp{
            height: 250px;
        }

        .container {
            margin: 0 0 0 25%;
            width: 50%;
            position: relative;
        }
        .busca {
            width: 100%;
            padding: 10px;
            height: 40px;
            border-radius: 10px;
            font-style:italic;
            font-size:18px;
        }
        .btnn {
            padding: 5px;
            position: absolute;   
            top: 0; 
            right: 0;
            height: 40px;
            border-radius: 5px;
        }
        .imgbusca{
            height: 70%;
        }
        #carrega{
            height: 200px;
            margin: 0 0 2% 0;
            display: none;
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
            
            <center><div class="id">
                    <b> ${sessionScope.login}</b>
                </div></center>
            <br>
            <h1>Bem vindo:</h1>
            <p>Se você não for administrador, não poderá publicar nada, sinto muito! <br> Mas você pode olhar as publicações, olha que legal!</p>



        </section>
        <section class="section2">
            <p class="pp"><b>Publicações</b></p>
            <hr>
            <form method="get">
                <div class="container">  
                    <input type="search" class="busca" name="q" value="" placeholder="Busca...">
                    <div class="btnn"><img class="imgbusca" src="images/search.png"></div>
                </div>
            </form>
            <hr>
            <center><img id="carrega" src="images/carregando2.gif"></center>
            <div id="publ" class="publ" ></div>
            <script type="text/javascript" charset="utf-8">
                    var container = document.querySelector("#publ");
                    document.querySelector("input")
                            .addEventListener("keyup", function () {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.open("GET", "busca?q=" + this.value, true); //assincrono
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4){
                                $("#carrega").css("display", "block");
                                $("#publ").css("display", "none");
                            }
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                setTimeout(() =>{
                                    $("#carrega").css("display", "none");
                                    $("#publ").css("display", "block");
                                    container.innerHTML = xmlhttp.responseText;
                                }, 2000);
                        };
                        xmlhttp.send();
                    });
            </script>
        </section>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</html>