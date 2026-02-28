package cmdargs1;

public class CmdArgsTest {
    public static void main(String[] args){
        if(args.length==0)
            System.out.println(("无事发生"));
        else{
            try{
                int cnt=Integer.parseInt(args[0]);
                if(args.length>1) {
                    for(;cnt>0;cnt--)
                        System.out.println(args[1]);
                }else{
                    System.out.println(args[0]);
                }
            }
            catch (NumberFormatException e){
                System.out.println(args[0]);
            }
        }
    }
}
