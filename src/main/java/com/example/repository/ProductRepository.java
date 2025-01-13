package com.example.repository;

import com.example.entity.Product;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final SqlSession sqlSession;

    public List<Product> findAll() {
        return sqlSession.selectList("Product.findAll");
    }

    public void add(Product product) {
        sqlSession.insert("Product.add", product);
    }

    public Product findById(Integer id) {
        return sqlSession.selectOne("Product.findById", id);
    }

    public void edit(Product product) {
        sqlSession.update("Product.edit", product);
    }

    public void delete(Integer id) {
        sqlSession.delete("Product.delete", id);
    }
}
