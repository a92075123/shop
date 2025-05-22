function getValidationSettings(customSettings = {}) {
    const defaultSettings = {
        errorElement: "span",
        errorClass: "error-message",
        errorPlacement: function(error, element) {
            error.insertAfter(element);
        },
        highlight: function(element, errorClass) {
            $(element).addClass("input-error");
            $(element).closest(".form-group").addClass("has-error");
        },
        unhighlight: function(element, errorClass) {
            $(element).removeClass("input-error");
            $(element).closest(".form-group").removeClass("has-error");
        }
    };

    // 合併自訂選項
    return { ...defaultSettings, ...customSettings };
}