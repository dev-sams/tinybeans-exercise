package com.tinybeans.backend.evaluation.runner;

import com.tinybeans.backend.evaluation.dto.ItemDTO;
import com.tinybeans.backend.evaluation.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final ItemService itemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ItemDTO item = new ItemDTO();
        item.setName("Iphone");
        item.setDescription("The iPhone is a line of smartphones produced by Apple that use Apple's own iOS mobile operating system");
        item.setPhotoUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWoWomvhSBX2u8BeWgseh2eqavkxW4MkKl5Q&s");
        item.setPrice(10.0);

        ItemDTO item2 = new ItemDTO();
        item2.setName("MacBook Pro");
        item2.setDescription("MacBook Pro with M3, M3 Pro, and M3 Max chips. Up to 22 hours of battery life. The world's best laptop display. Now in a new color: Space Black.");
        item2.setPhotoUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmInxXBXYl2AIzQRCTxOM82FoyhAJFRP36iQ&s");
        item2.setPrice(100.0);

        ItemDTO item3 = new ItemDTO();
        item3.setName("Mouse");
        item3.setDescription("A computer mouse (plural mice, also mouses) is a hand-held pointing device that detects two-dimensional motion relative to a surface.");
        item3.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/3-Tasten-Maus_Microsoft.jpg/640px-3-Tasten-Maus_Microsoft.jpg");
        item3.setPrice(13.0);

        itemService.addItem(item);
        itemService.addItem(item2);
        itemService.addItem(item3);
    }
}
