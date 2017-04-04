
$(document).ready(function () {
    //подрузить данные корзины
    updateMiniCart();

    //открыть окно корзины
    $(".cart").on("click",function(event) {
        event.preventDefault();
        
        $.ajax({
            type:"GET",
            url:"/cart",
            success: function (resp) {
                var json = $.parseJSON(resp);
                var item = "";
                if(json.length>0){
                    $(".mini-cart-items table").html("");
                    for(var i = 0; i < json.length;i++){
                        item += '<tr class="mini-cart-item" data-item-id="'+json[i].productId +'"><td>'
                            + '<a href="\" >картинка</a></td><td>'
                            + '<a href="#" >'+ json[i].title +'</a></td><td>'
                            + '<div class="qnty"><a href="/" class="btn btn-quantity decrease">-</a>'
                            + '<span>'+json[i].quantity+'</span><a href="/" class="btn btn-quantity increase">+</a>'
                            + '</div></td><td><span>'+json[i].productPrice+'</span></td><td><a href="" class="item-delete">Удалить</a></td> </tr>';
                    }
                    $(".mini-cart-items table").append(item);
                    $(".mini-cart-popup").addClass("activated");
                }
            }
        });
        
    });

    //закрыть окно корзины
    $(".cart-close").on("click",function(event) {
        event.preventDefault();
        $(".mini-cart-popup").removeClass("activated");
    });

    //добавить в корзину
    $(".p_item").on("click",".to-cart",function(event) {
        event.preventDefault();
        var id = $(this).data("id");

        $.ajax({
            type:"POST",
            data:{id:id,method:"add"},
            url:"/cart",
            success: function (resp) {
                var json = $.parseJSON(resp);
                updateCartCounters(json);
            }
        });
    });

    //изменить количество
    $(".mini-cart-items").on("click",".btn-quantity",function(event) {
        event.preventDefault();
        var id = $(this).parents(".mini-cart-item").data("item-id");
        var method = $(this).hasClass("increase") ? "increase" : "decrease";

        var q = parseInt($(this).siblings("span").html());

        if ($(this).hasClass("increase")) {
            q++;
            $(this).siblings("span").text(q);
        }
        else if($(this).hasClass("decrease") && q==1) {
            return false;
        }
        else{
            q--;
            $(this).siblings("span").text(q);
        }

        $.ajax({
            type: "POST",
            data: {id: id, method: method},
            url: "/cart",
            success: function (resp) {
                var json = $.parseJSON(resp);
                updateCartCounters(json);
            }
        });
    });
    
    // удалить элемент
    $(".mini-cart-items").on("click",".item-delete",function(event) {
        event.preventDefault();
        var id = $(this).parents(".mini-cart-item").data("item-id");
        $(this).parents(".mini-cart-item").remove();
        $.ajax({
            type:"POST",
            data:{id:id,method:"delete"},
            url:"/cart",
            success: function (resp){
                var json = $.parseJSON(resp);
                updateCartCounters(json);
            }
        });
    });
});

function updateMiniCart(){
    $.ajax({
        type:"GET",
        url:"/cart",
        success: function (resp) {
            var json = $.parseJSON(resp);
            updateCartCounters(json);
        }
    });
}


function updateCartCounters(json) {
    var count=0, total=0; var item = "";
    if(json.length>0){
        for(var i = 0; i < json.length;i++){
            count += json[i].quantity;
            total += (json[i].productPrice*json[i].quantity);
        }
    }
    $(".cart-count").text((json.length>0)?count:"0");
    $(".cart-total").text((json.length>0)?total+" Р.":"Корзина пуста");
}


    


