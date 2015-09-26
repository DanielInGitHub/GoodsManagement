package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.GoodsConsumedaoImpl;
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
public class GetGoodsServiceImpl implements BaseServiceI<GoodsConsumeDto> {
    @Autowired
    @Qualifier("goodsConsumedaoImpl")
    private GoodsConsumedaoImpl goodsConsumedaoImpl;

    public void addEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumedaoImpl.insert(GoodsConsumeDto);
    }

    public void modifyEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumedaoImpl.updateByPrimaryKey(GoodsConsumeDto);
    }

    public GoodsConsumeDto loadEntity(int id) {
        return null;
    }

    public GoodsConsumeDto getEntity(int id) {
        return goodsConsumedaoImpl.selectByPrimaryKey(id);
    }

    public List<GoodsConsumeDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumedaoImpl.deleteByPrimaryKey(GoodsConsumeDto.getId());
    }

    /**
     * 通过id来获取显示信息
     * @param id id
     * @return vo
     */
    public GetGoodsVO getGoodsById(int id) {
        return goodsConsumedaoImpl.getGoodsById(id);
    }

}
