package org.fiveguns.service.impl;

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
    private GoodsConsumeDaoImpl goodsConsumeDao;

    public void addEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumeDao.insert(GoodsConsumeDto);
    }

    public void modifyEntity(GoodsConsumeDto GoodsConsumeDto) {
        goodsConsumeDao.updateByPrimaryKey(GoodsConsumeDto);
    }

    public GoodsConsumeDto getEntity(int id) {
        return goodsConsumeDao.selectByPrimaryKey(id);
    }

    public void deleteEntity(int id) {
        goodsConsumeDao.deleteByPrimaryKey(id);
    }

    /**
     * 获得所有的实体类，加入分页支持
     *
     * @param page      想要获取的页码
     * @param rowCounts 一页的数量
     * @return
     */
    public List<GoodsConsumeVo> getEntitiesByPage(int page, int rowCounts) {
        return goodsConsumeDao.getEntitiesByPage(page, rowCounts);
    }

    /**
     * 获取记录数
     *
     * @return
     */
    public int getCounts() {
        return goodsConsumeDao.getCounts();
    }

}
