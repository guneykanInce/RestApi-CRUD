package com.project.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccountResponseDto extends RepresentationModel<UserAccountResponseDto> implements Serializable {

    @JsonProperty("id")
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private String country;

    private String department;
}
