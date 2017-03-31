
$(document).ready(function () {
    // $.cookie("uuid","10645f51-bb68-4ba4-b25c-d76c177db76f",{path:"/"});
    updateMiniCart();

    $(".p_item").on("click",".to-cart",function(event) {
        event.preventDefault();
        var id = $(this).attr("id").slice(5);
        $.ajax({
            type:"POST",
            data:{add:id},
            url:"/cart",
            success: function () {updateMiniCart();}
        });
    });
});

function updateMiniCart(){
    var uuid = $.cookie("uuid");
    if(uuid){
        $.ajax({
            type:"GET",
            data:{uuid: uuid},
            url:"/cart",
            success: function (js) {
                var json = $.parseJSON(js);
                console.log(json);
                var count=0, total=0;
                if(json.length>0){
                    for(var i = 0; i < json.length;i++){
                        console.log(json[i].productId);
                        count+= json[i].quantity;
                        total+= (json[i].productPrice* json[i].quantity);
                    }
                }
                $(".cart-count").text((json.length>0)?count:"0");
                $(".cart-total").text((json.length>0)?total+" Р.":"Корзина пуста");
            }
        });
    }
    else{
        $(".cart-count").text("0");
        $(".cart-total").text("Корзина пуста");
    }
}

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
    


