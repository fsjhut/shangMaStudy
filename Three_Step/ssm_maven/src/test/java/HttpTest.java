import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @className: HttpTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/24 20:59
 */
public class HttpTest {

    @Test
    public void httpTest() throws IOException {
        String path = "http://api.tianapi.com/txapi/tianqi/index?key=db3d22eebbff236d1b3b424ea12c3dd6&city=郑州市";
        URL url = new URL(path);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[2048];
        int r;
        StringBuffer str = new StringBuffer();
        while ((r=inputStream.read(bytes))!=-1){
//            System.out.println(r);
            str.append(new String(bytes,0,r));
        }
        System.out.println(str.toString());
    }

}
