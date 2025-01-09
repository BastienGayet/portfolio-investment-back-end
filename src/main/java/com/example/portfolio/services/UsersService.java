package com.example.portfolio.services;

import com.example.portfolio.models.UsersModel;
import com.example.portfolio.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<UsersModel> getUsers() {
        //return usersRepository.findAll();  // Cette méthode doit renvoyer tous les utilisateurs de MongoDB

        List<UsersModel> users = userRepository.findAll();
        System.out.println("Retrieved users: " + users);  // Affiche les utilisateurs récupérés
        return users;
    }
}
