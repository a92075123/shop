let insertForm;

$(function(){
    addOnclickEvent();
    insertForm = $("#loginForm");
});

/*
添加按鈕事件
 */
function addOnclickEvent() {

    $("#loginButton").on("click",function () {
        $.ajax({
            url:getContextPath() + "/isCheckUser",
            type:"post",
            contentType: "application/json",
            data:JSON.stringify(insertForm.serializeJSON()),
            success:function (result) {
                if(result.code != 200){
                    alert(result.msg);
                }
            }
        });
    });

}