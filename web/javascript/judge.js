$(function () {
    $("#userId").keyup(function () {
        const name = $(this).val();
        $.post("/ov/AcountAjaxServlet",{name:name},function (data) {
            var span = $("#iii");
            span.html(data);
            if(data.indexOf("验") >= 0){
                span.css("color","green");
            }else{
                span.css("color","red");
            }

        },"json");
    })
})
