package org.fiveguns.service.impl;

import org.fiveguns.dao.impl.DeliveryDaoImpl;
import org.fiveguns.po.DeliveryDto;
import org.fiveguns.service.BaseServiceI;
import org.fiveguns.vo.DeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OutRepositoryService
 * Created by Johnny on 2015/9/26.
 */
@Service
public class DeliveryServiceImpl implements BaseServiceI<DeliveryDto> {

    @Autowired
    @Qualifier("deliveryDaoImpl")
    private DeliveryDaoImpl deliveryDaoImpl;

    public void addEntity(DeliveryDto DeliveryDto) {
        deliveryDaoImpl.insert(DeliveryDto);
    }

    public void modifyEntity(DeliveryDto DeliveryDto) {
        deliveryDaoImpl.updateByPrimaryKeySelective(DeliveryDto);
    }

    public DeliveryDto getEntity(int id) {
        return deliveryDaoImpl.selectByPrimaryKey(id);
    }

    public void deleteEntity(int id) {
        deliveryDaoImpl.deleteByPrimaryKey(id);
    }

    /**
     * 显示所有出库信息
     * @return
     */
    public List<DeliveryVo> getAllDeliveryVo() {
        return deliveryDaoImpl.selectAll();
    }
}
