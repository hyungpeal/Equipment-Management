package org.example.teamproject.controller;

import org.example.teamproject.dto.EquipmentDTO;
import org.example.teamproject.entity.Equipment;
import org.example.teamproject.service.EquipmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/inventoryPage")
@RestController
public class InventoryRestController {

    @Autowired
    EquipmentService service;

    @GetMapping("/")
    public List<Equipment> getInventory() {
        return service.findAll();
    }

    @PostMapping("/addEquipment")
    public ResponseEntity<String> addEquipment(EquipmentDTO dto, @RequestParam("image") MultipartFile file) {

        // dto 받은 것을 객체에 복사
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(dto, equipment);

        if (file != null && !file.isEmpty()) {

            // 저장할 경로인 images 폴더 없으면 만들어주기
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
            File dir = new File(uploadDir);

            if(!dir.exists()){
                dir.mkdir();
            }

            // 동적 파일 이름: 랜덤 UUID 값 사용
            String fileName = "image_" + UUID.randomUUID() + ".png";

            File dest = new File(dir, fileName);

            // 이미지 저장 경로
            String imagePath = "/images/" + fileName;

            try {
                // 저장
                file.transferTo(dest);
                equipment.setImage(imagePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to upload" + file.getOriginalFilename());
            }

            System.out.println("equipment: " + equipment);

            if(service.insert(equipment) != null) {
                return ResponseEntity.ok().body("{\"status\": \"ok\"}");
            }

        }

        return ResponseEntity.badRequest().body("{\"status\": \"error\", \"message\": \"잘못된 요청입니다.\"}");
    }

    @GetMapping("/searchEquipment")
    public List<Equipment> searchEquipment(@RequestParam("equipmentName") String equipmentName) {
        return service.findByEquipmentName(equipmentName);
    }

}
