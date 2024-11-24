package org.example.teamproject;

import org.example.teamproject.dto.EquipmentDTO;
import org.example.teamproject.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamProjectApplicationTests {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Test
    public void repositoryTest() {
        Long barcode = 11111111L;

        EquipmentDTO dto = new EquipmentDTO();

        BeanUtils.copyProperties(equipmentRepository.findByBarcode(barcode), dto);
        System.out.println("##############" + dto.getStatus());
    }
    /*
    TODO dto 로 값 전달받는걸 확인 했으니 html 과 controller 에서 status 에 따라 rental, return 을 정해 값 전달해주기?
    status 가 ON_FREE 또는 null 값일 경우 빌릴 수 있고, ON_RENTAL 이면 반납할 수 있게 만들기
    그럼 html 에서 값에 따라 테이블을 다르게 세팅해줘야하나? 정보 입력하는 input 은 괜찮은데 button 이랑 action 바꿔주기?
    restcontroller 도 2개 만들어서 각각 다르게 작동하게 세팅해주기? 내일까지 목표
     */

}
