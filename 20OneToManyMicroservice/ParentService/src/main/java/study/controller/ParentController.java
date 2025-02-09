package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.DTO.ChildDTO;
import study.feign.ChildClient;
import study.model.Parent;
import study.repository.ParentRepository;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildClient childClient;

    @GetMapping("/{id}/children")
    public List<ChildDTO> getChildren(@PathVariable("id") Long id) {
        // Ensure the parent exists
        parentRepository.findById(id).orElseThrow(()->new RuntimeException("Parent id invlaid"));

        // Fetch children from child-service
        return childClient.getChildrenByParentId(id);
    }
    
    @PostMapping("/save")
    public Parent saveParent(@RequestBody Parent parent) {
    	return parentRepository.save(parent);
    }
}
