//control

package com.example.firstWebApp.controles;
import com.example.firstWebApp.services.userServices;
import com.example.firstWebApp.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class userController {

    @Autowired
    private userServices userServices;
    @PostMapping("/users/addUser")
    public @ResponseBody user addUser(@RequestBody user u)
    {
        return userServices.addUser(u);
    }

    @GetMapping("/users/getAll")
    public @ResponseBody ArrayList<user> getAll()
    {
        return userServices.getAll();
    }

    @GetMapping("/user/findUserId/{id}")
    public @ResponseBody Optional<user> findUserById(@PathVariable Long id)
    {
        return userServices.findUserById(id);
    }

    // Endpoint لتحديث معلومات المستخدم
    @PutMapping("/users/updateUser/{id}")
    public ResponseEntity<user> updateUser(@RequestBody user updatedUser, @PathVariable Long id) {
        Optional<user> existingUser = userServices.findUserById(id);

        if (existingUser.isPresent()) {
            user savedUser = userServices.updateUserInfo(updatedUser, id);
            return ResponseEntity.ok().body(savedUser); // تم التحديث بنجاح
        } else {
            return ResponseEntity.notFound().build(); // لم يتم العثور على المستخدم
        }
    }
}
