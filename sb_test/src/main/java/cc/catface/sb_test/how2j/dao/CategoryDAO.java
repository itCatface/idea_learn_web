package cc.catface.sb_test.how2j.dao;

import cc.catface.sb_test.how2j.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
