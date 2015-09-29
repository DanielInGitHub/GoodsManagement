package org.fiveguns.service.impl;

import com.github.pagehelper.PageHelper;
import org.fiveguns.dao.impl.GoodsConsumeDaoImpl;
import org.fiveguns.po.GoodsConsumeDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.vo.GoodsConsumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by johnny on 2015/9/23.
 */
@Service
public class GoodsConsumeServiceImpl implements BaseServiceI<GoodsConsumeDto> {

    @Autowired
    @Qualifier("goodsConsumeDaoImpl")
    private GoodsConsumeDaoImpl goodsConsumeDaoImpl;

    public void addEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumeDaoImpl.insert(GoodsConsumeDto);
    }

    public void modifyEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumeDaoImpl.updateByPrimaryKey(GoodsConsumeDto);
    }

    public GoodsConsumeDto loadEntity(int id) {
        return null;
    }

    public GoodsConsumeDto getEntity(int id) {
        return goodsConsumeDaoImpl.selectByPrimaryKey(id);
    }

    public List<GoodsConsumeDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumeDaoImpl.deleteByPrimaryKey(GoodsConsumeDto.getId());
    }

    /**
     * 获得所有的实体类，加入分页支持
     *
     * @param page      想要获取的页码
     * @param rowCounts 一页的数量
     * @return
     */
    public List<GoodsConsumeVo> getEntitiesByPage(int page, int rowCounts) {
        return goodsConsumeDaoImpl.getEntitiesByPage(page, rowCounts);
    }

    public int getCounts() {
        return goodsConsumeDaoImpl.getCounts();
    }

}
