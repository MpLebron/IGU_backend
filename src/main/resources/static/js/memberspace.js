$(function (){
    $("#btn-renew").click(function (){
        $.post("/mgsc/member/renew",function (result){
            $("#renewinfor").text(result);
        })
    })

    $("#btn-logout").click(function(){
        $.post("/mgsc/logout",function (){
            window.location.href="index";
        })
    })
})