$(document).ready(function () {
    // Fetch data using AJAX

    function addRow(user) {
        $("#usersList").append("<tr><td>" + user.id + "</td>" +
            "<td>" + user.name + "</td>" +
            "<td>" + user.email + "</td>" +
            "<td>" + user.password + "</td>" +
            "<td>" + user.phoneNumber + "</td>" +
            "<td>" + user.cont_use + "</td>" +
            "<td>" +
            "<button onclick='findUserById(" + user.id + ")'>" + "Profile" + "</button>" +
            "</td>" +
            "</tr>");
    }

    $.ajax({
        type: "GET",
        url: "/users/getAll",
        success: function (users) {
            // Iterate through the products and display them in the table
            const usersList = $("#usersList");
            users.forEach(function (user) {
                usersList.append("<tr>" +
                    "<td>" + user.id + "</td>" +
                    "<td>" + user.name + "</td>" +
                    "<td>" + user.email + "</td>" +
                    "<td>" + user.password + "</td>" +
                    "<td>" + user.phoneNumber + "</td>" +
                    "<td>" + user.cont_use + "</td>" +
                    "<td>" +
                    "<button onclick='findUserById(" + user.id + ")'>" + "Profile" + "</button>" +
                    "</td>" +
                    "</tr>");
            });
        },
        error: function (error) {
            console.error("Error fetching product data: ", error);
        }
    });

    $("#userForm").submit(function (event) {
        event.preventDefault();
        let user = {
            name: $("#name").val(), // تصحيح الخطأ هنا
            email: $("#email").val(),
            password: $("#password").val(), // تصحيح الخطأ هنا
            phoneNumber: $("#phoneNumber").val(),
            cont_use: $("#cont_use").val()
        };

        $.ajax({
            type: "POST",
            url: "/users/addUser",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function () {
                alert("تم حفظ المستخدم بنجاح!");
                addRow(user);
            },
            error: function (error) {
                console.log("خطأ في حفظ المستخدم: ", error);
            }
        });
    });

    function findUserById(id) {
        $.ajax({
            type: "Get",
            url: "/user/findUserId/" + id,
            success: function (user) {
                alert("تم العثور على المستخدم بنجاح. الرقم التعريفي: " + user.id);
                window.location.href = "/profile.html?id=" + user.id;
            },
            error: function (error) {
                console.log("خطأ في البحث عن المستخدم: ", error);
            }
        });
    }

    async function encryptNumber(number, key) {
        const encoder = new TextEncoder();
        const data = encoder.encode(number.toString());

        // Import the key
        const keyObject = await crypto.subtle.importKey(
            'raw',
            encoder.encode(key),
            { name: 'AES-CBC' },
            false,
            ['encrypt', 'decrypt']
        );

        // Encrypt the data
        const encryptedData = await crypto.subtle.encrypt(
            { name: 'AES-CBC', iv: crypto.getRandomValues(new Uint8Array(16)) },
            keyObject,
            data
        );

        // Convert the encrypted buffer to a hexadecimal string
        const encryptedArray = Array.from(new Uint8Array(encryptedData));
        const encryptedHex = encryptedArray.map(byte => byte.toString(16).padStart(2, '0')).join('');

        return encryptedHex;
    }

    async function decryptNumber(encryptedHex, key) {
        // Import the key
        const keyObject = await crypto.subtle.importKey(
            'raw',
            new TextEncoder().encode(key),
            { name: 'AES-CBC' },
            false,
            ['encrypt', 'decrypt']
        );

        // Convert the hexadecimal string to a buffer
        const encryptedArray = encryptedHex.match(/.{1,2}/g).map(byte => parseInt(byte, 16));
        const encryptedBuffer = new Uint8Array(encryptedArray).buffer;

        // Decrypt the data
        const decryptedData = await crypto.subtle.decrypt(
            { name: 'AES-CBC', iv: new Uint8Array(16) },
            keyObject,
            encryptedBuffer
        );

        // Decode the decrypted data
        const decryptedText = new TextDecoder().decode(decryptedData);

        return decryptedText;
    }
    $.ajax({
        type: "POST",
url: "https://api.generativeai.dev/v1/models/gemini-pro:generate"
        headers: {
            "Authorization": "Bearer AIzaSyD7wiQi1KEerVDADHP8q-_0PgfiKpJw0vc",
            "Content-Type": "application/json"
        },
        data: JSON.stringify({
            "prompt": x,
            "max_tokens": 50
        }),
        success: function(response) {
            console.log(response.choices[0].text);
        },

        error: function(xhr, status, error) {
            console.error("Error:", error);
        }
    });

});
