package com.example.grupptransportgroup.service;

import com.example.grupptransportgroup.error.GroupNotFoundException;
import com.example.grupptransportgroup.modell.Group;
import com.example.grupptransportgroup.repositpry.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public Group addGroup(Group group) {

        return groupRepository.save(group);
    }


    public Group getGroupById( Long id) {
        return groupRepository.findById(id).get();
      /*  Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return optionalGroup.get();
        } else {
            throw new GroupNotFoundException("Group not found with ID " + id);
        }*/
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void deleteGroupById(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            groupRepository.deleteById(id);
        } else {
            throw new GroupNotFoundException("Group not found with ID " + id);
        }
    }

    public void deleteAllGroups() {
        groupRepository.deleteAll();
    }
}