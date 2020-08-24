public class Echo {


    public static void main(String[] args) {
        String potentialItemCall = "rabba: dabba ::do [son ]";


        int left = potentialItemCall.indexOf(":");

        String sub = potentialItemCall.substring(0,left);
        System.out.println(sub);


    }
}