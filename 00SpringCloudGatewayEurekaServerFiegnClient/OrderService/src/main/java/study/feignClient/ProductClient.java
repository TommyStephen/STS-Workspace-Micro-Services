package study.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import study.dto.Product;

	@FeignClient(name = "ProductService")
	public interface ProductClient {
	@GetMapping("/product/findById/{id}")
	Product getProductById(@PathVariable("id") Long productId);

	
}

