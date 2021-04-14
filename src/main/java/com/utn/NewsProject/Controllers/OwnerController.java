package com.utn.NewsProject.Controllers;

import com.utn.NewsProject.Models.OwnerNews;
import com.utn.NewsProject.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/")
    public List<OwnerNews> getAll(@RequestParam(required = false) String name) {
        return ownerService.getAll(name);
    }

    @GetMapping("/{id}")
    public OwnerNews getById(@PathVariable String id) {
        return ownerService.getById(id);
    }

    @PostMapping("/")
    public void addOwner(@RequestBody OwnerNews ownerNews) {
        ownerService.addOwner(ownerNews);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody OwnerNews ownerNews) {
        ownerService.delete(ownerNews);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ownerService.deleteById(id);
    }

    @PutMapping("/{idOwner}/news/{idNews}")
    public void addNewsToOwner(@PathVariable String idOwner, @PathVariable Integer idNews) {
        ownerService.addNewsToOwner(idOwner,idNews);
    }


}
