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
    loginCheck : null,
    init : function () {
       console.log(index.loginCheck)
       if(this.loginCheck != null && this.loginCheck==true) {
           $('#login').text('logout').attr("href", "logout");
       }
    },
    addOnclickEvent : function () {
        $('.tm-nav-li a').on('click',function () {
            console.log($(this).attr('href'));
        });
    }

}