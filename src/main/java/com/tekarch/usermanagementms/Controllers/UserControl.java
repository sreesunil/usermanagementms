package com.tekarch.usermanagementms.Controllers;

import com.tekarch.usermanagementms.Models.Accounts;
import com.tekarch.usermanagementms.Models.Users;
import com.tekarch.usermanagementms.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControl {

    private final UserService userService;



    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<?> addLinkedAccount(@PathVariable String userId, @RequestBody Accounts account) {
        return ResponseEntity.ok(userService.addLinkedAccount(userId, account));
    }



}
