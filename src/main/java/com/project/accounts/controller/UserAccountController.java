package com.project.accounts.controller;

import com.project.accounts.dto.UserAccountRequestDto;
import com.project.accounts.dto.UserAccountResponseDto;
import com.project.accounts.model.UserAccountEntity;
import com.project.accounts.service.IUserAccountServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/user-accounts")
public class UserAccountController {

    @Autowired
    private IUserAccountServices accountServices;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserAccountResponseDto>> getAllAccounts() {
        List<UserAccountEntity> accountEntities = accountServices.getAllUserAccounts();

        if (accountEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(accountEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAccountResponseDto> findAccountById(@PathVariable("id") @NotBlank Long id) {
        Optional<UserAccountEntity> optional = accountServices.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(toDto(optional.get()));
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity createAccount(@Valid @RequestBody UserAccountRequestDto request) {
        UserAccountEntity entity = accountServices.createAccount(toEntity(request));

        if (entity.getId() == null) {
            return ResponseEntity.ok().build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id") @NotBlank Long id) {
        Optional<UserAccountEntity> optional = accountServices.findById(id);

        if (optional.isPresent()) {
            accountServices.deleteAccount(optional.get());
            Map<String, String> bodyMap = new HashMap<>();
            bodyMap.put("message", "delete success");
            return ResponseEntity.ok().body(bodyMap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity updateAccount(@Valid @RequestBody UserAccountRequestDto request) {
        UserAccountEntity entity = accountServices.updateAccount(toEntity(request));

        if (entity.getId() == null) {
            return ResponseEntity.ok().build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }

    private UserAccountEntity toEntity(UserAccountRequestDto dto) {
        return modelMapper.map(dto, UserAccountEntity.class);
    }

    private UserAccountEntity toEntity(UserAccountResponseDto postDto) {
        return modelMapper.map(postDto, UserAccountEntity.class);
    }

    private UserAccountResponseDto toDto(UserAccountEntity entity) {
        return modelMapper.map(entity, UserAccountResponseDto.class);
    }
}
