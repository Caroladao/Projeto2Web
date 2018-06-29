<%-- 
    Document   : busca
    Created on : 31/05/2018, 16:27:41
    Author     : carol
--%>

<%@page import="servlet.Publicacao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servlet.ConnectionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%
    if (!session.getAttribute("logado").equals("true")) {
        response.sendRedirect("./index.jsp");
    }
    String busca = request.getParameter("q");
    System.out.println("Busca " + busca);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
            height: 100%;
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
            .pp{
                padding: 5% 0;
                font-size: 150%;
                text-align: left;
            }
            .p1{
                padding: 5% 0;
                font-size: 150%;
            }
            .p2{
                margin: 0 auto;
                padding: 3% 0;
                font-size: 130%;
                color: #565d60;
                text-align: left;
                width: 90%;
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
            <form action="./busca.jsp" method="get">
                <div class="container">  
                    <input type="search" class="busca" name="q" placeholder="<%=busca%>">
                    <button class="btnn" type="submit"><img class="imgbusca" src="images/search.png"></button>
                </div>

            </form>
            <hr>
            <%
                Connection con = ConnectionFactory.getConnection();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM publicacao WHERE pub_titulo LIKE ?");
                    ps.setString(1,"%"+ busca + "%");

                    System.out.println("passei aqui");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        %>  <div class="publ">
                                <p class="p1"><%=rs.getString("pub_titulo")%></p>
                                <p class="p2"><%=rs.getString("pub_texto")%></p>
                            <%  String cam, aux = rs.getString("pub_arquivo");
                                int n = aux.lastIndexOf("web");
                                n = n + 3;
                                cam = aux.substring(n);
                            %>
                            <img class="imp" src=".<%=cam%>" >
                            </div>
                            <%
                        }
                        rs.close();
                        ps.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    };%>
        </section>
    </body>
</html>