package com.example.portfolio.services;

import com.example.portfolio.dto.RegisterDTO;
import com.example.portfolio.models.UsersModel;
import com.example.portfolio.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<UsersModel> getUsers() {
        //return usersRepository.findAll();  // Cette méthode doit renvoyer tous les utilisateurs de MongoDB

        List<UsersModel> users = usersRepository.findAll();
        System.out.println("Retrieved users: " + users);  // Affiche les utilisateurs récupérés
        return users;
    }

    public UsersModel login(String email, String hashedPassword) {

        UsersModel user = usersRepository.findByEmail(email);
        if(user != null && BCrypt.checkpw(hashedPassword, user.getHashedPassword())) {
            return user;
        }
        return null;
    }

    public boolean registerUser(RegisterDTO registerDTO) {
        // Vérification si l'email existe déjà
        if (usersRepository.findByEmail(registerDTO.getEmail()) != null) {
            return false;  // Utilisateur déjà existant
        }

        // Création du modèle d'utilisateur
        UsersModel user = new UsersModel();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());

        // Hachage du mot de passe
        String hashedPassword = BCrypt.hashpw(registerDTO.getPassword(), BCrypt.gensalt());
        user.setHashedPassword(hashedPassword);

        // Enregistrement de l'utilisateur dans la base de données
        usersRepository.save(user);
        return true;
    }
}