package org.example.teamProject;

import org.example.teamProject.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamProjectApplicationTests {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Test
    public void repositoryTest() {
//        Long barcode = 11111111L;
//
//        InventoryEquipmentDTO dto = new InventoryEquipmentDTO();
//
//        BeanUtils.copyProperties(equipmentRepository.findByBarcode(barcode), dto);
//        System.out.println("##############" + dto.getStatus());

        System.out.println("###################" + System.getProperty("user.name"));
    }

}
