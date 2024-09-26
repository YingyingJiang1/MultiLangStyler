package org.example.style.name.segmenter; /**
 *
 * 版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
 *
 * 原文链接：https://blog.csdn.net/itbigpig/article/details/127026801
 *//*

package org.example.style.name.segmenter;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
*/
/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/10 21:52
 *//*

public class ENWordSegmenter {
  private ENDictionary dic = ENDictionary.getSingleton();
  //获取字典
  private Dictionary<String,Double> _MainDic = dic.get_ENMainDict();

  //获取字典里面字符最大长度
  private Integer maxLength = dic.getMaxLength();

  //定义一个损失数组
  private double[] cost;
  */
/**
   * 获取所有中文字
   * *//*

  private List<String> getChinese(String word){
    Pattern pattern = Pattern.compile("[^a-zA-Z0-9']+");
    Matcher matcher = pattern.matcher(word);
    List<String> list = new ArrayList<>();
    while (matcher.find()){
      list.add(matcher.group(0));
    }
    return list;
  }

  */
/**
   * 获取连续英文词块
   * *//*

  private String[] getEnglish(String word){
    Pattern pattern = Pattern.compile("[^a-zA-Z0-9']+");
    String[] enwords = pattern.split(word,-1);

    return enwords;
  }

  */
/**
   * 获取最小cost值
   * *//*

  private CostTuple best_macth(int i,double[] cost,String word){
    Integer start = Math.max(0, i-this.maxLength);

    //截取从0开始到i个字符的损失
    double[] costList = new double[i-start];
    System.arraycopy(cost, start,costList,0,i-start);
    double[] reverseCost = reverse(costList);

    Double v = Double.MAX_VALUE;
    Integer m = Integer.MIN_VALUE;

    for(int k=0;k<reverseCost.length;k++){
      Double c = reverseCost[k];
      c = c+(_MainDic.get(word.substring(i-k-1, i).toLowerCase())==null?9e99:_MainDic.get(word.substring(i-k-1, i).toLowerCase()));
      if(c<v){
        v = c;
        m=k+1;
      }
    }
    CostTuple costTuple = new CostTuple(v, m);

    return costTuple;
  }

  */
/**
   * 具体的分割类
   * *//*

  private List<String> split(String word){
    int length = word.length();
    cost = new double[length+1];
    cost[0]=0D;
    for(int i=1;i<length+1;i++){
      CostTuple costTuple = best_macth(i, cost, word);
      cost[i]=(double)costTuple.cost;
    }
    List<String> outList = new ArrayList<>();
    while (length>0){
      CostTuple costTupleBack = best_macth(length, cost, word);
      assert (double)costTupleBack.cost == cost[length];
      Boolean newToken = true;
      String subword = word.substring(length-(int)costTupleBack.wordlength, length);
      if(!subword.equals("'")){
        int listsize = outList.size();
        if(outList.size()>0){
          String lastString = outList.get(listsize-1);
          if(lastString.equals("'s") || (Character.isDigit(word.charAt(length-1)) && Character.isDigit(lastString.charAt(0)))){
            lastString = subword+lastString;
            outList.set(listsize-1,lastString);
            newToken = false;
          }
        }
      }
      if(newToken){
        outList.add(subword);
      }
      length -= (int)costTupleBack.wordlength;
    }
    return outList;
  }

  public List<String>  transFormSegmenter(String words) throws IOException {
    // List<String> cnWords = this.getChinese(words);
    String[] enwords = this.getEnglish(words);
    // assert cnWords.size()+1==enwords.length;
    List<String> resultList = new ArrayList<>();
    for(String word:enwords){
      List<String> wordLists = split(word);
      resultList.add(enlistToString(wordLists));
    }
    // int cnsize = cnWords.size();
    */
/*for(int i=0;i<cnsize;i++){
      resultList.add(2*i+1, cnWords.get(i));
    }*//*


    return resultList;
  }

  */
/**
   * 数组进行反转
   * *//*

  private static double[] reverse(double[]x){
    int length = x.length;
    for(int i=0;i<(length+1)/2;i++){
      swap(x, i, length-i-1);
    }
    return x;
  }
  private static void swap(double[]x,int i,int j){
    double temp = x[i];
    x[i] = x[j];
    x[j]=temp;
  }

  private static String enlistToString(List<String> list){
    String word ="";
    for(String str:list){
      if(!"".equals(str.trim())){
        word = (str+" ")+word;
      }

    }
    return word;
  }

  private static String listToString(List<String> list){
    String word ="";
    for(String str:list){
      if(!"".equals(str.trim())){
        word += (str+" ");
      }

    }
    return word;
  }

  class CostTuple<K,V>{
    private K cost;
    private V wordlength;

    public CostTuple(K cost,V wordlength){
      this.cost = cost;
      this.wordlength = wordlength;
    }
  }

}
*/
