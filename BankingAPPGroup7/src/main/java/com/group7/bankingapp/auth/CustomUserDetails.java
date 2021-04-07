package com.group7.bankingapp.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.group7.bankingapp.domain.entity.User;

import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {

   
}
