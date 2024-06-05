/* api 호출 */
import menus from '../data/menu-detail.json'

/* 전체 메뉴 목록 조회용 API */
/* 함수를 export 하는 방법, 함수 앞에 export 사용 */
export function getMenuList() {
    return menus;
}

/* 메뉴 코드를 이용하여 한 개의 상세 내용 조회 */
export function getMenuDetail(menuCode) {
    return menus.find(menu => menu.menuCode == menuCode);
}

/* 메뉴명 전달 받아 메뉴 이름을 포함하고 있는 메뉴 목록 조회 */
export function getSearchMenu(menuName) {
    /* api에 있는 메뉴와 검색한 메뉴 이름을 매치하여 포함하는 값을 true로 반환 한다. */
    return menus.filter(menu => menu.menuName.match(menuName));
}