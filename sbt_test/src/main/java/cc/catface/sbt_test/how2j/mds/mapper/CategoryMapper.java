package cc.catface.sbt_test.how2j.mds.mapper;

import cc.catface.sbt_test.how2j.mds.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    int save(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    int update(Category category);

}