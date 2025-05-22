let $insertForm;
let $insertValidateForm;
$(function(){

    $insertForm = $("#loginForm");
    initForm();
    addOnclickEvent();
});

/*
添加按鈕事件
 */
function addOnclickEvent() {
    $("#loginButton").on("click",function () {

        if (!$("#loginForm").valid()) {
               return false;
        }

        $.ajax({
            url:getContextPath() + "/isCheckUser",
            type:"post",
            contentType: "application/json",
            data:JSON.stringify($insertForm.serializeJSON()),
            success:function (result) {
                if(result.code != '200'){
                    alert(result.msg);
                    return
                }
                window.location.href = getContextPath() +result.data.url;
                index.loginCheck = 'true';
            }
        });
    });
}
/*
 初始化表單驗證
 */
function initForm() {

    $.validator.addMethod("mustBeOpenAI", function(value, element) {
        return value!="";
    });

    $insertValidateForm = $("#loginForm").validate(getValidationSettings({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 20,
                mustBeOpenAI: true
            },
            password:{
                required: true,
                minlength: 3,
                maxlength: 20,
                mustBeOpenAI: true
            }
        },
        messages: {
            username: {
                required: "請輸入使用者名稱",
                minlength: "使用者名稱至少需要 {0} 個字元",
                maxlength: "使用者名稱不能超過 {0} 個字元"
            },
            password: {
                required: "請輸入密碼",
                minlength: "密碼至少需要 {0} 個字元",
                maxlength: "密碼不能超過 {0} 個字元"
            }
        }
    }));
}