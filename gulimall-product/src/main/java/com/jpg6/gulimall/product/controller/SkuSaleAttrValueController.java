package com.jpg6.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jpg6.gulimall.product.entity.SkuSaleAttrValueEntity;
import com.jpg6.gulimall.product.service.SkuSaleAttrValueService;
import com.jpg6.common.utils.PageUtils;
import com.jpg6.common.utils.R;



/**
 * sku销售属性&值
 *
 * @author Maserhe
 * @email maserhelinux@gmail.com
 * @date 2023-05-24 19:20:54
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:skusaleattrvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuSaleAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping(value = "/stringList/{skuId}")
    public List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId) {
        List<String> stringList = skuSaleAttrValueService.getSkuSaleAttrValuesAsStringList(skuId);
        return stringList;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("product:skusaleattrvalue:info")
    public R info(@PathVariable("id") Long id){
		SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);

        return R.ok().put("skuSaleAttrValue", skuSaleAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:skusaleattrvalue:save")
    public R save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){
		skuSaleAttrValueService.save(skuSaleAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:skusaleattrvalue:update")
    public R update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue){
		skuSaleAttrValueService.updateById(skuSaleAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:skusaleattrvalue:delete")
    public R delete(@RequestBody Long[] ids){
		skuSaleAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
