package com.geekarms.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kaywer on 2016/12/28.
 */
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "authority_name", nullable = false, length = 32)
    private String authorityName;

    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL)
    private List<Role> role;

    public String getAuthority() {
        return authorityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
