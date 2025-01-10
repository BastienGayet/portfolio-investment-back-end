package com.example.portfolio.controller;



import com.example.portfolio.dto.RegisterDTO;
import com.example.portfolio.models.UsersModel;
import com.example.portfolio.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UsersModel> getUsers() {

        List<UsersModel> users = usersService.getUsers();
        System.out.println("UsersController: Retrieved users: " + users);
        return users;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String hashedpassword) {
        // Validation de l'utilisateur avec les données de login
        UsersModel user = usersService.login(email, hashedpassword);

        System.out.println("UsersController: Retrieved user: " + user);
        System.out.println("UsersController: Checking password... " + hashedpassword);

        if (user != null) {
            return ResponseEntity.ok("Connexion réussie!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides.");
        }
    }

    // Endpoint de login uniquement accessible via POST
   /* @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getHashedPassword();

        // Validation de l'utilisateur avec les données de login
        UsersModel user = usersService.login(email, password);

        if (user != null) {
            return ResponseEntity.ok("Connexion réussie!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides.");
        }
    }*/



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        // Enregistrement de l'utilisateur
        boolean isRegistered = usersService.registerUser(registerDTO);

        if (isRegistered) {
            return ResponseEntity.ok("Utilisateur enregistré avec succès!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de l'inscription.");
        }
    }

}
