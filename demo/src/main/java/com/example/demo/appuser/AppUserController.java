package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> getAllAppUsers () {
        List<AppUser> appUsers = appUserService.findAllAppUsers();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AppUser> getAppUserById (@PathVariable("id") Long id) {
        AppUser appUser = appUserService.findAppUserById(id);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AppUser> addAppUser(@RequestBody AppUser appUser) {
        AppUser newEmployee = appUserService.addAppUser(appUser);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser) {
        AppUser updateEmployee = appUserService.updateAppUser(appUser);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        appUserService.deleteAppUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}