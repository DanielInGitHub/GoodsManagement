package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.DeliverydaoImpl;
import org.fiveguns.po.DeliveryDto;
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
public class OutRepositoryServiceImpl implements BaseServiceI<DeliveryDto> {
    @Autowired
    @Qualifier("deliverydaoImpl")
    private DeliverydaoImpl deliverydaoImpl;

    public void addEntity(DeliveryDto DeliveryDto) {
        deliverydaoImpl.insert(DeliveryDto);
    }

    public void modifyEntity(DeliveryDto DeliveryDto) {
        deliverydaoImpl.updateByPrimaryKeySelective(DeliveryDto);
    }

    public DeliveryDto loadEntity(int id) {
        return null;
    }

    public DeliveryDto getEntity(int id) {
        return deliverydaoImpl.selectByPrimaryKey(id);
    }

    public List<DeliveryDto> getAllEntities() {
        return null;
    }

    public void deleteEntity(DeliveryDto DeliveryDto) {
        deliverydaoImpl.deleteByPrimaryKey(DeliveryDto.getId());
    }

    /**
     * 显示所有出库信息
     * @return
     */
    public List<OutRepositoryVO> getAllOutRepositoryVO() {
        return deliverydaoImpl.selectAll();
    }
}
