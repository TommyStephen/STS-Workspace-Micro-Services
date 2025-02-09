package study.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.DTO.ChildDTO;
import study.entity.Child;
import study.repository.ChildRepository;

@RestController
@RequestMapping("/child")
public class ChildController {

	@Autowired
    private ChildRepository childRepository;

    @GetMapping("/by-parent/{parentId}")
    public List<ChildDTO> getChildrenByParentId(@PathVariable("parentId") Long parentId) {
        List<Child> children = childRepository.findByParentId(parentId);
        return children.stream().map(child -> {
            ChildDTO dto = new ChildDTO();
            dto.setId(child.getId());
            dto.setName(child.getName());
            dto.setDob(child.getDob());
            dto.setSalary(child.getSalary());
            return dto;
        }).collect(Collectors.toList());
    }
    
    @PostMapping("/save/{parentId}")
    public ChildDTO addChild(@PathVariable long parentId, @RequestBody Child child) {
    	child.setParentId(parentId);
    	Child savedChild = childRepository.save(child);
    	
    	return childMapper(savedChild);
    }
    
    ChildDTO childMapper(Child child){
    	ChildDTO childDTO = new ChildDTO();
    	if(child.getId()>0) {
    		childDTO.setId(child.getId());
    	}
    	childDTO.setName(child.getName() != null ? child.getName() : null);
    	childDTO.setSalary(child.getSalary() > 0 ? child.getSalary() : 0);
    	childDTO.setDob(child.getDob() != null ? child.getDob() : null);
    	
    	return childDTO;
    }
    
}
