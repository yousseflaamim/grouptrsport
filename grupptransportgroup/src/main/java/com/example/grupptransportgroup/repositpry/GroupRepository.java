package com.example.grupptransportgroup.repositpry;

import com.example.grupptransportgroup.modell.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}