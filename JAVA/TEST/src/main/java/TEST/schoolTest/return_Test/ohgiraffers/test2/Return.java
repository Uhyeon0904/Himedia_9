package TEST.schoolTest.return_Test.ohgiraffers.test2;

public class Return {
    public static void main(String[] args) {

        noReturn("김치"); //리턴 없이 일을 수행함. 재료 + 찌개만을 출력

        String food = haveReturn("김치"); //리턴 값을 변수에 저장해줄 수 있음.

        System.out.println(food + "찌개");
        System.out.println(food + "볶음");  //noReturn과 달리 여러가지 응용이 가능.

    }
    public static void noReturn(String food) {
        System.out.println(food + "찌개");
    }
    public static String haveReturn (String food) {
        return food;
    }
}
