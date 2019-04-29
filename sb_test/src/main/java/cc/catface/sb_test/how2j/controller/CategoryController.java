package cc.catface.sb_test.how2j.controller;

import cc.catface.sb_test.how2j.dao.CategoryDAO;
import cc.catface.sb_test.how2j.dao.CategoryMapper;
import cc.catface.sb_test.how2j.pojo.Category;
import cc.catface.sb_test.how2j.pojo.CategoryPure;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDAO dao;

    @RequestMapping(value = "/list_category")
    public String listCategory(Model model) throws Exception {
        List<Category> categories = dao.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("method_name", "listCategory");
        return "list_category";
    }


    @Autowired
    private CategoryMapper mapper;

    @RequestMapping("/list_category_by_mapper")
    public String listCategoryByMapper(Model model) throws Exception {
        List<CategoryPure> categories = mapper.findSome();
        model.addAttribute("categories", categories);
        model.addAttribute("method_name", "listCategoryByMapper");
        return "list_category";
    }


    @RequestMapping("/list_category_by_xml")
    public String listCategoryByXML(Model model) throws Exception {
        List<CategoryPure> categories = mapper.findAllByXML();
        model.addAttribute("categories", categories);
        model.addAttribute("method_name", "listCategoryByXML");
        return "list_category";
    }


    /**
     * CRUD
     */
    @RequestMapping("/insert_category")
    public String insertCategory(CategoryPure c) throws Exception {
        mapper.insert(c);
        return "redirect:list_category_page";
    }

    @RequestMapping("/delete_category")
    public String deleteCategory(CategoryPure c) throws Exception {
        mapper.delete(c.getId());
        return "redirect:list_category_page";
    }

    @RequestMapping("/update_category")
    public String updateCategory(CategoryPure c) throws Exception {
        mapper.update(c);
        return "redirect:list_category_page";
    }

    @RequestMapping("/edit_category")
    public String editCategory(int id, Model m) throws Exception {
        CategoryPure c = mapper.select(id);
        m.addAttribute("c", c);
        return "edit_category";
    }

    @RequestMapping("/list_category_page")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<CategoryPure> cs = mapper.findAll();
        PageInfo<CategoryPure> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "list_category_page";
    }


    /**
     * restful风格
     */
    @GetMapping("/categories")
    public String resListCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        org.springframework.data.domain.Page<Category> page = dao.findAll(pageable);
        m.addAttribute("page", page);
        return "restful_list_category";
    }

    @PostMapping("/categories")
    public String resInsertCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String resDeleteCategory(Category c) throws Exception {
        dao.delete(c);
        return "redirect:/categories";
    }

    @PutMapping("/categories/{id}")
    public String resUpdateCategory(Category c) throws Exception {
        dao.save(c);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String resGetCategory(@PathVariable("id") int id, Model m) throws Exception {
        Category c = dao.getOne(id);
        m.addAttribute("c", c);
        return "restful_edit_category";
    }
}
