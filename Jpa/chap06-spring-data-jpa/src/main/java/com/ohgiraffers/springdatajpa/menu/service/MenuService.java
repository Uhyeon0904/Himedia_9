package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/* 롬복 라이브러리에서 제공하는 RequiredArgsConstructor 어노테이션을 사용하면
간결하게 생성자 주입이 가능하다. */
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    /* DTO와 엔터티의 객체 변환을 자동으로 해준다. */
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final HttpMessageConverters messageConverters;

/*    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }*/

    /* 1. findById */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        /* findById 메소드는 예외처리까지 선언을 해서 사용해야 한다. */
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundMenu, MenuDTO.class);
    }

    /* 2. findAll: Sort */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        /* 리스트 타입을 stream으로 변형 후 리스트 하나하나를 MenuDTO로 가공 후 다시 리스트 형태로 변형 */
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 3. findAll: pageable */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        /* PageRequest.of(): 를 사용해서 객체를 만들 수 있다. */
        pageable = PageRequest.of(
                /* getPageNumber(): 현재 보는 게 몇 페이지인지(offset) */
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                /* getPageSize(): 한 페이지에서 몇 페이지 씩 볼지(limit) */
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );
        Page<Menu> menuList = menuRepository.findAll(pageable);
        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* 4. Query Method */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPriceDesc(menuPrice);
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, Sort.by("menuPrice").descending());
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 5. JPQL or Native Query*/
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList =  categoryRepository.findAllCategory();
        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* 6. save(저장하다.) */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        /* save(): 인자로 엔티티 객체를 넣어줘야한다.
        * 메소드가 받는 파라미터는 MenuDTO 이기 때문에 가공해 줘야한다. */
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }

    /* 7. 수정(엔티티 객체 필드 값 변경) */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu foundMenu = menuRepository
                .findById(menuDTO.getMenuCode())
                .orElseThrow(IllegalArgumentException::new);
        /* 수정 후 해당 메*/
        foundMenu.modifyMenuName(menuDTO.getMenuName());
    }

    /* 8. deleteById */
    @Transactional
    public void deleteMenu(Integer menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
