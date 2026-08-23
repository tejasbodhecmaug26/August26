class main29 {
    public static void main(String[] args) {

           String str1 = new String("Hello");
            String str2 = new String("World");
	    String str3 = (str1 + str2);

        System.out.println("String :"+str3);
	System.out.println("Is str3 pointing to the same object as str1? "+(str3 == str1));
           
}
}