package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.DeliverydaoImpl;
import org.fiveguns.poo.OutRepositoryDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.vo.OutRepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OutRepositoryService
 * Created by Johnny on 2015/9/26.
 */
@Service
public class OutRepositoryServiceImpl implements BaseServiceI<OutRepositoryDto> {
    @Autowired
    @Qualifier("deliverydaoImpl")
    private DeliverydaoImpl deliverydaoImpl;

    public void addEntity(OutRepositoryDto outRepositoryDto) {
        deliverydaoImpl.insert(outRepositoryDto);
    }

    public void modifyEntity(OutRepositoryDto outRepositoryDto) {
        deliverydaoImpl.updateByPrimaryKeySelective(outRepositoryDto);
    }

    public OutRepositoryDto loadEntity(int id) {
        return null;
    }

    public OutRepositoryDto getEntity(int id) {
        return deliverydaoImpl.selectByPrimaryKey(id);
    }

    public List<OutRepositoryDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(OutRepositoryDto outRepositoryDto) {
        deliverydaoImpl.deleteByPrimaryKey(outRepositoryDto.getId());
    }

    /**
     * 显示所有出库信息
     * @return
     */
    public List<OutRepositoryVO> getAllOutRepositoryVO() {
        return deliverydaoImpl.selectAll();
    }
}
