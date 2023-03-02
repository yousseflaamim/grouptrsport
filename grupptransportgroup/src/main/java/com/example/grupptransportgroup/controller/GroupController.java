package com.example.grupptransportgroup.controller;

import com.example.grupptransportgroup.modell.Group;
import com.example.grupptransportgroup.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/addGroup")

    public ResponseEntity<List<Group>> addCar(@RequestBody Group group) {
        groupService.addGroup(group);
        List<Group> addGroup = groupService.getAllGroups();
        return ResponseEntity.status(HttpStatus.CREATED).body(addGroup);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id);
        return ResponseEntity.ok(group);
    }

    @GetMapping("/getAllGroups")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllGroups")
    public ResponseEntity<Void> deleteAllGroups() {
        groupService.deleteAllGroups();
        return ResponseEntity.noContent().build();
    }
}
