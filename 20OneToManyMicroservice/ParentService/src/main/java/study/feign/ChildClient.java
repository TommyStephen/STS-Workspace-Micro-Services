package study.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import study.DTO.ChildDTO;

@FeignClient(name = "ChildService")
public interface ChildClient {
    @GetMapping("child/by-parent/{parentId}")
    List<ChildDTO> getChildrenByParentId(@PathVariable("parentId") Long parentId);
}
