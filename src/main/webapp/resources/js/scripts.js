$(document).ready(function () {

    //получени id категории из параметров URL строки

    var urlParams;
    (window.onpopstate = function () {
        var match,
            pl     = /\+/g,
            search = /([^&=]+)=?([^&]*)/g,
            decode = function (s) { return decodeURIComponent(s.replace(pl, " ")); },
            query  = window.location.search.substring(1);

        urlParams = {};
        while (match = search.exec(query))
            urlParams[decode(match[1])] = decode(match[2]);
    })();

    var catId = urlParams["id"];
    var limit = 10;
    var shift = 10;

    //загрузка дополнительного списка

    $(".btn-more").click(function(e) {
        e.preventDefault();
        $.ajax({
            type:"POST",
            data:{catId: catId, shift: shift},
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

                    $(".products").append(toAppend);
                    shift += limit;
                }
            }
        });
    })
});
