package cn.zhueian.algorithm.搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiucy on 2019/10/15.
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。

 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，
    员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，
    因此没有体现在员工1的数据结构中。

 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。

 示例 1:

 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 输出: 11
 解释:
 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 注意:

 一个员工最多有一个直系领导，但是可以有多个直系下属
 员工数量不超过2000。
 */
public class T690_员工的重要性 {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) return 0;
        int res = 0;
        Queue<Integer> temp = new LinkedList<>();
        temp.add(id);
        for (;!temp.isEmpty();){
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                Integer tId = temp.poll();
                a:for (int j = 0; j < employees.size(); j++) {
                    if (employees.get(j).id == tId){
                        Employee e = employees.get(j);
                        res+=e.importance;
                        if (e.subordinates!=null && !e.subordinates.isEmpty()){
                            List<Integer> s = e.subordinates;
                            for (int k = 0; k < s.size(); k++) {
                                temp.add(s.get(k));
                            }
                        }
                        break a;
                    }
                }
            }
        }
        return res;
    }

    /**
     * best
     * @param employees
     * @param id
     * @return
     */
    public int best(List<Employee> employees, int id){
        return employees.
                stream().
                filter(e -> e.id == id).
                mapToInt(e -> e.importance + e.subordinates.stream().mapToInt(s -> getImportance(employees, s)).
                        sum()).
                sum();
    }


    public static void main(String[] args) {
        T690_员工的重要性 t = new T690_员工的重要性();
        List<Employee> ems = new ArrayList();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 2;
        ArrayList<Integer> forE1 = new ArrayList<>();
        forE1.add(2);
        e1.subordinates = forE1;


        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        ArrayList<Integer> forE2 = new ArrayList<>();
        e2.subordinates = forE2;

        ems.add(e1);
        ems.add(e2);
        t.getImportance(ems,2);
    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
