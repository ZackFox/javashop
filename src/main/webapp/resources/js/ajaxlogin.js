$(document).ready(function () {
    var i = 0;

    $(".btn-close").on("click",function(event) {
        $(this).parent().removeClass("activated");
    });
    
    $(".btn-login").on("click",function(event) {
        event.preventDefault();
        var login = $("#login").val();
        var pass = $("#pass").val();

        var array = [
            "Не угадал! Давай еще разок.",
            "Опять мимо. Не сдавайся! я в тебя верю.",
            "Однажды у тебя получится",
            "Посмотри в web-камеру, я проверю тебя по базе Интерпола.Шучу",
            "У тебя поля пустые, как ты входить собрался?"
        ];

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
                        if(i>3)i = 0;
                        $(".message span").text(array[i]);
                        $(".message").addClass("activated");
                        i+=1;
                    }
                }
            });
        }else {
            $(".message").addClass("activated");
            $(".message span").text(array[4]);
        }
    });

    
});
