
var catId = $(".products").data("cat-id");
var brandId = $(".products").data("brand-id");
var limit = 2, offset = 0;

function loadData () {
    $.ajax({
        type:"GET",
        url:"/get/products",
        data:{catId: catId, brandId: brandId, offset: offset, limit: limit},
        success: function (json) {
            var list = $.parseJSON(json);
            var toAppend='';

            if(list.length != 0){
                for (var i =0; i<list.length;i++) {
                    toAppend +=
                        '<li ><a href="/catalog/product?id='
                        + list[i].id
                        + '" class="p_item"><h3>'
                        + list[i].name
                        + '</h3><img src="" alt=""> </a></li>';
                }

                $(".products ul").append(toAppend);
                offset += limit;
            }
        }
    });
}
loadData();

$(document).ready(function () {
    $(".btn-more").click(function(e) {
        e.preventDefault();
        loadData();
    })
});
