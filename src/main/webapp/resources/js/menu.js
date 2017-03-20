$(document).ready(function () {
    $(".btn-login").on("click",function(event) {
        event.preventDefault();
        var login = $("#login").val();
        var pass = $("#pass").val();

        if(login != "" && pass!= ""){
            $.ajax({
                url:"/login",
                type:"POST",
                data:{login: login, password: pass},
                success:function (data){
                    if (data != ""){
                        $(".login-form").addClass("deactivated");
                        $(".reg-btn").addClass("deactivated");
                        $(".message").addClass("deactivated");
                        
                        $(".cabinet").addClass("activated");
                        $(".logout").addClass("activated");
                        $(".cart").addClass("activated");
                    }
                    else {
                        $(".message p").text("логин или пароль неверны!");
                    }
                }
            });
        }
    });
});
