$(function(){
      $('.logo').addClass('animated zoomIn').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',function(){
         $(this).removeClass('animated zoomIn');});
   /*  $('.logo.bottom .main-house').addClass('animated zoomIn').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',function(){
        $(this).removeClass('animated zoomIn');}).ready(function(){
    $('.logo.bottom .left-house').addClass('animated fadeInLeft').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',function(){
        $(this).removeClass('animated fadeInLeft');});
    $('.logo.bottom .right-house').addClass('animated fadeInRight').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',function(){
        $(this).removeClass('animated fadeInRight');}); */



    //修改用户入口
    $.get("/mgsc/in/getsession",function (data){
        //alert(data);
        if(data=="member"){
            $("#userentrance").text("Member space");
            $("#userentrance").attr("href","/mgsc/memberspace");
        }
        else if(data=="user"){

            $("#userentrance").text("User space");
            $("#userentrance").attr("href","/mgsc/userspace");
        }
    })


// $(".newsnav>li").on("click")


function nav_click()
{
    $(".nav-item.active,.dropdown,.dropdown-menu>li").each(function(){
        $($(this).children('a').hasClass("active")).hide();
        $($(this).children("ul").children("li").children('a').data("href")).hide();
        $($(this).children('a').data("href")).hide();
        $(this).removeClass("active");
      });
}
//test

    $(".navbar-nav>.dropdown").click(function (){
        nav_click();
        $("#Journals").fadeIn();
        console.log(this);
        document.getElementsByTagName("title")[0].innerText=this.children[1].children[0].innerText.trim()+" - YGWG ";

    })

    $(".dropdown-menu>li").on("click",function (e) {
        e.stopPropagation();  //防止向父节点
        nav_click();
        $($(this).parents("li")).addClass("active");
        $($(this).children('a').data("href")).fadeIn();
        document.getElementsByTagName("title")[0].innerText=this.innerText.trim()+ " - MGSC ";


    })


$(".nav-item").click(function(){
    nav_click();
    $("#Events").hide();
    $(this).addClass("active");
    $($(this).children('a').data("href")).fadeIn();
  
  if(this.innerText.match('Home')){
    document.getElementsByTagName("title")[0].innerText="MGSC of IGU- Modeling Geographical Systems Commission International Geographical Union (IGU)";
  }           
  else{
    document.getElementsByTagName("title")[0].innerText=this.innerText.trim()+" - MGSC ";
  }
});





// $(".home-ha").click(function(){
//     jump();
//     // $($("#Events").parent("li")).addClass("active");
//     $("#everntslink").addClass("active");
// });


/* 下拉菜单悬停  */
$(".dropdown").hover(function(){
    $($(this).children("ul")).show();
},function(){
    $($(this).children("ul")).hide();
})
$(".dropdown-menu").click(function(){
    $(this).hide();
})

function  jump(){
    //home新闻跳转
    $($(".nav-item").children('a').data("href")).each(function () {
        $("#Home").hide();
        $("#nav1").removeClass("active");

        $("#Events").fadeIn();
    });

}






//邮件
    $("#contactusemail").click(function (){
        //Contact us
        var c_name = document.getElementById("CName").value;
        var c_email = document.getElementById("CEmail").value;
        var c_message = document.getElementById("Cmessage").value;
        if(c_email==""){
            alert("Please enter your Email!")
        }
        else if(c_name=="")
        {
            alert("Please enter your name!");
        }
        else if(c_message=="")
        {
            alert("Please enter your message!");
        }
        else{

            //mzy
            $.post("https://formspree.io/f/mrgrprpw",
                {
                    From :"igu-geomodeling.com",
                    Name : c_name,
                    Email : c_email,
                    Message : c_message,
                },
                function () {
                    //
                });
            //lxt
            $.post("https://formspree.io/f/xdopdyoa",
                {
                    From :"igu-geomodeling.com",
                    Name : c_name,
                    Email : c_email,
                    Message : c_message,
                },
                function () {
                });

            document.getElementById("successfulcontactus").innerHTML = " Sucessfully submitted, Please Wait we will get back to you";
            console.log("sending contactus");
        }

    })

});



