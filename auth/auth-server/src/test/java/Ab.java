import org.junit.Test;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 15:41 2018/3/9
 * Modified By:
 */
public class Ab {

    @Test
    public void testA(){
        String a = "abc";
        String[] split = a.split(",");
        for(String s:split){
            System.out.println(s);
        }

    }
}
