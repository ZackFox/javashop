
$(document).ready(function () {
    updateMiniCart();

    $(".cart").on("click",function(event) {
        event.preventDefault();
        $(".mini-cart-wrapper").addClass("activated");
    });

    $(".cart-close").on("click",function(event) {
        event.preventDefault();
        $(".mini-cart-wrapper").removeClass("activated");
    });

    $(".p_item").on("click",".to-cart",function(event) {
        event.preventDefault();
        var id = $(this).data("id");

        $.ajax({
            type:"POST",
            data:{id:id},
            url:"/cart",
            success: function () {
                updateMiniCart();
            }
        });
    });

    $(".mini-cart-items").on("click",".btn-quantity",function(event) {
        event.preventDefault();
        var up = $(this).hasClass("increase")?"increase":"decrease";

        $.ajax({
            type:"PUT",
            data:{up:up},
            url:"/cart",
            success: function () {
                // updateMiniCart();
                console.log(up);
            }
        });
    });

    $(".mini-cart-items").on("click",".item-delete",function(event) {
        event.preventDefault();

        $.ajax({
            type:"DELETE",
            // data:{id:id},
            url:"/cart",
            success: function () {
                // updateMiniCart();
                console.log($(this).parentNode);
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
            console.log(json)
            updateCartCounters(json);
        }
    });
}

function updateCartCounters(json) {
    var count=0, total=0; var item = "";
    if(json.length>0){
        $(".mini-cart-items table").html("");
        for(var i = 0; i < json.length;i++){
            count += json[i].quantity;
            total += (json[i].productPrice*json[i].quantity);

            item += '<tr class="mini-cart-item" data-item-id="'+json[i].productId +'"><td>'
                    + '<a href="\" >картинка</a></td><td>'
                    + '<a href="#" >'+ json[i].title +'</a></td><td>'
                    + '<div class="qnty"><a href="/" class="btn-quantity decrease">-</a>'
                    + '<span>'+json[i].quantity+'</span><a href="/" class="btn-quantity increase">+</a>'
                    + '</div></td><td><span>'+json[i].productPrice+'</span></td><td><a href="" class="item-delete">Удалить</a></td> </tr>';
        }
        $(".mini-cart-items table").append(item);
    }
    $(".cart-count").text((json.length>0)?count:"0");
    $(".cart-total").text((json.length>0)?total+" Р.":"Корзина пуста");
}


// var ar = $(".p_item").find(".add");
// for(var i = 0; i < ar.length;i++){
//     if(ar[i].attributes[1].nodeValue === "prod_6"){
//         var parent = "."+ar[i].parentNode.attributes[0].nodeValue;
//
//         break;
//     }else {
//
//     }
// }

// function addItem(cart,id) {
//     if(cart){
//         $.ajax({
//             type:"POST",
//             data:{add:id},
//             url:"/cart",
//             success: function (json) {
//                 var json = $.parseJSON(json);
//                 $(".cart-count").text(json.quantity);
//                 $(".cart-total").text(json.price);
//             }
//         });
//     }
//     else {
//         $.ajax({
//             type:"POST",
//             data:{add:id},
//             url:"/cart",
//             success: function (json) {
//                 var json = $.parseJSON(json);
//                 $(".cart-count").text(json.quantity);
//                 $(".cart-total").text(json.price);
//             }
//         });
//     }
    


