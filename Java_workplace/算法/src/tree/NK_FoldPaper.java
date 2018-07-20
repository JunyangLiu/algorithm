package tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NK_FoldPaper {
    public String[] foldPaper(int n) {
      List<String> list=new ArrayList<>();  
      fold(n,true,list);
      String[] strings=new String[list.size()];
      for (int i = 0; i < list.size(); i++) {
          strings[i]=list.get(i);
      }
      return strings;
    }
    public void fold(int level,Boolean flag,List<String> list){
    	if(level==0){
    		return;
    	}
    	fold(level-1, true, list);
        list.add(flag?"down":"up");
        fold(level-1, false, list);
    }
    
	   @Test 
	   public void test(){
		   foldPaper(2);
	   }
}
