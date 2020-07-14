package cn.jucheng.sell.repository;

import cn.jucheng.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
