$(document).ready(function(){
        $("#long_in_form").submit(function (event) {
    event.preventDefault();
    let userData = {
        email: $("#email").val(), // التقاط قيمة البريد الإلكتروني
        password: $("#password").val()
    };

    $.ajax({
        type: "POST",
        url: "/login",
        contentType: "application/json",
        data: JSON.stringify(userData),
       success: function (data) {
         localStorage.setItem('count_use', data.count_use);
    alert("تم نسجيل الدخول بنجاح");
    // توجيه المستخدم إلى الصفحة الرئيسية بعد نجاح تسجيل الدخول
    window.location.href = "../AI_page_web/ai2.html"; // قم بتغيير "home.html" إلى عنوان URL الصحيح لصفحتك الرئيسية
},

        error: function (error) {
            alert(error.responseText); // عرض رسالة فشل تسجيل الدخول
        }
    });
});
    });