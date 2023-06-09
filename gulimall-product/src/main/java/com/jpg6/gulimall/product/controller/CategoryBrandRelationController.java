package com.jpg6.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jpg6.gulimall.product.entity.BrandEntity;
import com.jpg6.gulimall.product.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jpg6.gulimall.product.entity.CategoryBrandRelationEntity;
import com.jpg6.gulimall.product.service.CategoryBrandRelationService;
import com.jpg6.common.utils.PageUtils;
import com.jpg6.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author Maserhe
 * @email maserhelinux@gmail.com
 * @date 2023-05-24 19:20:54
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;



    /**
     * 获取分类关联的品牌
     */
    @RequestMapping(value = "/brands/list", method = RequestMethod.GET)
    // @RequiresPermissions("product:categorybrandrelation:list")
    public R relationBrandsList(@RequestParam(value = "catId", required = true) Long catId){
        // 查找该分类下的所有 品牌
        List<BrandEntity> list = categoryBrandRelationService.getBrandsByCatId(catId);
        List<BrandVo> brandVos = list.stream().map(t -> {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandName(t.getName());
            brandVo.setBrandId(t.getBrandId());
            return brandVo;
        }).collect(Collectors.toList());

        return R.ok().put("data", brandVos);
    }


    /**
     * 列表
     */
    @RequestMapping(value = "/catelog/list", method = RequestMethod.GET)
    // @RequiresPermissions("product:categorybrandrelation:list")
    public R categoryList(@RequestParam("brandId") Long brandId){
        List<CategoryBrandRelationEntity> list = categoryBrandRelationService.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));

        return R.ok().put("data", list);
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		// categoryBrandRelationService.save(categoryBrandRelation);
        categoryBrandRelationService.saveDetail(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
