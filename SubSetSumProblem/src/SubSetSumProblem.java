import java.time.LocalDate;
import java.util.*;

public class SubSetSumProblem {

    HashMap<Key,List<Integer>> map = new HashMap<>();


    public List<Integer> subSetSumProblem(List<Integer> set, int k){
        System.out.println();
        System.out.println("=========Time Analysis Result of the Algorithm =========");

        long startTime = new Date().getTime();
        System.out.println("Start time = " +startTime+" ms");

        //Option1 ==========without MEMOIZATION==================
        List<Integer> result = subSetSumProblem2(set,k);

        //Option2 ===========with MEMOIZATION====================
        //Uncomment to check this
        //List<Integer> result = subSetSumProblemEnhanced(set,k);

        long endTime = new Date().getTime();
        System.out.println("End time = "+endTime+" ms");

        System.out.println(" time taken = " + (endTime - startTime)+" ms");

        System.out.println("=========Result of the Subset Sum Problem =========");

        return result;
    }


    public List<Integer> subSetSumProblem2(List<Integer> set, int k){
      if(set.size()==1){
          if(k==0) return new ArrayList<Integer>();
          else if(set.get(0)==k) return set;
          else return null;
      }
      int x = set.remove(set.size()-1);
      List<Integer> temp = subSetSumProblem2(set,k);
      if(temp!=null) return temp;
      List<Integer> temp2 = subSetSumProblem2(set,k-x);
      if(temp2!=null){
          temp2.add(x);
          return temp2;
      }
        return null;
    }

    public List<Integer> subSetSumProblemEnhanced(List<Integer> set, int k){
        if(set.size()==1){
            if(k==0) return new ArrayList<Integer>();
            if(set.get(0)==k) return set;
            return null;
        }
        int x = set.remove(set.size()-1);
        Key key = new Key(set,k);
        List<Integer> temp = map.get(key);
        if(temp==null){
            temp = subSetSumProblemEnhanced(set,k);
            map.put(key,temp);
        }
        if(temp!=null)
            return temp;
        Key key2 = new Key(set,k-x);
        List<Integer> temp2 = map.get(key2);
        if(temp2==null){
            temp2 = subSetSumProblemEnhanced(set,k-x);
            map.put(key2,temp2);
        }
        if(temp2!=null){
            temp2.add(x);
            return temp2;
        }

        return null;
    }

    public static void main(String[] args){

        List<Integer> setx = new ArrayList<>();

        //Initialize the set with distinct integer values => value from 0 to 99
       for(int i=0;i<100;i++){
           setx.add(i);
       }

       //find the subset of setx whose elements add up to 55
        SubSetSumProblem ssp = new SubSetSumProblem();
        System.out.println(ssp.subSetSumProblem(setx,55));

    }



}
