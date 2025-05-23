$(function(){
    // Handle click on paging links
    $('.tm-paging-link').click(function(e){
        e.preventDefault();
        var page = $(this).text().toLowerCase();
        $('.tm-gallery-page').addClass('hidden');
        $('#tm-gallery-page-' + page).removeClass('hidden');
        $('.tm-paging-link').removeClass('active');
        $(this).addClass("active");
    });
    index.init();
    index.addOnclickEvent();

});

index = {
    init : function () {
       let loginCheck = localStorage.getItem('isLoggedIn');
       if(loginCheck != null && loginCheck =='true'){
           $('#login').text('logout').attr("href", "../shop/logout").attr("id","logout");
           $('#logout').on("click",function () {
                localStorage.removeItem('isLoggedIn');
                $('#login').text('login').attr("href", "../shop/login").attr("id","login");
           });
       }
    },
    addOnclickEvent : function () {
        $('.tm-nav-li a').on('click',function () {
            if($(this).attr("href") == 'javascript:void(0);'){
                $.ajax({
                    url:getContextPath() + "/isCheckUser",
                    type:"post",
                    contentType: "application/json",
                    success:function (result) {
                        if(result.code != '200'){
                            alert(result.msg);
                            return
                        }
                    }
                });
            }
        });
    }
}