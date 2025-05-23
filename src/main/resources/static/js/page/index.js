$(function(){
    index.init();
    index.addOnclickEvent();
});

index = {
    
    //初始化
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

    //按鈕功能
    addOnclickEvent : function () {

        $('.tm-nav-link').on('click', function(e) {
            // 移除所有active類
            $('.tm-nav-link').removeClass('active');

            // 為當前點擊的連結添加active類
            $(this).addClass('active');
        });

        // 處理導航列點擊事件
        $('.tm-nav-li a').on('click', function() {
            let templateName = $(this).attr("id");
            // 如果是javascript:void(0)的連結，才進行ajax請求
            if($(this).attr("href") == 'javascript:void(0);'){
                $.ajax({
                    url: getContextPath() + "/pageTab",
                    type: "post",
                    data: templateName,
                    contentType: "application/json",
                    success: function(result) {
                        if(result.code != '200'){
                            return;
                        }
                        $(".tm-main-content").html(result.data.content);
                    }
                });
            }
        });
    }
}