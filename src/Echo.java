public class Echo {


    public static void main(String[] args) {
        String potentialItemCall = "rabba dabba do [son ]";


        int left = potentialItemCall.indexOf("[");
        int right = potentialItemCall.indexOf("]");
        System.out.println(left+right);
        String sub = potentialItemCall.substring(left+1, right);
        System.out.println(sub);


    }
}