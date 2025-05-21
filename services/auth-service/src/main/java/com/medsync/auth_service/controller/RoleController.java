package com.medsync.auth_service.controller;

import com.medsync.auth_service.dto.RoleDto;
import com.medsync.auth_service.dtoService.RoleDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    private final RoleDtoService roleDtoService;

    public RoleController(RoleDtoService roleDtoService){
        this.roleDtoService=roleDtoService;
    }

    @PostMapping
    public ResponseEntity<Long> createRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleDtoService.createRole(roleDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAllRole(){
        return new ResponseEntity<>(roleDtoService.getAllRole(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateRole(@RequestBody RoleDto roleDto){
        roleDtoService.updateRole(roleDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable("id") long id){
        roleDtoService.deleteRole(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
