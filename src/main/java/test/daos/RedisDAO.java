package test.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import test.beans.Product;

@Repository
public class RedisDAO {
	 public static final String HASH_KEY = "Product";

	    @Autowired
	    private RedisTemplate template;

	    public Product save(Product product){
	        template.opsForHash().put(HASH_KEY,product.getId(),product);
	        return product;
	    }

	    public List<Product> findAll(){
	        return template.opsForHash().values(HASH_KEY);
	    }

	    public Object findProductById(int id){
	        System.out.println("called findProductById() from DB");
	        return template.opsForHash().get(HASH_KEY,id);
	    }


	    public String deleteProduct(int id){
	         template.opsForHash().delete(HASH_KEY,id);
	        return "product removed !!";
	    }
}
