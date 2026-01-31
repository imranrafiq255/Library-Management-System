package com.example.imran.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length = 50)
    private String memberName;
    @Column(nullable = false, length = 50, unique = true)
    private String memberContactNumber;
    @Column(nullable = false, length = 30, unique = true)
    private String memberEmail;
    @Column(nullable = false, length = 30, unique = true)
    private String membershipId;
}
