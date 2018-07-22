package com.ccab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;


    /**
     *
     * 显示所有信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加信息
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl  girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 更新信息
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpadte(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age){
        //Girl girl = girlRepository.findById(id).get();
        //Girl girl = girlRepository.getOne(id);
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return girlRepository.save(girl);

    }

    /**
     * 删除信息
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        //girlRepository.deleteById(id);
        girlRepository.delete(id);
    }
}
