public class Main {
    

    public static void main(String[] args) {
        Main main = new Main();

        /* The code below:
         * does not run the interfaceMethod
         * it just creates an object with method implementation
         * and passes that object to method
         */
        main.addInterface(SomeClass::someMethod);

    }

    public void addInterface(SomeInterface interfaceObject){
        String text = interfaceObject.interfaceMethod( "Dinshu", 69);//here the interface method runs
        System.out.println(text);
    }
}

