function cadastro(user) {
    $.ajax({
        method: 'POST',
        url: './cadastrei',
        data: user,
        success : function(responseText) {
                if(responseText == "Login/Senha Incorretos."){
                    $('#ajaxServletResponse').text(responseText);
                } else {
                    window.location.href = "./cadastroo.jsp";
                }
            }
    });
}

function saveForm() {
    let user = new Object();
    $('#formcad').submit(e => {
        e.preventDefault();
        user.nome = $('#nome').val();
        user.login = $('#login').val();
        user.senha = $('#senha').val();
        user.email = $('#email').val();
        user.endereco = $('#endereco').val();
        user.adm = $('#adm').val();
        cadastro(user);
    });
}



$(document).ready(function() {
    saveForm();
});