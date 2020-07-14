package cn.jucheng.sell.repository;

import cn.jucheng.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory category = repository.findById(1).orElse(null);

        System.out.println(category.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory category = new ProductCategory();
        category.setCategoryName("favorite2");
        category.setCategoryType(2);
        repository.save(category);

    }

    @Test
    public void findByCategoryTypeInTest(){
        List<ProductCategory> list = repository.findByCategoryTypeIn(Arrays.asList(2,3));
        System.out.println(list.size());
    }
}