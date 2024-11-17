package org.example.style.name.segmenter; /**
 *
 * 版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
 *
 * 原文链接：https://blog.csdn.net/itbigpig/article/details/127026801
 *//*

package org.example.style.name.segmenter;


import java.io.*;
import java.lang.module.Configuration;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

*/
/**

 自定义的连续英文分词

 *//*

public class ENDictionary {

  */
/**

   英文词典单例
   *//*

  private static ENDictionary singleton;
  */
/**

   英文词典对象
   *//*

  private Dictionary _ENMainDict;
  */
/**

   词的最大长度
   *//*

  private Integer maxLength = 0;

  private ENDictionary(Configuration cfg) throws FileNotFoundException {
    this.cfg = cfg;
    this.loadMainDict();
  }

  *

   词典初始化
   由于IK Analyzer的词典采用Dictionary类的静态方法进行词典初始化
   只有当Dictionary类被实际调用时，才会开始载入词典，
   这将延长首次分词操作的时间
   该方法提供了一个在应用加载阶段就初始化字典的手段
  public static void initial(Configuration cfg) throws FileNotFoundException {
    if(singleton == null){
      synchronized (ENDictionary.class){
        if(singleton == null){
          singleton = new ENDictionary(cfg);
          cfg.setUseMainDict(false);
        }
      }
    }
  }
  */
/**

   获取词典单子实例
   @return ENDictionary 单例对象
   *//*

  public static ENDictionary getSingleton(){
    if(singleton == null){
      throw new IllegalStateException("英文词典尚未初始化，请先调用initial方法");
    }
    return singleton;
  }
  */
/**

   批量增加英文词典
   *//*

  private void loadMainDict() throws FileNotFoundException {
    _ENMainDict = new Hashtable<String,Double>();
    List diclist = new ArrayList<>();
    try(InputStream is = Files.newInputStream(Paths.get("identifier.dic"));) {
      if(is == null){
        throw new RuntimeException("英文词典没有发现!");
      }
      BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8), 512);
      String theword;
//收集数据
      do{
        theword = br.readLine();
        if(theword!=null && !"".equals(theword.trim())){
          diclist.add(theword);
          Integer length = theword.length();
          if(maxLength<length){ //获取最大词的长度
            maxLength = length;
          }
        }
      }while (theword!=null);
//迭代数据，计算每个词cost,形成字典
      fillDictinary(_ENMainDict,diclist);
    } catch (IOException ioe){
      System.err.println("英文词典加载异常");
      ioe.printStackTrace();
    }
  }

  */
/**

   字典填充方法
   *//*

  private void fillDictinary(Dictionary dic,List diclist){
    Integer wordCount = diclist.size();
    for(int i=0;i<wordCount;i++){
      String word = (String) diclist.get(i);
      Double cost =cost(i, wordCount);
      dic.put(word, cost);
    }
  }

  */
/**

   计算每个词的损失
   @param i:单词在字典里位置，从0开始
   @param wordCount:词典里总单词数
   @return :返回单词的损失值
   *//*

  private double cost(Integer i,Integer wordCount){
    return Math.log((i+1)*Math.log(wordCount));
  }
  public Dictionary get_ENMainDict() {
    return _ENMainDict;
  }

  public Integer getMaxLength() {
    return maxLength;
  }

}


*/
