package com.example.test.test2.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.test2.Domain.Ability;
import com.example.test.test2.Service.accessoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class accessoryController {

    private final accessoryService accessoryService;

    @ResponseBody
    @GetMapping("/access/list")
    public ResponseEntity<List<Ability>> callAllAbilList(Model model) {
        List<Ability> abil;
        abil = accessoryService.getDatabase();
        
        return new ResponseEntity<>(abil, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/access/list/{name}")
    public ResponseEntity<List<Ability>> callAbilList(@PathVariable(name = "name") String name, Model model) {
        List<Ability> abil;
        abil = accessoryService.getDatabaseByName(name);
        
        return new ResponseEntity<>(abil, HttpStatus.OK);
    }
}
