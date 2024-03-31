$.ajax({
    type: "GET",
    url: "/users/getAll",
    success: function(users) {
        // Iterate through the users and display them in the table
        users.forEach(function(user) {
            // إنشاء صف جديد
            var $row = $("<tr>").append(
                $("<td>").text(user.id),
                $("<td>").text(user.name),
                $("<td>").text(user.email),
                $("<td>").text(user.password),
                $("<td>").text(user.count_use),
                $("<td>").text(user.phoneNumber),
                $("<td>").append(
                $("<button>").text("Profile").click(function() { findUserById(user.id); }),
                $("<button>").text("Delete").click(function() { deleteUserById(user.id); })
                )
            );

            // إضافة الصف إلى الجدول
            $("#usersList").append($row);
        });
    },
    error: function(error) {
        console.error("Error fetching user data: ", error);
    }
});

    // Define deleteUserById outside $(document).ready
    function deleteUserById(userId) {
        $.ajax({
            type: "DELETE",
            url: "/user/delete/" + userId,
            success: function (response) {
                // Handle success, like removing the row from the table
                console.log("User deleted successfully");
            },
            error: function (error) {
                console.error("Error deleting user: ", error);
            }
        });
    }