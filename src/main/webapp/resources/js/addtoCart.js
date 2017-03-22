
$(document).ready(function () {
    $(".p_item").on("click",".to-cart",function(event) {
        event.preventDefault();
        var id = $(this).attr("id").slice(5);
        var i = 0;
        var item = {};

        item.id = id;
        item.quantity = 1;

        $.ajax({
            url:"/cart/add",
            type:"POST",
            data:{item: JSON.stringify(item)},
            success:function (){
                console.log(id);
            }   
        });
    })
 });


//     var cat_id = $(".products").data("category");
//     var limit, offset;
//
//     getBrands(cat_id);
//
//     $(".brands").on("click",".brand",function(e){
//         e.preventDefault();
//         limit = 10;
//         offset = 0;
//         var brand_id = $(this).data("brand");
//
//         $(".products ul").text("");
//         getProducts(brand_id);
//         console.log(offset);
//     });
//
//
//     // var brandId = 0; var limit = 10, offset = 0;
//     // getProducts();
//     // $(".btn-more").click(function(e) {
//     //     e.preventDefault();
//     //     getProducts();
//     // });
//
//
//
//     function getProducts (brand_id) {
//         $.ajax({
//             type:"GET",
//             url:"/get/products",
//             data:{catId: cat_id, brandId: brand_id, offset: offset, limit: limit},
//             success: function (json) {
//                 var list = $.parseJSON(json);
//                 var toAppend='';
//
//                 if(list.length != 0){
//                     for (var i =0; i<list.length;i++) {
//                         toAppend +=
//                             '<li ><a href="/catalog/product?id='
//                             + list[i].id
//                             + '" class="p_item"><h3>'
//                             + list[i].name
//                             + '</h3><img src="/resources/img/pic8.jpg" alt=""> </a></li>';
//                     }
//                     $(".products ul").append(toAppend);
//                     offset += limit;
//                 }
//             }
//         });
//     }
//
// });
//
// function getBrands (c) {
//     $.ajax({
//         type:"GET",
//         url:"/get/brands",
//         data:{catId: c},
//         success: function (json) {
//             var brands = $.parseJSON(json);
//             var toAppend='<a href="/" class="brand" data-brand="0">Все</a>';
//
//             if(brands.length != 0){
//                 for (var i = 0; i < brands.length; i++) {
//                     toAppend += '<a href="/" class="brand" data-brand="'+brands[i].id+'">'+brands[i].Name+'</a>';
//                 }
//                 $(".brands").append(toAppend);
//             }
//         }
//     });
// }
//
//
