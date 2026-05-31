package lambda.ex2;

public class ComposeExample1 {

    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return new MyTransformer() {
            @Override
            public String transform(String s) {
                return f2.transform(f1.transform(s));
            }
        };
    }

    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer addDeco = s -> "***".concat(s).concat("***");

        MyTransformer composeFunc =  compose(toUpper, addDeco);
        System.out.println(composeFunc.transform("hello"));
    }
}
