package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.GoodsConsumeDaoImpl;
import org.fiveguns.po.GoodsConsumeDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.vo.GetGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
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
     * 通过id来获取显示信息
     * @param id id
     * @return vo
     */
    public GetGoodsVO getGoodsById(int id) {
        return goodsConsumeDaoImpl.getGoodsById(id);
    }

}
