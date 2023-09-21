package com.example.projectinstagram.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photo;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts=new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments=new ArrayList<>();
    @ManyToMany(cascade = CascadeType.PERSIST , fetch=FetchType.EAGER)
    private List<com.example.springsecurity.entities.Role> roleList;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //boucler sur notre liste de roles ci-dessus
        //créer une liste contenant plusieurs SimpleGrantedAuthority
        //retourner cette liste de SimplegrantedAuthority
        Collection<GrantedAuthority> authorities= new ArrayList<>() ;

        for (com.example.springsecurity.entities.Role role: this.roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return this.roleList.stream().map(role-> new SimpleGrantedAuthority(role.getName())).toList();


    }

    @Override
    public String getUsername() {
        return null;
    }


}
