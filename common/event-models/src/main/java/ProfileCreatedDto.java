package com.quantilearn.eventmodels;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreatedDto{
    private String email;
    private String firstName;
    private String lastName;
}