package cc.catface.sb_test.how2j.dao;

import cc.catface.sb_test.how2j.pojo.CategoryPure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select(" select * from category_ where name like '%mapper%' ")
    List<CategoryPure> findSome();

    @Select(" select * from category_ ")
    List<CategoryPure> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    int insert(CategoryPure category);

    @Delete(" delete from category_ where id= #{id} ")
    void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    CategoryPure select(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    int update(CategoryPure category);


    List<CategoryPure> findAllByXML();
}
