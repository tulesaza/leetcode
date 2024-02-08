import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
          1         //n=1
         1 1        //n=2
        1 2 1       //n=3
       1 3 3 1      //n=4
      1 4 6 4 1     //n=5
    1 5 10 10 5 1   //n=6
  */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            var prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>(i + 1);
            currentRow.add(1);

            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }
}