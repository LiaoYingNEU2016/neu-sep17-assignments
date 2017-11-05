package assignment4;

public class IpAddress {
    String dottedDecimal;
    String getDottedDecimal(){
        return dottedDecimal;
    }
    IpAddress(String s){
        this.dottedDecimal = s;
    }
    int getOctet(int n){
        String[] Octets = dottedDecimal.split(".");
        int Octet = Integer.parseInt(Octets[n-1]);
        return Octet;
    }
    public static void main(String args[]){
        IpAddress ip = new IpAddress("216.27.6.136");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
    }
}
