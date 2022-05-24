package permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private int parameter;
    private List<Integer> initList = new ArrayList<>();
    private List<Boolean> visitList = new ArrayList<>();
    private List<Integer> resultList = new ArrayList<>();

    public Permutation(int parameter) {
        if(parameter < 1){
            throw new IllegalArgumentException("파라미터가 0보다 커야 합니다.");
        }
        this.parameter = parameter;
        addInitList();
        addVisitList();
    }

    public void exec(int depth) {
        if (depth == parameter) {
            resultPrint();
            return;
        }

        for (int i = 0; i < parameter; i++) {
            if(!visitList.get(i)){
                visitList.set(i, true);
                resultList.add(depth, initList.get(i));
                this.exec(depth + 1);
                visitList.set(i, false);
            }
        }
    }

    private void resultPrint() {
          for (int i = 0; i < parameter; i++) {
             System.out.print(resultList.get(i) + "");
        }

        System.out.println();
    }

    private void addInitList() {
        for (int i = 1; i <= parameter; i++) {
            initList.add(i);
        }
    }

    private void addVisitList() {
        for (int i = 0; i < parameter; i++) {
            visitList.add(i, false);
        }
    }
}


