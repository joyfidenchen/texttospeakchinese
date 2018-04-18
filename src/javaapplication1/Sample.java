/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "10034748";
    public static final String API_KEY = "THnLqpHQacKlemyUbOjseCz1";
    public static final String SECRET_KEY = "8843c1f64925cc82438d6cb3b793467e";

public String getSoundFilePath(String text)throws Exception 
   {
    
     String soundFilePath="c:/tmp/"+text+".mp3";
File soundFile=new File(soundFilePath);
if(!soundFile.exists())
{
  generateSoundFile(text);  
}
       return soundFilePath;
   }

    
  private void generateSoundFile(String text)throws Exception 
   {
          // 初始化一个FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用API
   //     JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
   //     System.out.println(res.toString(2));
       HashMap<String, Object> options = new HashMap<String, Object>();
    options.put("spd", "3");
    options.put("pit", "5"); //音调，取值0-9，默认为5中语调
    options.put("per", "0");//voice  发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女
    
    TtsResponse res = client.synthesis(text, "zh", 1, options);
    System.out.println(res.getResult());
    
     String soundFilePath="c:/tmp/"+text+".mp3";
                        FileOutputStream fos = new FileOutputStream(soundFilePath);
            byte[] b=res.getData();
  
                fos.write(b);          
           
            fos.close();
       
   }
    
    public static void main(String[] args) throws Exception {
     
String text1="游子吟 慈母手中线 游子身上衣 临行密密缝 意恐迟迟归 谁言寸草心 报得三春晖";
        String text2= "江雪 千山鸟飞绝 万径人踪灭 孤舟蓑笠翁 独钓寒江雪";

 // String text="insect scale crept speak carving oval purse mossy cattle offer hairpin clipper marsh shabby hushed manner scraped impact breeze standoff narrow lazily primers marbles tennis world kettle shelves crumpled mailboxes perhaps nannies button alley sprinkle complete diaper transporting lukewarm violet castle bicycle village promptly matron produce horrid invitation faucet enormous";
 // String[] words=text.split(" ");
 Sample sample=new Sample();
 String soundFilePath1=sample.getSoundFilePath(text1);
       MP3 mp31 = new MP3(soundFilePath1);
        mp31.play();
        
        String soundFilePath2=sample.getSoundFilePath(text2);
    //      MP3 mp32 = new MP3(soundFilePath2);
   //     mp32.play();
   
        /*
 for(String word:words)
 {
String soundFilePath=sample.getSoundFilePath(word);
       MP3 mp3 = new MP3(soundFilePath);
        mp3.play();
        TimeUnit.SECONDS.sleep(1);
          mp3.play();
        TimeUnit.SECONDS.sleep(5);
 }
 */
    
    }
}