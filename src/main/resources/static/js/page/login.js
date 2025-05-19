// 切換密碼可見性
document.querySelector('.toggle-password').addEventListener('click', function() {
    const passwordInput = document.getElementById('password');
    const passwordToggle = this;

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        passwordToggle.classList.remove('fa-eye-slash');
        passwordToggle.classList.add('fa-eye');
    } else {
        passwordInput.type = 'password';
        passwordToggle.classList.remove('fa-eye');
        passwordToggle.classList.add('fa-eye-slash');
    }
});

// 表單提交事件
document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    // 這裡可以加入表單驗證和提交邏輯
    alert('登入功能將在後端整合後啟用');
});