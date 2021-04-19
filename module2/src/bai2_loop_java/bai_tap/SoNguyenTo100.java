package bai2_loop_java.bai_tap;
public class SoNguyenTo100 {
    public static void main(String[] args) {
        int n=2;
        String ketQua="";
        while (n<100){
            boolean check=true;
            for (int i=2;i<n;i++){
                if (n%i==0){
                    check=false;
                    break;
                }
            }
            if (check){
                ketQua+=n+",";
            }
            n++;
        }
        System.out.print("Các số nguyên tố nhỏ hơn 100 là: ");
        System.out.println(ketQua);
    }
}
